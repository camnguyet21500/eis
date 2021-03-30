package com.application.zuulproxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home"; // Trả về home.html
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello"; // Trả về hello.html
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Trả về hello.html
    }

    @GetMapping(value = "/login")
    public String login(HttpServletRequest httpServletRequest) throws Exception {

//        HttpSession httpSession = httpServletRequest.getSession(false);
//        if (httpSession != null) {
//            Users employee = sessionBean.getEmployee(httpSession);
//            if (employee != null && "ADMIN".equals(employee.getRole())) {
//                return "admin";
//            }
//            if (employee != null) {
//                return "index";
//            }
//        }
        return "login";
    }
    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
    @GetMapping("/showUser")
    public String showUser() {
        return "ShowUser"; // Trả về hello.html
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "AddUser"; // Trả về hello.html
    }

    @GetMapping("/addInvoice")
    public String addInvoice() {
        return "AddInvoice"; // Trả về hello.html
    }

    @GetMapping("/showTypeInvoice")
    public String showTypeInvoice() {
        return "ShowTypeInvoice"; // Trả về hello.html
    }

    @GetMapping("/addTypeInvoice")
    public String addTypeInvoice() {
        return "AddTypeInvoice"; // Trả về hello.html
    }

    @GetMapping("/showCompany")
    public String showCompany() {
        return "ShowCompany"; // Trả về hello.html
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "AddCompany"; // Trả về hello.html
    }

    @GetMapping("/chart")
    public String chart() {
        return "Chart"; // Trả về hello.html
    }

}