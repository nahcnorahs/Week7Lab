package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author Sharon
 */
public class UserServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        UserService us = new UserService();
        RoleService rs = new RoleService();
//        List <User> userList;
//        List <Role> roleList;
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        
        
        try {
            List <User> users = us.getAll();
            request.setAttribute("users", users);
            
        } catch (Exception e){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "error");
        }
        
        if (action != null && action.equals("edit")) {
            try {
                session.setAttribute("email", email);
                User user = us.get(email);
                request.setAttribute("user", user);
            } catch (Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        
        if (action != null && action.equals("delete")){
            try {
                us.delete(email);
            } catch (Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        
        try {
            List<User> users = us.getAll();
            request.setAttribute("users",users);
        } catch (Exception e){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,e);
            request.setAttribute("message", "error");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
      
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
       
       
        
       
       
    }


}
