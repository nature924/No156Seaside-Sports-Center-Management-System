package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongyuyueView;


/**
 * 活动预约
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface HuodongyuyueService extends IService<HuodongyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongyuyueVO> selectListVO(Wrapper<HuodongyuyueEntity> wrapper);
   	
   	HuodongyuyueVO selectVO(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
   	
   	List<HuodongyuyueView> selectListView(Wrapper<HuodongyuyueEntity> wrapper);
   	
   	HuodongyuyueView selectView(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongyuyueEntity> wrapper);
   	
}

