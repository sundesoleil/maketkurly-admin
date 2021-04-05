// special.js
$(function(){
	$.ajax({
		url:"/category_list",
		type:"get",
		success:function(data){
			$("#category").html("");
			$("#category").append('<option value="0">전체 카테고리</option>');
			for(let i =0; i<data.length; i++){
				let template = '<option value="' + data[i].mkpc_seq + '">' + data[i].mkpc_name + '</option>';
				$("#category").append(template);
			}
			}
		});
		
		$.ajax({
			url:"/company_list",
			type:"get",
			success:function(data){
				$("#brand").html("");
				$("#brand").append('<option value="0">전체 브랜드</option>');
				for(let i =0; i<data.length; i++){
					let template = '<option value="' + data[i].mkb_seq + '">' + data[i].mkb_name + '</option>';
					$("#brand").append(template);
				}
			}
		});	
	$("#save").click(function(){
		//$(".product_add_modal").hide();
		
		if($(".modal_prod_item_sel:checked").length == 0){
			alert("선택된 상품이 없습니다");
			return;
		}
		let selected = $(".modal_prod_item_sel:checked");
		let selectedSeqList = new Array();
		
		
		for(let i=0; i<selected.length; i++){
			let value = selected.eq(i).val();
			selectedSeqList.push(value);
		}
		console.log(selectedSeqList);
		$.ajax({
			url:"/special",
			type:"put",
			contentType:"application/json",
			data:JSON.stringify(selectedSeqList),
			success:function(data){
				alert("상품이 추가되었습니다.");
				location.reload();
			},
			error:function(e){
				console.log(e);
				alert("에러");
			}
		})
	})
	$("#cancel").click(function(){
		$(".product_add_modal").hide();
	})
	$("#category").change(function(){
		getProducts();
		$("#selectAll").prop("checked", false);
	})
	$("#brand").change(function(){
		getProducts();
		$("#selectAll").prop("checked", false);
	})
	$("#search_btn").click(function(){
		getProducts();
	})
	$("#search_keyword_popup").keydown(function(e){
		if(e.keyCode == 13){ /*엔터키*/
			getProducts();
		}
	})
	$("#add_category").click(function(){
		$(".product_add_modal").show();
		getProducts();
	})
	
	function getProducts(){
		let data = {
			keyword:$("#search_keyword_popup").val(),
			cate_seq:$("#category option:selected").val(),
			brand_seq:$("#brand option:selected").val()
		}
		$.ajax({
			url:"/special_list",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				//console.log(data);
				$(".modal_prod_item_wrap").html("");
				for(let i=0; i<data.length; i++){
					let template = 
						'<div class="modal_prod_item">'+
								'<div>'+
									'<input type="checkbox" class="modal_prod_item_sel" id="sel'+i+'" value="'+data[i].mkp_seq+'"/>'+
									'<label for="sel'+i+'"></label>'+
								'</div>'+
								'<div>'+data[i].brand_name+'</div>'+
								'<div>'+data[i].category_name+'</div>'+
								'<div>'+data[i].mkp_name+'</div>'+
								'<div>'+data[i].mkp_price+'</div>'+
							'</div>';
				
				$(".modal_prod_item_wrap").append(template);
				
				}
			}
		});			
	}
	$(".delete_btn").click(function(){
		if(!confirm("삭제하시겠습니까?")) return;
		let seq = $(this).attr("data-seq");
		$.ajax({
			url:"/special/" + seq,
			type:"delete",
			success:function(data){
				alert("삭제되었습니다.");
				location.reload();
			},
			error:function(e){
				console.log(e);
				alert("에러");
			}
		})
	})
	
})