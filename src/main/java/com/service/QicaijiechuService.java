package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaijiechuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaijiechuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaijiechuView;


/**
 * 器材借出
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface QicaijiechuService extends IService<QicaijiechuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicaijiechuVO> selectListVO(Wrapper<QicaijiechuEntity> wrapper);
   	
   	QicaijiechuVO selectVO(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
   	
   	List<QicaijiechuView> selectListView(Wrapper<QicaijiechuEntity> wrapper);
   	
   	QicaijiechuView selectView(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicaijiechuEntity> wrapper);
   	
}

