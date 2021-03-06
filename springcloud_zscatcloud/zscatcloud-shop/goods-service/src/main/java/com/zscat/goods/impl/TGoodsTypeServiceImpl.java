package com.zscat.goods.impl;

import com.zscat.goods.dao.TGoodsTypeDao;
import com.zscat.goods.entity.TGoodsTypeDO;
import com.zscat.goods.service.TGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



/**
 * Created by GeneratorFx on 2017-04-11.
 */
/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@Service
public class TGoodsTypeServiceImpl implements TGoodsTypeService {
	@Autowired
	private TGoodsTypeDao tGoodsTypeDao;
	
	@Override
	public TGoodsTypeDO get(Long id){
		return tGoodsTypeDao.get(id);
	}
	
	@Override
	public List<TGoodsTypeDO> list(Map<String, Object> map){
		return tGoodsTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tGoodsTypeDao.count(map);
	}
	
	@Override
	public int save(TGoodsTypeDO tGoodsType){
		return tGoodsTypeDao.save(tGoodsType);
	}
	
	@Override
	public int update(TGoodsTypeDO tGoodsType){
		return tGoodsTypeDao.update(tGoodsType);
	}
	
	@Override
	public int remove(Long id){
		return tGoodsTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tGoodsTypeDao.batchRemove(ids);
	}
	
}
