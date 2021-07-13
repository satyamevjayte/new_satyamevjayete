package com.satyamevjayate.api.config;

import com.google.gson.Gson;
import com.satyamevjayate.api.entity.DAOUser;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TokenGaneration {

    public String tokengeneration(String email,String pwd)
    {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(headers.getContentType());
        String uriau="http://localhost:8080/authenticate";
        System.out.println(""+uriau);
        RestTemplate restTemplate = new RestTemplate();

        DAOUser daoUser=new DAOUser();
        daoUser.setUsername(email);
        daoUser.setPassword(pwd);
        Gson gson=new Gson();
        String objjson=gson.toJson(daoUser);
        HttpEntity<DAOUser> request = new HttpEntity(objjson, headers);
        System.out.println(request);
        String token=restTemplate.postForObject(uriau,request,String.class);

        System.out.println(token.toString());
        return token.toString();
    }



}
