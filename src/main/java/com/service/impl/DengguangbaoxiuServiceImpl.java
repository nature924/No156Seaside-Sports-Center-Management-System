package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DengguangbaoxiuDao;
import com.entity.DengguangbaoxiuEntity;
import com.service.DengguangbaoxiuService;
import com.entity.vo.DengguangbaoxiuVO;
import com.entity.view.DengguangbaoxiuView;

@Service("dengguangbaoxiuService")
public class DengguangbaoxiuServiceImpl extends ServiceImpl<DengguangbaoxiuDao, DengguangbaoxiuEntity> implements DengguangbaoxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DengguangbaoxiuEntity> page = this.selectPage(
                new Query<DengguangbaoxiuEntity>(params).getPage(),
                new EntityWrapper<DengguangbaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DengguangbaoxiuEntity> wrapper) {
		  Page<DengguangbaoxiuView> page =new Query<DengguangbaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DengguangbaoxiuVO> selectListVO(Wrapper<DengguangbaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DengguangbaoxiuVO selectVO(Wrapper<DengguangbaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DengguangbaoxiuView> selectListView(Wrapper<DengguangbaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DengguangbaoxiuView selectView(Wrapper<DengguangbaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
