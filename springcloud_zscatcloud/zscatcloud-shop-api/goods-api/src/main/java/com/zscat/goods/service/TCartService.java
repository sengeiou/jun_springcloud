package com.zscat.goods.service;

import com.zscat.goods.entity.TCartDO;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TCartService {
	
	TCartDO get(Long id);
	
	List<TCartDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TCartDO tCart);
	
	int update(TCartDO tCart);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	TCartDO selectOne(Map<String, Object> params);

    int selectOwnCart(Long id);
	List<TCartDO>  selectOwnCartList(Long id);
	List<TCartDO> list1(Map<String, Object> map);

	/**
	 * 计算前
	 * @param map
	 * @return
	 */
	String countprice(Map<String, Object> map);

	Map<String, Object> ordersubmitpreview(Map<String, Object> params);

}
