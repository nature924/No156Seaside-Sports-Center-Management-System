package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DengguangbaoxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DengguangbaoxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DengguangbaoxiuView;


/**
 * 灯光保修
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface DengguangbaoxiuService extends IService<DengguangbaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DengguangbaoxiuVO> selectListVO(Wrapper<DengguangbaoxiuEntity> wrapper);
   	
   	DengguangbaoxiuVO selectVO(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
   	
   	List<DengguangbaoxiuView> selectListView(Wrapper<DengguangbaoxiuEntity> wrapper);
   	
   	DengguangbaoxiuView selectView(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DengguangbaoxiuEntity> wrapper);
   	
}

