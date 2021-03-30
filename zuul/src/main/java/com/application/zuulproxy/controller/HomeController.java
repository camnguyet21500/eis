package com.application.zuulproxy.controller;

import com.application.zuulproxy.api.UserApi;
import com.application.zuulproxy.model.Users;
import com.application.zuulproxy.service.UserService;
import com.jayway.jsonpath.DocumentContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    UserApi userApi;

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

//    @GetMapping(value = "/login")
//    public String login(HttpServletRequest httpServletRequest) throws Exception {
//
////        HttpSession httpSession = httpServletRequest.getSession(false);
////        if (httpSession != null) {
////            Users employee = sessionBean.getEmployee(httpSession);
////            if (employee != null && "ADMIN".equals(employee.getRole())) {
////                return "admin";
////            }
////            if (employee != null) {
////                return "index";
////            }
////        }
//        return "login";
//    }
    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/showUser")
    public String showUser() {
        return "ShowUser";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "AddUser";
    }

    @GetMapping("/addInvoice")
    public String addInvoice() {
        return "AddInvoice";
    }

    @GetMapping("/showTypeInvoice")
    public String showTypeInvoice() {
        return "ShowTypeInvoice";
    }

    @GetMapping("/addTypeInvoice")
    public String addTypeInvoice() {
        return "AddTypeInvoice";
    }

    @GetMapping("/showCompany")
    public String showCompany() {
        return "ShowCompany";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "AddCompany";
    }

//    @GetMapping("/chart")
//    public String chart() {
//        return "Chart"; // Trả về hello.html
//    }

    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
            HttpSession httpSession) {
        try {
            String res = userApi.validate(username, password);
            DocumentContext dc = userService.toDocumentContext(res);
            String role = dc.read("$.role", String.class).toUpperCase();
            String code = dc.read("$.code", String.class);

            Users user = new Users();
            user.setCode(code);
            user.setRole(role);
            user.setName(username);
            System.out.println(res);
            if(res!=null) {
                httpSession.setAttribute("account", user.getName());
                return "ADMIN".equalsIgnoreCase(((Users) httpSession.getAttribute("user")).getRole()) ?
                        "admin" : "index";
            } else {
                return "login";
            }
        } catch (Exception e) {
            return "login";
        }

    }

}