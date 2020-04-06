package cl.icap.cursofullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
    @RequestMapping("/")
    public String getHome() {
        return "home";
    }
   
    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }
 	
    @RequestMapping("/index")
    public String getIndex() {
        return "index";
    }
   
    @RequestMapping("/employees_page")
    public String getEmployees() {
        return "employees";
    }
    
    @RequestMapping("/jobs_page")
    public String getJobs() {
        return "jobs";
    }
}
