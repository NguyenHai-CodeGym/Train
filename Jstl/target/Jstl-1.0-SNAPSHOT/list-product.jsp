<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/3/2021
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <title>List Product</title>
</head>
<body>
<div class="container">
    <h2>List Product</h2>
    <a href="/addProduct">Create New Product</a>
    <table class="table table-striped">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Brand</td>
            <td colspan="2"; tex>Controller</td>
        </tr>
        <c:forEach items='${productList}' var="productList">
            <tr>
                <td>${productList.name}</td>
                <td>${productList.price}</td>
                <td>${productList.brand}</td>
                <td><a href='/editProduct?id=${productList.id}'>EDIT</a></td>
                <td><a href='/deleteProduct?id=${productList.id}'>DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
