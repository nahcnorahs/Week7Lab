package servlets;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import models.User;
import models.Role;
import services.UserService;
import services.RoleService;
import java.util.List;

/**
 *
 * @author Sharon
 */
public class UserServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       UserService us = new UserService();
       RoleService rs = new RoleService();
       List <User> userList;
       List<Role> userRole;
       HttpSession session = request.getSession();
       String email = request.getParameter("email");
       String action = request.getParameter("action");
       int userID = 0;
       
       if (action == null){
           try {
               userList = us.getAll();
               userRole = rs.getAll();
               
               if (userList.isEmpty()){
                   //print something
               } else {
                   //does something
               }
               
               request.setAttribute("userList", userList);
               request.setAttribute("userRoles", userRoles);
               request.setAttribute("edit", edit);
               getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
               session.setAttribute("message", "");
           } catch (Exception e){
               Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,ex);
           }
       } else if (action.equals("edit")){
           //something
           
           try {
               email = request.getParameter("userEmail");
               User user = us.get(email);
               userID = user.getRole().getRoleID();
               response.sendRedirect("/");
           } catch (Exception e){
               Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,ex);
           }
       } 
       session.setAttribute("email", email);
       session.setAttribute("userID", userID);
    }
    else if (action.equals("delete")) {
        try {
            us.delete(email);
            response.sendRedirect("/");
        } catch (Exception e) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            UserService us = new UserService();
            RoleService rs = new RoleService();
            List<User> userList;
            List <Role> userRoles;
    }


}
