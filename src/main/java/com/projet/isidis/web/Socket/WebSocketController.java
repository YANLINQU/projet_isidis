package com.projet.isidis.web.Socket;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class WebSocketController {

    @Bean
    public ChatWebSocketHandler infoHandler() {
        return new ChatWebSocketHandler();
    }

    @RequestMapping("/websocket/loginPage")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/websocket/login";
    }

    @RequestMapping("websocket/login/{nom_resto}")
    public boolean login(HttpServletRequest request, HttpServletResponse response,
                        @PathVariable String nom_resto) throws Exception {
        String username = nom_resto;
        HttpSession session = request.getSession(true);
        session.setAttribute("SESSION_USERNAME", username); //conserver le user dans une session
        //System.out.println("session_username:"+(String) session.getAttribute("SESSION_USERNAME"));
        return true;
    }

    @RequestMapping("/websocket/send")
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }

    @RequestMapping("/websocket/broad")
    public  String broad() {
        infoHandler().sendMessageToUsers(new TextMessage("发送一条小Broad"));
        System.out.println("群发成功");
        return "broad";
    }


}
