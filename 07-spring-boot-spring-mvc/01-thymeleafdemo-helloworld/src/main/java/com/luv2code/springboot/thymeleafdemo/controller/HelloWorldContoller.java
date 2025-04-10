package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldContoller {

    @PostMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsshoutDude(HttpServletRequest request, Model model)
    {
        String theName=request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result="Yo! "+theName;
        model.addAttribute("message",result);
        return "helloworld";
    }
@RequestMapping("/processFormVersionThree")
public String letsshoutDude(@RequestParam("studentName") String theName,Model model)
{
    theName=theName.toUpperCase();
    String result="Hey my Friend! "+theName;
    model.addAttribute("message",result);
    return "helloworld";
}
}
