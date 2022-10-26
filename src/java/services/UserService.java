package services;

import dataaccess.UserDB;
import java.util.List;
import java.util.*;
import models.Role;
import models.User;

public class UserService {
    public User get(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
        
//        if (user.getEmail().equals(email)){
//            return user;
//        } else
//            return null;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String firstName, String lastName, String password, Role role){
        User user = new User(firstName,lastName,password,role);
        UserDB userDB = new UserDB();
        userDb.insert(user);
        
    }
    
    public void update(User user) throws Exception {
        //User user = new User();
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
    
    
}

