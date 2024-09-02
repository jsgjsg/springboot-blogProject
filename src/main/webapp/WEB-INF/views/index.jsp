<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="layout/header.jsp"%>

<div class="container">

    <c:choose>
        <c:when test="${board != null}">
            <%@include file="board/detail.jsp"%>
        </c:when>
    </c:choose>

    <c:forEach var="board" items="${boards.content}">
        <div class="card m-2">
            <div class="card-body">
                <h2 class="card-title">${board.title}</h2>
                <h6 class="card-title">${board.category} 게시글</h6>
                <a href="/${categoryURL}/${board.id}?page=${boards.number}" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>

    <c:choose>
        <c:when test="${!empty sessionScope.principal}">
            <div class="card-body">
                <a href="/${categoryURL}/saveForm" class="btn btn-primary">글쓰기</a>
            </div>
        </c:when>
    </c:choose>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number - 1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number - 1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="1" end="${boards.totalPages}" step="1">
            <c:choose>
                <c:when test="${i == boards.number + 1}">
                    <li class="page-item active"><a class="page-link" href="?page=${i - 1}">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${i - 1}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:otherwise>
        </c:choose>

    </ul>

</div>

<%@include file="layout/footer.jsp"%>