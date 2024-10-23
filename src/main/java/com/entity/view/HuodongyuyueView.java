package com.entity.view;

import com.entity.HuodongyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@TableName("huodongyuyue")
public class HuodongyuyueView  extends HuodongyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongyuyueView(){
	}
 
 	public HuodongyuyueView(HuodongyuyueEntity huodongyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, huodongyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
