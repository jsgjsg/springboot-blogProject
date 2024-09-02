<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<div class="container">

    <form>
        <div class="form-group">
            <label for="username">username</label>
            <div class="card">
                <div class="card-body" id="username">${user.username}</div>
            </div>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <div class="card">
                <div class="card-body" id="password">${user.password}</div>
            </div>
        </div>

        <div class="form-group">
            <label for="email">email</label>
            <div class="card">
                <div class="card-body" id="email">${user.email}</div>
            </div>
        </div>

    </form>

    <a href="/user/updateForm/${user.id}" class="btn btn-warning">회원정보 수정</a>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>