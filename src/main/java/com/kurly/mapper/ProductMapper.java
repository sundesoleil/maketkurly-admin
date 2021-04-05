package com.kurly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kurly.vo.ProductVO;
import com.kurly.vo.SearchVO;
import com.kurly.vo.SimpleProductVO;

@Mapper
public interface ProductMapper {
	public void insertProduct(ProductVO vo);
	public List<ProductVO> selectProducts(SearchVO vo);
	public void deleteProduct(Integer seq);
	public ProductVO selectProductBySeq(Integer seq);
	public void updateProduct(ProductVO vo);
	
	public void insertRecommendProduct(Integer seq);
	public void insertMDRecommendProduct(Integer seq);
	public void insertSpecialProduct(Integer seq);
	public void insertAffordProduct(Integer seq);
	
	
	public List<ProductVO> selectProdRecommendPopupList(SearchVO vo);
	public List<ProductVO> selectProdMDRecommendPopupList(SearchVO vo);
	public List<ProductVO> selectProdSpecialPopupList(SearchVO vo);
	public List<ProductVO> selectProdAffordPopupList(SearchVO vo);
	
	public List<SimpleProductVO> selectRecommendList();
	public List<SimpleProductVO> selectMDRecommendList();
	public List<SimpleProductVO> selectSpecialList();
	public List<SimpleProductVO> selectAffordList();
	
	public void deleteRecommendProduct(Integer seq);
	public void deleteMDRecommendProduct(Integer seq);
	public void deleteSpecialProduct(Integer seq);
	public void deleteAffordProduct(Integer seq);
}
