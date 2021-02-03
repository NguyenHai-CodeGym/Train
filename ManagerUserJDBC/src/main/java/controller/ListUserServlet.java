package controller;

import model.User;
import service.IUserDAO;
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

@WebServlet(name = "ListUserServlet", urlPatterns = "/listUser")
public class ListUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
        List<User> user = null;
        try {
            user = userDAO.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user",user);
        dispatcher.forward(request,response);
    }
}
