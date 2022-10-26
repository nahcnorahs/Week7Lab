package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

public class RoleService {
    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
}
//    public void update (String systemAdmin, String regularUser) throws Exception {
//        Role role = new Role(systemAdmin,regularUser);
//        RoleDB roleDB = new RoleDB();
//        roleDB.update(role);
//    }
//    
//    public void delete (String role) throws Exception {
//        Role role = new Role();
//        role.setSystemAdmin(systemAdmin);
//        role.setRegularUser(regularUser);
//        RoleDB roleDB = new RoleDB();
//        roleDB.delete(role);
//    }
    
    public Role get(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        return role;
    }
}

