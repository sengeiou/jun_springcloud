package com.zscat.goods.dao;

import com.zscat.goods.entity.TGoodsClassDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
@Mapper
public interface TGoodsClassDao {

	TGoodsClassDO get(Long id);
	
	List<TGoodsClassDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodsClassDO tGoodsClass);
	
	int update(TGoodsClassDO tGoodsClass);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
