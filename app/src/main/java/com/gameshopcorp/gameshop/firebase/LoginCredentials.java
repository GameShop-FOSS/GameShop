package com.gameshopcorp.gameshop.firebase;

import java.util.UUID;

public class LoginCredentials {

    private String username;
    private String password;
    private String fid;

    public LoginCredentials(String username, String password, String fid){
        //UUID.randomUUID().toString();
         this.username = username;
         this.password = password;
         this.fid = fid;
    }

    public String getUsername(){

        return username;
    }

    public String getPassword(){

        return password;
    }

    public String getFid() {
        return fid;
    }
}
