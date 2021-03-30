package com.application.zuulproxy.api;

import com.application.zuulproxy.model.Users;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user")
public interface UserApi {

//    @GetMapping(value = "/users/username/{username}")
//    Users findUserByUsername(@RequestHeader @PathVariable("username") String username);

    @GetMapping(value = "/validate")
    String validate(@RequestParam("username") String username, @RequestParam("password") String password);
}
