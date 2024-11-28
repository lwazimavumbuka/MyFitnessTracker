package com.myproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.FoodItem;
import com.myproject.model.Foods;
import com.myproject.model.Goals;
import com.myproject.model.MacrosRemaining;
import com.myproject.model.Meal;
import com.myproject.model.TodayMeal;
import com.myproject.repository.FoodsRepo;
import com.myproject.repository.GoalsRepo;
import com.myproject.repository.MacrosRemainingRepo;
import com.myproject.repository.MealRepo;

@Controller
public class DashboardController {

    @Autowired
    private GoalsRepo goalsRepo;

    @Autowired
    private FoodsRepo foodsRepo;
    
    @Autowired
    private MealRepo mealRepo;

    private String usernameString;
    
    private List<TodayMeal> todayMeals;

    @Autowired
    private MacrosRemainingRepo macrosRemainingRepo;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("username") String username, Model model){
        usernameString = username;
        Optional<Goals> usergoals = goalsRepo.findById(username);
        Optional<MacrosRemaining> macrosRemaining = macrosRemainingRepo.findById(1);

        model.addAttribute("remainingKJ", macrosRemaining.get().getKilojoules());
        model.addAttribute("remainingProtein", macrosRemaining.get().getProtein()+"g");
        model.addAttribute("remainingCarbs", macrosRemaining.get().getCarbs()+"g");
        model.addAttribute("remainingFats", macrosRemaining.get().getFats()+"g");
        
        model.addAttribute("currentweight", usergoals.get().getCurrentweight()+"kg");
        model.addAttribute("weightgoal", usergoals.get().getWeightgoal()+"kg");
        model.addAttribute("goalkilojoules", usergoals.get().getKilojoules()+"kj per day");
        model.addAttribute("protein", usergoals.get().getProtein()+"g per day");
        model.addAttribute("carbs", usergoals.get().getCarbs()+"g per day");
        model.addAttribute("fats", usergoals.get().getFats()+"g per day");

        List<Foods> foods = foodsRepo.findAll();
        model.addAttribute("foods", foods);


        //List Today Meals
        List<Meal> meals = mealRepo.findAll();

        todayMeals = new ArrayList<>();

        for(Meal meal: meals){
            TodayMeal todayMeal = new TodayMeal();
            todayMeal.setName(meal.getMealSlot());
            todayMeal.setFooditems(meal.toString().replace("[", "").replace("]", "").replace(", ", ""));
     //       System.out.println(todayMeal.toString());

            // here i am calculating the macros for todays meal
            int mealKj =0 , mealProtein = 0, mealcarbs = 0, mealfats = 0;

            List<FoodItem> todayItems =  meal.getFooditems();

            for(FoodItem fooditem: todayItems){
                List<Foods> food = foodsRepo.findByFoodname(fooditem.getFoodSelect());
                int amount = Integer.parseInt(fooditem.getFoodAmount())/100;
                mealKj += amount*food.get(0).getKilojoules();
                mealProtein += amount*food.get(0).getProtein();
                mealcarbs += amount*food.get(0).getCarbs();
                mealfats += amount*food.get(0).getFats();   
            }
            todayMeal.setKj(mealKj);
            todayMeal.setPrtn(mealProtein);
            todayMeal.setCrbs(mealcarbs);
            todayMeal.setFts(mealfats);
            todayMeal.setMacros(todayMeal.macroString(mealKj, mealProtein, mealcarbs, mealfats));
            todayMeals.add(todayMeal);    
            
        }
        model.addAttribute("todayMeals",todayMeals);


        return "dashboard";
    }
    
    @PostMapping("/confirmMeal")
    public String confirmMeal(@RequestParam("mealName") String mealname){
        Optional<MacrosRemaining> macrosremaining = macrosRemainingRepo.findById(1);
        System.out.println(mealname);
        for(int i = 0; i < todayMeals.size(); i++){
            if(todayMeals.get(i).getName().equals(mealname)){
                macrosremaining.get().setCarbs(macrosremaining.get().getCarbs()-todayMeals.get(i).getCrbs());
                macrosremaining.get().setFats(macrosremaining.get().getFats()-todayMeals.get(i).getFts());
                macrosremaining.get().setKilojoules(macrosremaining.get().getKilojoules()-todayMeals.get(i).getKj());
                macrosremaining.get().setProtein(macrosremaining.get().getProtein()-todayMeals.get(i).getPrtn());
                macrosRemainingRepo.save(macrosremaining.get());
                todayMeals.remove(i);
                break;
                //System.out.println(confirmedMeal.getMacros());
                
            }
            
        }
        return "redirect:/dashboard?username="+usernameString;
    }
    
    @PostMapping("/edit-currentweight")
    public String editCurrentWeight(@RequestParam("currentweight") int currentweight){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setCurrentweight(currentweight);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-weight")
    public String editWeightGoal(@RequestParam("newweight") int newweight){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setWeightgoal(newweight);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-kilojoules")
    public String editKilojoules(@RequestParam("newkilojoules") int newkilojoules){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        Optional<MacrosRemaining> macrosRemaining = macrosRemainingRepo.findById(1);
        usergoals.get().setKilojoules(newkilojoules);
        macrosRemaining.get().setKilojoules(newkilojoules);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-carbs")
    public String editCarbs(@RequestParam("newcarbs") int newcarbs){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        Optional<MacrosRemaining> macrosRemaining = macrosRemainingRepo.findById(1);
        macrosRemaining.get().setCarbs(newcarbs);
        usergoals.get().setCarbs(newcarbs);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("new-protein")
    public String editProtein(@RequestParam("newprotein") int newprotein){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        Optional<MacrosRemaining> macrosRemaining = macrosRemainingRepo.findById(1);
        macrosRemaining.get().setProtein(newprotein);
        usergoals.get().setProtein(newprotein);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-fats")
    public String editFats(@RequestParam("newfats") int newfats){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        Optional<MacrosRemaining> macrosRemaining = macrosRemainingRepo.findById(1);
        macrosRemaining.get().setFats(newfats);
        usergoals.get().setFats(newfats);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/log-item")
    public String addFood(@RequestParam("foodname") String foodname,
                            @RequestParam("kilojoules") int kilojoules,
                            @RequestParam("carbs") int carbs,
                            @RequestParam("protein") int protein,
                            @RequestParam("fats") int fats){
        Foods foods = new Foods(foodname, kilojoules, carbs, protein, fats);
        foodsRepo.save(foods);
        return "redirect:/dashboard?username="+usernameString;
    }

    public String addWorkout(){
        
        return "redirect:/dashboard?username"+usernameString;
    }
}
