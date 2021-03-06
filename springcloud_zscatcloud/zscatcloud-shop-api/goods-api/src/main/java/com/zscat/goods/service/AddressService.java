package com.zscat.goods.service;


import com.zscat.goods.entity.AddressDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-20 11:41:11
 */
public interface AddressService {
	
	AddressDO get(Long id);
	
	List<AddressDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AddressDO address);
	
	int update(AddressDO address);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    AddressDO selectOne(Map<String, Object> params);
}
