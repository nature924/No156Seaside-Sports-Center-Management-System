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


import com.dao.QicaiDao;
import com.entity.QicaiEntity;
import com.service.QicaiService;
import com.entity.vo.QicaiVO;
import com.entity.view.QicaiView;

@Service("qicaiService")
public class QicaiServiceImpl extends ServiceImpl<QicaiDao, QicaiEntity> implements QicaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicaiEntity> page = this.selectPage(
                new Query<QicaiEntity>(params).getPage(),
                new EntityWrapper<QicaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QicaiEntity> wrapper) {
		  Page<QicaiView> page =new Query<QicaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QicaiVO> selectListVO(Wrapper<QicaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QicaiVO selectVO(Wrapper<QicaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QicaiView> selectListView(Wrapper<QicaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QicaiView selectView(Wrapper<QicaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
