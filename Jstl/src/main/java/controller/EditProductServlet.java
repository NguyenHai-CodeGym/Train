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

@WebServlet(name = "EditProductServlet",urlPatterns = "/editProduct")
public class EditProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter( "id"));
    String name = request.getParameter("name");

    double price = Double.parseDouble(request.getParameter("price"));
    String brand = request.getParameter("brand");

    Product product = new Product(id,name,price,brand);
    productService.editProduct(id,product);
    List<Product> productList = productService.findAll();
    RequestDispatcher dispatcher = request.getRequestDispatcher("edit-product.jsp");
    request.setAttribute("mess","Done....!");
    request.setAttribute("product",product);
    dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product productList = productService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-product.jsp");
        request.setAttribute("product",productList);
        dispatcher.forward(request,response);

    }
}
