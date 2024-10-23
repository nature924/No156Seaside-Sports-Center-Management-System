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


import com.dao.JinrudengjiDao;
import com.entity.JinrudengjiEntity;
import com.service.JinrudengjiService;
import com.entity.vo.JinrudengjiVO;
import com.entity.view.JinrudengjiView;

@Service("jinrudengjiService")
public class JinrudengjiServiceImpl extends ServiceImpl<JinrudengjiDao, JinrudengjiEntity> implements JinrudengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinrudengjiEntity> page = this.selectPage(
                new Query<JinrudengjiEntity>(params).getPage(),
                new EntityWrapper<JinrudengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinrudengjiEntity> wrapper) {
		  Page<JinrudengjiView> page =new Query<JinrudengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinrudengjiVO> selectListVO(Wrapper<JinrudengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinrudengjiVO selectVO(Wrapper<JinrudengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinrudengjiView> selectListView(Wrapper<JinrudengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinrudengjiView selectView(Wrapper<JinrudengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
