package com.zscat.order.service;

import com.zscat.order.entity.TOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public interface TOrderService {
	
	TOrderDO get(Long id);
	
	List<TOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TOrderDO tOrder);
	
	int update(TOrderDO tOrder);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    TOrderDO insertWapOrder(Long productId, Long addressid, Long paymentid, String usercontent, Long id, String username);


	TOrderDO submitOrder(Long id);


}
