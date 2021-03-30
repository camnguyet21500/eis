package com.application.zuulproxy.service;

import com.application.zuulproxy.api.UserApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jayway.jsonpath.Configuration;


@Service
public class UserService  {
    @Autowired
    private UserApi userApi;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("123 "+username);
//        Users user= userApi.findUserByUsername(username);
//        return User.withUsername(user.getUsername()).roles(user.getRole()).password(user.getPassword()).build();
//    }

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Configuration configuration;

    public String writeValueAsString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public DocumentContext toDocumentContext(String s) {
        return JsonPath.using(configuration).parse(s);
    }
}
