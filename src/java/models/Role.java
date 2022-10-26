package models;
import java.io.Serializable;

public class Role implements Serializable{
    private int roleID;
    private String roleName;

    public Role() {
        
    }
    public Role (int roleID, String roleName){
        this.roleID = roleID;
        this.roleName = roleName;
    }
    
    public int getRoleID(){
        return roleID;
    }
    
    public void setRoleID(){
        this.roleID = roleID;
    }
    
    public String getRole(){
        return roleName;
    }
    
    public void setRole(String roleName){
        this.roleName = roleName;
    }
}
