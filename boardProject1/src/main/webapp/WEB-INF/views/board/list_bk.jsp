<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	.dataRow:hover {
		background: #ddd;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	$(function(){
		$(".dataRow").click(function(){
			var no = $(this).find(".no").text();
			location = "post?no=" + no + "&inc=1"
		});
	});
</script>
<title>게시판 리스트</title>
</head>
<body>
<div class="container">
	<h2>게시판 리스트</h2>

	
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }<a>11</a></td>
				<td>${vo.title }<a>11</a></td>
				<td>${vo.writer }<a>11</a></td>
				<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd"/><a>11</a></td>
				<td>${vo.hit }<a>11</a></td>		
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5">
				<form class="navbar-form">
		            <div class="pull-right" style="margin: 10px;">
		                <select name="" id="amount">
		                    <option value="">--</option>
		                    <option value="10">10개씩</option>
		                    <option value="20" selected="selected">20개씩</option>
		                    <option value="30">30개씩</option>
		                </select>
		            </div>
		            <div class="searchDiv">
		                <label>검색</label> 
		                <input type="text" class="form-control" placeholder="Search" id="keyword" name="keyword">
		                <button id="searchBtn" name="searchBtn" type="submit" class="btn">검색</button>
		                <select id="type" name="type">
		                    <option value="TC" ${pageMaker.cri.type eq 'TC' ? 'selected' : ''}>제목+내용</option>
		                    <option value="T" ${pageMaker.cri.type eq 'T' ? "selected" : ''}>제목</option>
		                    <option value="C" ${pageMaker.cri.type eq 'C' ? "selected" : ''}>내용</option>
		                    <option value="W" ${pageMaker.cri.type eq 'W' ? "selected" : ''}>작성자</option>
		                    <option value="TWC" ${pageMaker.cri.type eq 'TWC' ? "selected" : ''}>전체</option>
		                </select>
		                <input type="hidden" name="pageNum" value="1" />
		            </div>
	            </form>
			</td>
		</tr>
		<tr>
			<td colspan="5"><a class="btn btn-defualt" href="write">글쓰기</a></td>
		</tr>
		<tr>
			<td colspan="5">
				<div class="text-align: center">
	                <ul class="pagination">
						<c:if test="${pageMaker.prev }">
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage-1 }">이전</a>
							</li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }">
								<a href="${no }">${no}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next }">
							<li class="paginate_button next">
								<a href="${pageMaker.endPage+1 }">다음</a>
							</li>
						</c:if>
						<c:if test="${pageMaker.next }">
							<li class="paginate_button next">
								<a href="${pageMaker.lastPage }">맨끝</a>
							</li>
						</c:if>
	                </ul>
            	</div>
			</td>
		</tr>

	</table>
</div>
</body>
</html>