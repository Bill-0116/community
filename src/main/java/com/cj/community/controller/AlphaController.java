package com.cj.community.controller;

import com.cj.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("data")
    @ResponseBody
    public String getData(){
       return alphaService.getData();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){

    }
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current",required = false,defaultValue = "1")int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    @RequestMapping(path="/students/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id")int id) {
        System.out.println(id);

        return "a students";
    }
    @RequestMapping(value = "/student",method =RequestMethod.POST)
    @ResponseBody
    public String saveStuent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    @RequestMapping(path="/school",method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }
    @RequestMapping(path ="/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        HashMap<String, Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age","22");
        emp.put("salary","4000");
        return emp;
    }

}
