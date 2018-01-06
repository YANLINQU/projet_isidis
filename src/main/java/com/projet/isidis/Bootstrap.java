package com.projet.isidis;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by QYL on 2018/1/3.
 */
@Component
public class Bootstrap {
    @PostConstruct
    public void init(){
        try {
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
