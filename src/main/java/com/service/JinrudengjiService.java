package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinrudengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinrudengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinrudengjiView;


/**
 * 进入登记
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface JinrudengjiService extends IService<JinrudengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinrudengjiVO> selectListVO(Wrapper<JinrudengjiEntity> wrapper);
   	
   	JinrudengjiVO selectVO(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
   	
   	List<JinrudengjiView> selectListView(Wrapper<JinrudengjiEntity> wrapper);
   	
   	JinrudengjiView selectView(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinrudengjiEntity> wrapper);
   	
}

