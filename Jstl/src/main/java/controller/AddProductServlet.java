package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductServlet",urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = (int)(Math.random() * 10000);
    String name = request.getParameter("name");
    double price = Double.parseDouble(request.getParameter("price"));
    String brand = request.getParameter("brand");
    Product product = new Product(id,name,price,brand);
    productService.addProdcut(product);

    RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.jsp");
    request.setAttribute("mess","Done...!");
    dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.jsp");
        Product product = new Product();
        request.setAttribute("product",product);
        dispatcher.forward(request,response);

    }
}
