package com.hello.boot.Controllers;

import com.hello.boot.models.User;
import com.hello.boot.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // Private fields

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    @ResponseBody
    public String create(String email,String name){
        String userID="";

        try{
            User user=new User(email, name);
            userDao.save(user);
            userID=String.valueOf(user.getId());
        }catch (Exception ex){
            return "Error creating the user: " + ex.toString();
        }

        return "User successfully created with ID : "+userID;
    }
}
