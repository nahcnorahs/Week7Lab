
package models;

public class Role {
    String systemAdmin;
    String regularUser;

    public void setSystemAdmin(String systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public void setRegularUser(String regularUser) {
        this.regularUser = regularUser;
    }

    public String getSystemAdmin() {
        return systemAdmin;
    }

    public String getRegularUser() {
        return regularUser;
    }
}
