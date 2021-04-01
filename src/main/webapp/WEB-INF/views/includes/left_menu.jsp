<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="icon" href="/resources/images/favicon.png" />
	<link rel="stylesheet" href="/resources/css/reset.css" />
	<link rel="stylesheet" href="/resources/css/left_menu.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- 	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script> -->
	<script>
		$(function(){
			let menu_num = "${menu_num}";
			$(".menu a").eq(menu_num).addClass("current");
		})
	</script>
</head>
<body>
	<div class="left_side">
			<a href="/products" id="logo">
				<img src="/resources/images/DM_20210324195650_002.PNG" />
			</a>
			<div class="menu">
			<a href="/products"><i class="fas fa-box"></i>상품관리</a>
			<a href="/category"><i class="fas fa-tags"></i>카테고리관리</a>
			<a href="/recommend"><i class="fas fa-thumbs-up"></i>추천상품관리</a>
			<a href="#"><i class="fas fa-user-check"></i>MD추천상품관리</a>
			<a href="/company"><i class="fas fa-building"></i>브랜드업체관리</a>
			<a href="#"><i class="fas fa-won-sign"></i>특가상품관리</a>
			<a href="#"><i class="fas fa-hand-holding-usd"></i>알뜰상품관리</a>
			</div>
		</div>
</body>
</html>