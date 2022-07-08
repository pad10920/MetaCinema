<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="nav-bar">
    <a href="/">
        <div style="display: flex; align-items: center; justify-content: center;">
            <div class="logo-navBar"></div>
            <div class="text-logo">META</div>
        </div>
    </a>
    <div class="select-navBar">
        <select id="cinemas" name="cinemas">

        </select>
    </div>
    <div class="menu-navBar">
        <ul>
            <a href="/thong-tin-rap"><li>RẠP</li></a>
            <a href="/gia-ve"><li>GIÁ VÉ</li></a>
            <a href="/lich-su"><li>LỊCH SỬ</li></a>
        </ul>
    </div>
    <c:if test="${empty USER}">
        <a href="/dang-nhap" >
            <div class="signIn-navBar"><i class="fa-solid fa-userD" style="padding-right: 8px"></i>Login</div>
        </a>
    </c:if>
    <c:if test="${not empty USER}">
        <c:set var="userQuyen" value="${USER.quyen}"></c:set>
        <c:if test="${userQuyen.equalsIgnoreCase('ROLE_ADMIN')}">
            <a href="/quan-ly/quanlyphim">
                <div class="signIn-navBar"><i class="fa-solid fa-userD" style="padding-right: 8px"></i>${USER.username}</div>
            </a>
        </c:if>

        <c:if test="${userQuyen.equalsIgnoreCase('ROLE_USER')}">
            <a href="/thong-tin">
                <div class="signIn-navBar"><i class="fa-solid fa-userD" style="padding-right: 8px"></i>${USER.username}</div>
            </a>
        </c:if>

        <a href="/dang-xuat">
            <div class="signIn-navBar">Thoát</div>
        </a>
    </c:if>
</div>