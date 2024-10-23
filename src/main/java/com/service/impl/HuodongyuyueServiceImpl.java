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


import com.dao.HuodongyuyueDao;
import com.entity.HuodongyuyueEntity;
import com.service.HuodongyuyueService;
import com.entity.vo.HuodongyuyueVO;
import com.entity.view.HuodongyuyueView;

@Service("huodongyuyueService")
public class HuodongyuyueServiceImpl extends ServiceImpl<HuodongyuyueDao, HuodongyuyueEntity> implements HuodongyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongyuyueEntity> page = this.selectPage(
                new Query<HuodongyuyueEntity>(params).getPage(),
                new EntityWrapper<HuodongyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongyuyueEntity> wrapper) {
		  Page<HuodongyuyueView> page =new Query<HuodongyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongyuyueVO> selectListVO(Wrapper<HuodongyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongyuyueVO selectVO(Wrapper<HuodongyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongyuyueView> selectListView(Wrapper<HuodongyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongyuyueView selectView(Wrapper<HuodongyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
