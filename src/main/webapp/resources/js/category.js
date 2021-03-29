/**category.js */
$(function(){
	$("#add_category").click(function(){
		$(".category_add_modal").addClass("open");
		$("#save").show();
		$("#modify").hide();
	});
	$("#save").click(function(){
		if($("#category_name").val() == ''){
			return;
		}
		// 통신 - GET 방식이므로 따로 data 값을 주지 않고 url 뒤에 parameter 붙임
		$.ajax({
			url:"/api/insert_category?name=" + $("#category_name").val(),
			type:"get",
/*			data:{ 
				name: $("#category_name").val()
			},*/
			success:function(data){
				if(data.status == 'failed'){
					alert(data.message);
				}else{
					alert(data.message);
					location.reload();
				}
			},
			error:function(){
				alert("에러");
			}
		})
		
		
	})
	$("#cancel").click(function(){
		$(".category_add_modal").removeClass("open");
		$("#category_name").val("");
	})
	
	$(".delete_btn").click(function(){
		let name = $(this).parent().parent().find(".item_name").html();
		if(confirm(name+" 카테고리를 삭제하시겠습니까?") == false) return;
		//let seq = $(this).parent().parent().attr("data-category-seq");
		let seq = $(this).parent().parent().find(".item_no").html();
		
		$.ajax({
			url:"/category?seq="+seq,
			type:"delete",
			success:function(data){ // data > api 쪽에서 return 해주는 값
				alert(data.message);
				location.reload();
			} 
		})
		

	})
	/*function deleteCategory(seq){
		$.ajax({
			url:"/api/delete_category",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify({mkpc_seq:seq}),
			success:function(data){
				alert("삭제되었습니다.");
				location.reload();
			},
			error:function(){
				alert("에러");
			}
			
		})
	}*/
	$(".modify_btn").click(function(){
		window.modify_seq = $(this).parent().parent().find(".item_no").html(); // 전역변수 선언
		let name = $(this).parent().parent().find(".item_name").html();
		window.originalName = name;
		
		$("#modify").prop("disabled",true);
		$(".category_add_modal").addClass("open");
		$("#save").hide();
		$("#modify").show();
		$("#category_name").val(name);
		$(".category_add_modal h1 span").html("카테고리수정");
	})
	
	$("#modify").click(function(){
		
		if(confirm("수정하시겠습니까?") == false)
			return;
	
		$.ajax({
				url:"/category/" + window.modify_seq + "?name=" + $("#category_name").val(),
				type:"patch",
				success:function(data){
					alert(data.message);
					if(data.status == 'success'){
						location.reload();
					}
				},
				error:function(){
					alert("에러");
				}
		})
	})
	$("#category_name").on("input", function(){
		console.log($("#category_name").val());
		if(window.originalName == $("#category_name").val() || $("#category_name").val() == ''){
			$("#modify").prop("disabled", true);
		}
		else{
			$("#modify").prop("disabled", false);
		}
	})
})