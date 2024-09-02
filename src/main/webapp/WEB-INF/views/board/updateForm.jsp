<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<div class="container">

    <form>
        <input type="hidden" id="id" value="${board.id}">

        <div class="form-group">
            <input type="text" class="form-control" value="${board.title}" placeholder="Enter title" id="title">
        </div>

        <br/>

        <div class="form-group">
            <label for="category">카테고리</label>
            <select class="form-control" id="category">
                <c:choose>
                    <c:when test="${board.category == 'DIARY'}">
                        <option value="DIARY" selected>일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${board.category == 'TRAVEL'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL" selected>여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${board.category == 'MOVIE'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE" selected>영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${board.category == 'NETFLIX'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX" selected>넷플릭스</option>
                    </c:when>
                </c:choose>

            </select>
        </div>

        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
        </div>

    </form>

    <button id="btn-update" class="btn btn-primary">글수정완료</button>

</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>

<script src="/js/board.js"></script>

<%@include file="../layout/footer.jsp"%>