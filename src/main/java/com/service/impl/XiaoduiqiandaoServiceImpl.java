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


import com.dao.XiaoduiqiandaoDao;
import com.entity.XiaoduiqiandaoEntity;
import com.service.XiaoduiqiandaoService;
import com.entity.vo.XiaoduiqiandaoVO;
import com.entity.view.XiaoduiqiandaoView;

@Service("xiaoduiqiandaoService")
public class XiaoduiqiandaoServiceImpl extends ServiceImpl<XiaoduiqiandaoDao, XiaoduiqiandaoEntity> implements XiaoduiqiandaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoduiqiandaoEntity> page = this.selectPage(
                new Query<XiaoduiqiandaoEntity>(params).getPage(),
                new EntityWrapper<XiaoduiqiandaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoduiqiandaoEntity> wrapper) {
		  Page<XiaoduiqiandaoView> page =new Query<XiaoduiqiandaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoduiqiandaoVO> selectListVO(Wrapper<XiaoduiqiandaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoduiqiandaoVO selectVO(Wrapper<XiaoduiqiandaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoduiqiandaoView> selectListView(Wrapper<XiaoduiqiandaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoduiqiandaoView selectView(Wrapper<XiaoduiqiandaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
