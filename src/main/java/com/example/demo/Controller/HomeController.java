package com.example.demo.Controller;

import com.example.demo.Service.Member;
import com.example.demo.Service.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.metal.MetalMenuBarUI;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    ModelService modelImp;

    public List<Member> loggedInMember;
    private int id;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/login")
    public String logIn(Model model) {
        log.info("Login site entered");
        model.addAttribute("member", new Member());
        return "login";
    }


    @PostMapping("/login")
    public String logIn(@ModelAttribute Member member, Model model) {

        System.out.println(member.toStringUsername());
        log.info("User tried to login");


            if (modelImp.memberLogin(member) == true)
            {
                loggedInMember = new ArrayList<Member>();
                Member mem = modelImp.findByUsername(member);
                loggedInMember.add(mem);
                model.addAttribute(id);
                log.info("Login Succesful");
                    model.addAttribute("members",loggedInMember);
                    model.addAttribute("models" ,modelImp.isLoggedIn());
                    return "home";
            }


        log.info("Login failed");
        return "login";

    }

    @GetMapping("/tour")
    public String tour(Model model) {
        log.info("Tour viewed");
        return "tour";
    }

    @GetMapping("/about")
    public String about(Model model, Member member) {

        // TEST PÅ RESTTemplate!! Skal køres samtidig med Demo!
        /*String forObject = restTemplate.getForObject("http://localhost:8081", String.class);
        log.info("test: " + forObject);*/

        model.addAttribute("models" ,modelImp.isLoggedIn());
        model.addAttribute("member", member);

        return "about";
    }

    @GetMapping(value = {"/", "home"})
    public String index(Model model, Member member) throws SQLException {

        model.addAttribute("models" ,modelImp.isLoggedIn());
        model.addAttribute("members", loggedInMember);
        model.addAttribute("firstname" , member.getFirstname());

        // VI skal loade tours herfra før vi returner et view
        return "home";
    }




    @GetMapping("/signup")
    public String signUp(Model model) {
        log.info("Sign Up site entered");

        model.addAttribute("member", new Member());

        log.info("After Model.addAttribute");
        return "signUp";
    }


    @PostMapping("/signup")
    public String signUp(@ModelAttribute @Valid Member member, BindingResult bindingResult, Model model) {
        log.info("member signing up");

        if (bindingResult.hasErrors())
        {
            return "signUp";
        }
        if (modelImp.addAMember(member) == false)
        {
            log.info("member succesfully signed up");
            return "home";
        }
        else
            return "signup";
    }

    @GetMapping("/MyGuide")
    public String myGuide(Model model)
    {
        log.info("My Guide site entered");

        return "MyGuide";
    }


    @GetMapping("/createTour")
    public String createTour(@ModelAttribute Member member,  Model model){
        log.info("WHAT!!");
        model.addAttribute("members" ,loggedInMember);
        model.addAttribute("models" ,modelImp.isLoggedIn());
        return "createTour";
    }
}
