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


import com.dao.QicaijiechuDao;
import com.entity.QicaijiechuEntity;
import com.service.QicaijiechuService;
import com.entity.vo.QicaijiechuVO;
import com.entity.view.QicaijiechuView;

@Service("qicaijiechuService")
public class QicaijiechuServiceImpl extends ServiceImpl<QicaijiechuDao, QicaijiechuEntity> implements QicaijiechuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicaijiechuEntity> page = this.selectPage(
                new Query<QicaijiechuEntity>(params).getPage(),
                new EntityWrapper<QicaijiechuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QicaijiechuEntity> wrapper) {
		  Page<QicaijiechuView> page =new Query<QicaijiechuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QicaijiechuVO> selectListVO(Wrapper<QicaijiechuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QicaijiechuVO selectVO(Wrapper<QicaijiechuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QicaijiechuView> selectListView(Wrapper<QicaijiechuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QicaijiechuView selectView(Wrapper<QicaijiechuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
