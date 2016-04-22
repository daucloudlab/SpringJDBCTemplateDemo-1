package kz.tezdet.lessons.springjdbc.controllers;

import kz.tezdet.lessons.springjdbc.domains.User;
import kz.tezdet.lessons.springjdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageController {
    @Autowired
    private UserService userService ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "redirect:/register" ;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerUser(@ModelAttribute("user") User user){
        List<String> genderList = new ArrayList<String>() ;
        genderList.add("male") ;
        genderList.add("female") ;

        List<String> cityList = new ArrayList<String>() ;
        cityList.add("Shymkent") ;
        cityList.add("Astana") ;
        cityList.add("Алматы") ;
        cityList.add("Түркістан") ;

        Map<String, List> map = new HashMap<String, List>() ;
        map.put("genderList", genderList) ;
        map.put("cityList", cityList) ;
        return new ModelAndView("register", "map", map) ;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertData(@ModelAttribute User user){
        userService.insertData(user);
        return "redirect:/getList" ;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ModelAndView getUserList(){
        List<User> userList = userService.getUserList() ;
        return new ModelAndView("userList", "userList",userList) ;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam String id, @ModelAttribute("user") User user ){
        List<String> genderList = new ArrayList<String>() ;
        genderList.add("male") ;
        genderList.add("female") ;

        List<String> cityList = new ArrayList<String>() ;
        cityList.add("Shymkent") ;
        cityList.add("Astana") ;
        cityList.add("Алматы") ;
        cityList.add("Түркістан") ;

        user = userService.getUser(id) ;

        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("genderList", genderList) ;
        map.put("cityList", cityList) ;
        map.put("user", user) ;

        return new ModelAndView("edit", "map", map) ;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")User user){
        userService.updateData(user);
        return "redirect:/getList" ;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String id){
        System.out.println("id = " + id);
        userService.deleteData(id);
        return "redirect:/getList" ;
    }
}
