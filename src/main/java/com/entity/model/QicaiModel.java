package com.entity.model;

import com.entity.QicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 器材
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-04-06 00:13:18
 */
public class QicaiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 器材名称
	 */
	
	private String qicaimingcheng;
		
	/**
	 * 器材分类
	 */
	
	private String qicaifenlei;
		
	/**
	 * 器材注意事项
	 */
	
	private String qicaizhuyishixiang;
		
	/**
	 * 器材说明
	 */
	
	private String qicaishuoming;
		
	/**
	 * 器材图片
	 */
	
	private String qicaitupian;
				
	
	/**
	 * 设置：器材名称
	 */
	 
	public void setQicaimingcheng(String qicaimingcheng) {
		this.qicaimingcheng = qicaimingcheng;
	}
	
	/**
	 * 获取：器材名称
	 */
	public String getQicaimingcheng() {
		return qicaimingcheng;
	}
				
	
	/**
	 * 设置：器材分类
	 */
	 
	public void setQicaifenlei(String qicaifenlei) {
		this.qicaifenlei = qicaifenlei;
	}
	
	/**
	 * 获取：器材分类
	 */
	public String getQicaifenlei() {
		return qicaifenlei;
	}
				
	
	/**
	 * 设置：器材注意事项
	 */
	 
	public void setQicaizhuyishixiang(String qicaizhuyishixiang) {
		this.qicaizhuyishixiang = qicaizhuyishixiang;
	}
	
	/**
	 * 获取：器材注意事项
	 */
	public String getQicaizhuyishixiang() {
		return qicaizhuyishixiang;
	}
				
	
	/**
	 * 设置：器材说明
	 */
	 
	public void setQicaishuoming(String qicaishuoming) {
		this.qicaishuoming = qicaishuoming;
	}
	
	/**
	 * 获取：器材说明
	 */
	public String getQicaishuoming() {
		return qicaishuoming;
	}
				
	
	/**
	 * 设置：器材图片
	 */
	 
	public void setQicaitupian(String qicaitupian) {
		this.qicaitupian = qicaitupian;
	}
	
	/**
	 * 获取：器材图片
	 */
	public String getQicaitupian() {
		return qicaitupian;
	}
			
}
