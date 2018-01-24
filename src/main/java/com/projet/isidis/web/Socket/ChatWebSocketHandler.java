package com.projet.isidis.web.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

public class ChatWebSocketHandler extends TextWebSocketHandler {
    //private final static List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());
    private static Logger logger = LoggerFactory.getLogger(ChatWebSocketHandler.class);

    private static final Map<String, WebSocketSession> users;  //Map users

    private static final String USER_ID = "WEBSOCKET_USERID";   //the key

    static {
        users =  new HashMap<String, WebSocketSession>();
    }

    public ChatWebSocketHandler() {}

    //recuperer le meesage et envoyer
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //chatTextMessageHandler(message.getPayload());
        super.handleTextMessage(session, message);

        /**
         * recevoire le message et traitement
         */
        System.out.println("Recu le message："+message);
        if(message.getPayload().startsWith("#SuShiKan#")){ //envoyer a user SuShiKan
            System.out.println("send message to SuShiKan");
            sendMessageToUser("SuShiKan", new TextMessage(message.getPayload())) ;
        }

    }
    //traitement apres connecter
    @SuppressWarnings("unchecked")
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connecter success!");
        String userId = (String) session.getAttributes().get(USER_ID);
        users.put(userId,session);
        System.out.println(userId+" se connecter!");
        System.out.println("Users on line:"+users.size());
        //sessions.add(session);
    }
    //traitement apres se connecter
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("websocket chat connection closed......");
        String userId= (String) session.getAttributes().get(USER_ID);
        System.out.println("User:"+userId+" se deconnecter！");
        users.remove(userId);
        System.out.println("le nombre de User on line:"+users.size());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * envoyer un meesage a un user
     *
     * @param userId
     * @param message
     */
    public void sendMessageToUser(String userId, TextMessage message) {
        for (String id : users.keySet()) {
            System.out.println("users.key:"+id);
            if (id.equals(userId)) {
                try {
                    if (users.get(id).isOpen()) {
                        users.get(id).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    /**
     * send message aux tous les users
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                if (users.get(userId).isOpen()) {
                    users.get(userId).sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
