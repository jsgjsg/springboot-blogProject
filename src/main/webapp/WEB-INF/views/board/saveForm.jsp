<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<div class="container">

    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>

        <br/>

        <div class="form-group">
            <label for="category">카테고리</label>
            <select class="form-control" id="category">
                <c:choose>
                    <c:when test="${category == 'DIARY'}">
                        <option value="DIARY" selected>일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${category == 'TRAVEL'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL" selected>여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${category == 'MOVIE'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE" selected>영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:when>
                    <c:when test="${category == 'NETFLIX'}">
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX" selected>넷플릭스</option>
                    </c:when>
                    <c:otherwise>
                        <option value="DIARY">일상</option>
                        <option value="TRAVEL">여행</option>
                        <option value="MOVIE">영화</option>
                        <option value="NETFLIX">넷플릭스</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>

        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>

    </form>

    <button id="btn-save" class="btn btn-primary">글쓰기완료</button>

</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 300
    });
</script>

<script src="/js/board.js"></script>

<%@include file="../layout/footer.jsp"%>