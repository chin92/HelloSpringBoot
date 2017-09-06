package com.hello.boot.Services;

import com.hello.boot.models.User;
import com.hello.boot.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> allUsersList=new ArrayList<>();
         userRepository.findAll().forEach(user -> {
             allUsersList.add(user);
         });
         return  allUsersList;
    }
}
