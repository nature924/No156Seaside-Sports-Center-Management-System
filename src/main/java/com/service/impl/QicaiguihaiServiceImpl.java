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


import com.dao.QicaiguihaiDao;
import com.entity.QicaiguihaiEntity;
import com.service.QicaiguihaiService;
import com.entity.vo.QicaiguihaiVO;
import com.entity.view.QicaiguihaiView;

@Service("qicaiguihaiService")
public class QicaiguihaiServiceImpl extends ServiceImpl<QicaiguihaiDao, QicaiguihaiEntity> implements QicaiguihaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicaiguihaiEntity> page = this.selectPage(
                new Query<QicaiguihaiEntity>(params).getPage(),
                new EntityWrapper<QicaiguihaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QicaiguihaiEntity> wrapper) {
		  Page<QicaiguihaiView> page =new Query<QicaiguihaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QicaiguihaiVO> selectListVO(Wrapper<QicaiguihaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QicaiguihaiVO selectVO(Wrapper<QicaiguihaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QicaiguihaiView> selectListView(Wrapper<QicaiguihaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QicaiguihaiView selectView(Wrapper<QicaiguihaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
