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


import com.dao.LikaidengjiDao;
import com.entity.LikaidengjiEntity;
import com.service.LikaidengjiService;
import com.entity.vo.LikaidengjiVO;
import com.entity.view.LikaidengjiView;

@Service("likaidengjiService")
public class LikaidengjiServiceImpl extends ServiceImpl<LikaidengjiDao, LikaidengjiEntity> implements LikaidengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LikaidengjiEntity> page = this.selectPage(
                new Query<LikaidengjiEntity>(params).getPage(),
                new EntityWrapper<LikaidengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LikaidengjiEntity> wrapper) {
		  Page<LikaidengjiView> page =new Query<LikaidengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LikaidengjiVO> selectListVO(Wrapper<LikaidengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LikaidengjiVO selectVO(Wrapper<LikaidengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LikaidengjiView> selectListView(Wrapper<LikaidengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LikaidengjiView selectView(Wrapper<LikaidengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
