package com.entity.view;

import com.entity.DengguangbaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 灯光保修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@TableName("dengguangbaoxiu")
public class DengguangbaoxiuView  extends DengguangbaoxiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DengguangbaoxiuView(){
	}
 
 	public DengguangbaoxiuView(DengguangbaoxiuEntity dengguangbaoxiuEntity){
 	try {
			BeanUtils.copyProperties(this, dengguangbaoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
