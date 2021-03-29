// product.js
$(function(){
	$("#product_add").click(function(){
		$(".prod_insert_modal").show();
		$(".modal_content h1 span").html("상품추가");
		$("#save").show();
		$("#modify").hide();
		
		$.ajax({
			url:"/category_list",
			type:"get",
			success:function(data){
				$("#prod_category").html("");
				for(let i =0; i<data.length; i++){
					let template = '<option value="' + data[i].mkpc_seq + '">' + data[i].mkpc_name + '</option>';
					$("#prod_category").append(template);
				}
			}
		});
		
		$.ajax({
			url:"/company_list",
			type:"get",
			success:function(data){
				$("#prod_brand").html("");
				for(let i =0; i<data.length; i++){
					let template = '<option value="' + data[i].mkb_seq + '">' + data[i].mkb_name + '</option>';
					$("#prod_brand").append(template);
				}
			}
		})
		
	})
	$("#save").click(function(){
		$(".prod_insert_modal").hide();
		let data = {
		  "mkp_name":$("#prod_name").val(),
		  "mkp_sub_name":$("#prod_sub_name").val(),
		  "mkp_bi_seq":$("#prod_brand option:selected").val(),
		  "mkp_ci_seq":$("#prod_category option:selected").val(),
		  "mkp_price":$("#prod_price").val(),
		  "mkp_discount":$("#prod_discount").prop("checked")?1:0,
		  "mkp_discount_rate":$("#prod_discount_value").val(),
		  "mkp_kurly_only":$("#prod_only").prop("checked")?1:0,
		  "mkp_point_rate":$("#prod_point_value").val(),
		  "mkp_unit":$("#prod_unit").val(),
		  "mkp_weight":$("#prod_weight").val(),
		  "mkp_early_delivery":$("#prod_early").prop("checked")?1:0,
		  "mkp_delivery":$("#prod_delivery").prop("checked")?1:0,
		  "mkp_packing_type":$("#prod_packing").val(),
		  "mkp_allergy_info":$("#allergy_info").val(),
		  "mkp_exp_date":$("#prod_expire_date").val(),
		  "mkp_relation_seq":null
		}
		//console.log(JSON.stringify(data));
		
		$.ajax({
			url:"/product",
			type:"put",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				let form = $("#prod_img_form");
				let formData = new FormData(form[0]);
				$.ajax({
					url:"/product_img/" + data.prod_seq + "?brand=" + $("#prod_brand option:selected").html() +
					"&name="+$("#prod_name").val(),
					type:"put",
					data:formData,
					contentType:false,
					processData:false,
					success:function(){
						alert("제품이 추가되었습니다.");
						$(".prod_insert_modal").hide();
					}
				})
				
			},
			error:function(){
				alert("에러");
			}
		})
	});
	$("#modify").click(function(){
		$(".prod_insert_modal").hide();
	});
	$("#cancel").click(function(){
		$(".prod_insert_modal").hide();
	});
	$(".prod_delete button").click(function(){
		if(!confirm("삭제하시겠습니까?")) return;
		let seq = $(this).attr("data-seq");
		$.ajax({
			url:"/product/" + seq,
			type:"delete",
			success: (data) => {
				alert(data.message);
				location.reload();
			}
		})
	})
})