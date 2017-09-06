package com.hello.boot.Controllers;

import com.hello.boot.Services.UserService;
import com.hello.boot.models.User;
import com.hello.boot.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    // Private fields

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    @ResponseBody
    public String create(String email,String name){
        String userID="";

        try{
            User user=new User(email, name);
            userRepository.save(user);
            userID=String.valueOf(user.getId());
        }catch (Exception ex){
            return "Error creating the user: " + ex.toString();
        }

        return "User successfully created with ID : "+userID;
    }

    @RequestMapping(value="/users",method=RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.findAll();
    }
}
