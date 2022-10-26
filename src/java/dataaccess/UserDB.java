package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;

public class UserDB {
    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT email, first_name, last_name, password, role_id, role_name FROM user, role WHERE role_id=role";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String email = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String password = rs.getString(4);
                int role_id = rs.getInt(5);
                String role_name = rs.getString(6);
                Role userRole = new Role(role_id,role_name);
                User user = new User(email,firstName,lastName,password,userRole);
                users.add(user);
        }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    public User get(String email) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT first_name, last_name, password, role, role_id, role_name FROM user u, Role r WHERE email=? AND r.role_id=u.role";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while (rs.next()){
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String password = rs.getString(3);
                int role_id = rs.getInt(5);
                String role_name = rs.getString(6);
                Role userRole = new Role(role_id,role_name);
                user = new User(email,firstName,lastName,password,userRole);
            }
            
        } finally{
                    DBUtil.closePreparedStatement(ps);
                    cp.freeConnection(con);
                    }
        return user;
    }
    
    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO user (email, first_name, last_name, password,role) VALUES (?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole().getRoleID());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE user SET first_name=?, last_name=?, password=?,role=? WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRole().getRoleID());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
    }
}
    public void delete(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM User WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
    }
}
}

    
