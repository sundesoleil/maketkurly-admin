package com.kurly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.ProductImageMapper;
import com.kurly.mapper.ProductMapper;
import com.kurly.vo.ProductImageVO;
import com.kurly.vo.ProductVO;

@Service
public class ProductService {
	@Autowired
	ProductMapper mapper;
	@Autowired
	ProductImageMapper imageMapper;
	
	public void insertProduct(ProductVO vo) {
		mapper.insertProduct(vo);
	}
	public List<ProductVO> selectProducts(){
		List<ProductVO> list = mapper.selectProducts();
		
		String prefix = "/product_img/";
		list.forEach(item-> {
			String uri = imageMapper.selectProductImageURI(item.getMkp_seq());
			if(uri != null) {
				item.setImage_uri(prefix+uri);
			}
	});
		return list;
	}
	public void deleteProduct(Integer seq) {
		mapper.deleteProduct(seq);
	}
}
