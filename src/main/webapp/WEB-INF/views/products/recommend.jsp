<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마켓컬리 :: 추천상품관리</title>
	<link rel="stylesheet" href="/resources/css/category_list.css" />
	<link rel="stylesheet" href="/resources/css/prod_add_modal.css" />
	<link rel="icon" href="/resources/images/favicon.png" />
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/includes/left_menu.jsp" %>
	<div class="wrap">
		<div class="header_area">
				<h1><i class="fas fa-thumbs-up"></i>추천상품 관리</h1>
				<div class="header_right">
					<div class="search_box">
						<input type="text" id="search_keyword" />
						<img src="/resources/images/DM_20210324195650_057.PNG" />
					</div>
					<button id="add_category">추천상품 추가</button>
				</div>
			</div>
			<div class="list">
				<div class="list_header">
					<div>NO</div>
					<div>상품명</div>
					<div>등록일</div>
					<div>삭제</div>
				</div>
				<div class="list_area">
					<div class="list_item"> 
						<div class="item_no">1</div>
						<div class="item_name">상품명</div>
						<div class="item_reg_date">
							<fmt:formatDate value="${item.mkb_reg_date}" pattern="yyyy-MM-dd HH:mm" />
							2021-04-01
						</div>
						<div class="item_delete">
							<button type="button" class="delete_btn">삭제</button>
						</div>
					</div>
				</div>	
			</div>
	</div>
	
	<div class="product_add_modal">
		<div class="product_add_content">
			<div class="filter_area">
				<select id="category">
					<option>카테고리</option>
					<option>카테고리</option>
					<option>카테고리</option>
				</select>
				<select id="brand">
					<option>브랜드</option>
					<option>브랜드</option>
					<option>브랜드</option>
				</select>
			</div>
			<div class="search_area">
				<input type="text" id="search_keyword" placeholder="상품명 검색" />
				<button id="search_btn">검색</button>
			</div>
		</div>
	</div>
</body>
</html>