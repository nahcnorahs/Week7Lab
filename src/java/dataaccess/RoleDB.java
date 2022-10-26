package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;

public class RoleDB {
    public List<Role> getAll() throws Exception {
    List<Role> roles = new ArrayList<>();
    ConnectionPool cp = ConnectionPool.getInstance();
    Connection con = cp.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String sql = "SELECT role_id, role_name FROM Role";
    
    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            int roleID = rs.getInt(1);
            String roleName = rs.getString(2);
            Role role = new Role(roleID, roleName);
            roles.add(role);
        }
        
    } finally {
        DBUtil.closeResultSet(rs);
        DBUtil.closePreparedStatement(ps);
        cp.freeConnection(con);
    }
    return roles;
}
  public Role get(int roleID) throws Exception {
      Role role = null;
      ConnectionPool cp = ConnectionPool.getInstance();
      Connection con = cp.getConnection();
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      String sql = "SELECT role_id, role_name FROM Role WHERE role_id=?";
      
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1,roleID);
          rs = ps.executeQuery();
          if (rs.next()){
              String roleName = rs.getString(2);
              
              role = new Role(roleID,roleName);
          }
      } finally {
          DBUtil.closeResultSet(rs);
          DBUtil.closePreparedStatement(ps);
          cp.freeConnection(con);
      }
      
      return role;
  }
  
}
