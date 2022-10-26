package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

public class RoleService {
    public Role get(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        return role;
    }
    
    public List<Role> getAll() throws Exception {
        RoleDB userDB = new RoleDB();
        List<Role> roles = userDB.getAll();
        return roles;
    }
}

