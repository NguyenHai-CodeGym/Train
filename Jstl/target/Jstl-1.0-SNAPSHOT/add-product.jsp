<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/3/2021
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<div class="container">
    <h2>Create New Product</h2>
    <a href="/product">Back Menu</a>
    <h2 style="color:green;">${mess}</h2>
    <form action="/addProduct" method="post">
        <div class="form-group">
            <label>Name Product</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>Price Product</label>
            <input type="number" class="form-control" name="price">
        </div>
        <div class="form-group">
            <label>Brand Product</label>
            <input type="text" class="form-control" name="brand">
        </div>
        <br>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
