<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 6/14/2022
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mua vé</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="../static/css/muaVe.css">
  <link rel="stylesheet" href="../static/css/home.css">
</head>
<body>
<%--<div class="nav-bar">--%>
<%--  <a href="/trang-chu">--%>
<%--    <div style="display: flex; align-items: center; justify-content: center;">--%>
<%--      <div class="logo-navBar"></div>--%>
<%--      <div class="text-logo">META</div>--%>
<%--    </div>--%>
<%--  </a>--%>
<%--  <div class="select-navBar">--%>
<%--    <select name="cinemas" id="cinemas">--%>

<%--    </select>--%>
<%--  </div>--%>
<%--  <div class="menu-navBar">--%>
<%--    <ul>--%>
<%--      <a href="/thong-tin-rap"><li>RẠP</li></a>--%>
<%--      <a href="/gia-ve"><li>GIÁ VÉ</li></a>--%>
<%--      <a href="/lich-su"><li>LỊCH SỬ</li></a>--%>
<%--    </ul>--%>
<%--  </div>--%>
<%--  <a href="./login.html">--%>
<%--    <div class="signIn-navBar"><i class="fa-solid fa-user"></i> Login</div>--%>
<%--  </a>--%>
<%--</div>--%>
<%@ include file="manh-navbar.jsp"%>
<div class="mua-ve">
  <div class="ghe-mua-ve">
    <div class="man-hinh-chieu"></div>
    <div class="list-ghe"></div>
<%--   <div class="kq">ket qua: </div>--%>
  </div>
  <div class="phim-mua-ve">

  </div>

</div>
<div class="btn-mua-ve">
  <a href="/thanh-toan"><button class = "btnMuaVe"><i class="fa-solid fa-ticket"></i>  MUA VÉ</a> </button></a>
</div>
<script src="../static/js/dungchung.js" type="module"></script>
<script src="../static/js/muaVe.js"></script>
<script src="../static/js/trangchu.js" type="module"></script>

</body>
</html>
