package com.kurly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kurly.vo.ProductVO;

@Mapper
public interface ProductMapper {
	public void insertProduct(ProductVO vo);
	public List<ProductVO> selectProducts();
	public void deleteProduct(Integer seq);
	public ProductVO selectProductBySeq(Integer seq);
	public void updateProduct(ProductVO vo);

}
