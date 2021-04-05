package com.kurly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.ProductImageMapper;
import com.kurly.mapper.ProductMapper;
import com.kurly.vo.ProductImageVO;
import com.kurly.vo.ProductVO;
import com.kurly.vo.SearchVO;
import com.kurly.vo.SimpleProductVO;

@Service
public class ProductService {
	@Autowired
	ProductMapper mapper;
	@Autowired
	ProductImageMapper imageMapper;
	
	public void insertProduct(ProductVO vo) {
		mapper.insertProduct(vo);
	}
	public List<ProductVO> selectProducts(SearchVO vo){
		List<ProductVO> list = mapper.selectProducts(vo);
		
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
	public ProductVO selectProductBySeq(Integer seq) {
		String imageName = imageMapper.selectProductImageName(seq);
		ProductVO vo = mapper.selectProductBySeq(seq);
		vo.setImage_name(imageName);
		return vo;
	}
	public void updateProduct(ProductVO vo) {
		mapper.updateProduct(vo);
	}
	public void insertRecommendProduct(Integer seq) {
		mapper.insertRecommendProduct(seq);
	}
	public void insertMDRecommendProduct(Integer seq) {
		mapper.insertMDRecommendProduct(seq);
	}
	public void insertSpecialProduct(Integer seq) {
		mapper.insertSpecialProduct(seq);
	}

	public void insertAffordProduct(Integer seq) {
		mapper.insertAffordProduct(seq);
	}


	public List<ProductVO> selectProdRecommendPopupList(SearchVO vo){
		List<ProductVO> resultList = new ArrayList<ProductVO>();
		
		List<ProductVO> originList = new ArrayList<ProductVO>();
		originList = mapper.selectProdRecommendPopupList(vo);
		
		originList.forEach(item -> {
			// 추천에 들어있지 않은 product를 걸러내서 resultList에 추가
			if(item.getMkrp_seq() == null) {
				resultList.add(item);
			}
		});
		
		return resultList;
	}
	public List<ProductVO> selectProdMDRecommendPopupList(SearchVO vo){
		List<ProductVO> resultList = new ArrayList<ProductVO>();
		
		List<ProductVO> originList = new ArrayList<ProductVO>();
		originList = mapper.selectProdMDRecommendPopupList(vo);
		
		originList.forEach(item -> {
			// 추천에 들어있지 않은 product를 걸러내서 resultList에 추가
			if(item.getMkmrp_seq() == null) {
				resultList.add(item);
			}
		});
		
		return resultList;
	}
	public List<ProductVO> selectProdSpecialPopupList(SearchVO vo){
		List<ProductVO> resultList = new ArrayList<ProductVO>();
		
		List<ProductVO> originList = new ArrayList<ProductVO>();
		originList = mapper.selectProdSpecialPopupList(vo);
		
		originList.forEach(item -> {
			if(item.getMksp_seq() == null) {
				resultList.add(item);
			}
		});
		
		return resultList;
	}
	public List<ProductVO> selectProdAffordPopupList(SearchVO vo){
		List<ProductVO> resultList = new ArrayList<ProductVO>();
		
		List<ProductVO> originList = new ArrayList<ProductVO>();
		originList = mapper.selectProdAffordPopupList(vo);
		
		originList.forEach(item -> {
			if(item.getMkap_seq() == null) {
				resultList.add(item);
			}
		});
		
		return resultList;
	}
	public List<SimpleProductVO> selectRecommendList(){
		return mapper.selectRecommendList();
	}
	public List<SimpleProductVO> selectMDRecommendList(){
		return mapper.selectMDRecommendList();
	}
	public List<SimpleProductVO> selectSpecialList(){
		return mapper.selectSpecialList();
	}
	public List<SimpleProductVO> selectAffordList(){
		return mapper.selectAffordList();
	}
	public void deleteRecommendProduct(Integer seq) {
		mapper.deleteRecommendProduct(seq);
	}
	public void deleteMDRecommendProduct(Integer seq) {
		mapper.deleteMDRecommendProduct(seq);
	}
	public void deleteSpecialProduct(Integer seq) {
		mapper.deleteSpecialProduct(seq);
	}
	public void deleteAffordProduct(Integer seq) {
		mapper.deleteAffordProduct(seq);
	}

}
