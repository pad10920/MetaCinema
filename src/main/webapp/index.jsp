<%--
    Document   : test
    Created on : May 16, 2022, 7:29:15 PM
    Author     : cuong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Permanent+Marker&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../static/css/lichchieu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
    </style>
</head>
<body>
<%--<div class="nav-bar">--%>
<%--    <a href="/trang-chu">--%>
<%--        <div style="display: flex; align-items: center; justify-content: center;">--%>
<%--            <div class="logo-navBar"></div>--%>
<%--            <div class="text-logo">META</div>--%>
<%--        </div>--%>
<%--    </a>--%>
<%--    <div class="select-navBar">--%>
<%--        <select id="cinemas" name="cinemas">--%>

<%--        </select>--%>
<%--    </div>--%>
<%--    <div class="menu-navBar">--%>
<%--        <ul>--%>
<%--            <a href="/thong-tin-rap"><li>RẠP</li></a>--%>
<%--            <a href="/gia-ve"><li>GIÁ VÉ</li></a>--%>
<%--            <a href="/lich-su"><li>LỊCH SỬ</li></a>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <!-- <a href="./login.html">--%>
<%--        <div class="signIn-navBar"><i class="fa-solid fa-user"></i> Login</div>--%>
<%--    </a> -->--%>
<%--    <div class="xin-chao">--%>
<%--        <h3> Xin chào Hưng</h3>--%>
<%--    </div>--%>
<%--    <div class="popup-taikhoan">--%>
<%--        <div class="thong-tin">Thông tin tài khoản</div>--%>
<%--        <div class="dang-xuat">Đăng xuất</div>--%>
<%--    </div>--%>
<%--</div>--%>
<%@ include file="view/manh-navbar.jsp"%>
<div class="lop-phu"></div>
<div class="bang-chon-gio">
    <div class="ten-phim">

    </div>
    <div class="gio-chieu-menu">
        <!-- <div  class="closebtn">&times;</div>
        <button class="active-gio-chieu" type-gio-chieu="test">09/06-T5</button>
        <button type-gio-chieu="pre">10/06-T6</button>
        <button type-gio-chieu="mid">11/06-T7</button>
        <button type-gio-chieu="after">12/06-CN</button>
        <button type-gio-chieu="after">13/06-T2</button>
        <button type-gio-chieu="after">14/06-T3</button> -->
    </div>
    <div class="gio-chieu-list">
        <!-- <div class="gio-chieu hide" type-gio-chieu = "pre">11:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "mid">12:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "mid">12:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "after">13:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "after">14:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "after">15:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "after">16:00</div>
        <div class="gio-chieu hide" type-gio-chieu = "test">22:22</div> -->
    </div>

</div>
<div class="container">
    <div class="cinema-menu">
        <button class="active" type-cinema="0">TẤT CẢ PHIM</button>
        <button type-cinema="2">PHIM SẮP CHIẾU</button>
        <button type-cinema="1">PHIM ĐANG CHIẾU</button>
        <button type-cinema="3">SUẤT CHIẾU ĐẶC BIỆT</button>
    </div>
    <div class="cinema-list"></div>
</div>

<script src="../static/js/app.js"></script>
<script src="../static/js/data.js"></script>
<%--<script src="static/js/trangchu.js"></script>--%>
<%--<script src="static/js/header.js"></script>--%>
</body>
</html>


