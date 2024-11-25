package com.myproject.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.Goals;
import com.myproject.model.User;
import com.myproject.repository.UserRepo;
import com.myproject.repository.GoalsRepo;

@Controller
public class IndexController {
    
    @Autowired(required=true)
    private GoalsRepo goalsRepo;

    @Autowired(required=true)
    private UserRepo userRepo;

    @GetMapping("/")
    public String index(){
        System.out.println("hi i am here ");
        return "index";
    }

    @PostMapping("/loginform")
    public String login(@ModelAttribute User user){
        System.out.println(user.toString());
        String username = user.getUsername();

        Optional<User> userdata = userRepo.findById(username);

        if(userdata.isPresent()){
            if(user.getPassword().equals(userdata.get().getPassword())){
                return "redirect:/dashboard?username="+username;
            }
        }
        else{
            throw new NoSuchElementException("User cannot be found");
        }
        return "index";
    }

    @PostMapping("/registerform")
    public String register(@RequestParam("username") String username, 
                            @RequestParam("password") String password,
                            @RequestParam("currentweight") int currentweight, 
                            @RequestParam("weightgoal") int weightgoal,
                            @RequestParam("kilojoules") int kilojoules,
                            @RequestParam("protein") int protein,
                            @RequestParam("carbs") int carbs,
                            @RequestParam("fats") int fats){
                                
        User user = new User(username, password);
        userRepo.save(user);
        
        Goals goals = new Goals(username, currentweight, weightgoal, kilojoules, protein, carbs, fats);
        goalsRepo.save(goals);

        System.out.println(user.toString());

        return "redirect:dashboard?username="+username;
    }
}
