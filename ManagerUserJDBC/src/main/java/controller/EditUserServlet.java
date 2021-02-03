package controller;

import model.User;
import service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditUserServlet", urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name,email,country);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user.jsp");
        try {
            userDAO.editUser(id,user);
            request.setAttribute("user",user);
            request.setAttribute("mess","Done...!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        try {
            user = userDAO.findById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user",user);
        dispatcher.forward(request,response);
    }
}
