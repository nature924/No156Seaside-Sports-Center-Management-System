package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoduiqiandaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoduiqiandaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoduiqiandaoView;


/**
 * 校队签到
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface XiaoduiqiandaoService extends IService<XiaoduiqiandaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoduiqiandaoVO> selectListVO(Wrapper<XiaoduiqiandaoEntity> wrapper);
   	
   	XiaoduiqiandaoVO selectVO(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
   	
   	List<XiaoduiqiandaoView> selectListView(Wrapper<XiaoduiqiandaoEntity> wrapper);
   	
   	XiaoduiqiandaoView selectView(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoduiqiandaoEntity> wrapper);
   	
}

