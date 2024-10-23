package com.entity.view;

import com.entity.JinrudengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 进入登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@TableName("jinrudengji")
public class JinrudengjiView  extends JinrudengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JinrudengjiView(){
	}
 
 	public JinrudengjiView(JinrudengjiEntity jinrudengjiEntity){
 	try {
			BeanUtils.copyProperties(this, jinrudengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
