package services;

import dataaccess.UserDB;
import java.util.*;
import models.Role;
import models.User;

public class UserService {
   public User get(String email) throws Exception {
       UserDB userDB = new UserDB();
       User user = userDB.get(email);
       return user;
   }
   
   public List<User> getAll() throws Exception {
       UserDB userDB = new UserDB();
       List<User> users = userDB.getAll();
       return users;
   }
   
   public void insert(User user) throws Exception {
       UserDB userDB = new UserDB();
       userDB.insert(user);
   }
   
   public void update(User user) throws Exception {
       UserDB userDB = new UserDB();
       userDB.update(user);
   }
   
   public void delete (String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}

