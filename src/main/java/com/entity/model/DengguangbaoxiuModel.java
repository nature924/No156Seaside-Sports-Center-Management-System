package com.entity.model;

import com.entity.DengguangbaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 灯光保修
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public class DengguangbaoxiuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 灯光类型
	 */
	
	private String dengguangleixing;
		
	/**
	 * 是否维修
	 */
	
	private String shifouweixiu;
		
	/**
	 * 维修时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date weixiushijian;
		
	/**
	 * 灯光具体位置
	 */
	
	private String dengguangjutiweizhi;
		
	/**
	 * 灯光损害程度
	 */
	
	private String dengguangsunhaichengdu;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 维修联系电话
	 */
	
	private String weixiulianxidianhua;
				
	
	/**
	 * 设置：灯光类型
	 */
	 
	public void setDengguangleixing(String dengguangleixing) {
		this.dengguangleixing = dengguangleixing;
	}
	
	/**
	 * 获取：灯光类型
	 */
	public String getDengguangleixing() {
		return dengguangleixing;
	}
				
	
	/**
	 * 设置：是否维修
	 */
	 
	public void setShifouweixiu(String shifouweixiu) {
		this.shifouweixiu = shifouweixiu;
	}
	
	/**
	 * 获取：是否维修
	 */
	public String getShifouweixiu() {
		return shifouweixiu;
	}
				
	
	/**
	 * 设置：维修时间
	 */
	 
	public void setWeixiushijian(Date weixiushijian) {
		this.weixiushijian = weixiushijian;
	}
	
	/**
	 * 获取：维修时间
	 */
	public Date getWeixiushijian() {
		return weixiushijian;
	}
				
	
	/**
	 * 设置：灯光具体位置
	 */
	 
	public void setDengguangjutiweizhi(String dengguangjutiweizhi) {
		this.dengguangjutiweizhi = dengguangjutiweizhi;
	}
	
	/**
	 * 获取：灯光具体位置
	 */
	public String getDengguangjutiweizhi() {
		return dengguangjutiweizhi;
	}
				
	
	/**
	 * 设置：灯光损害程度
	 */
	 
	public void setDengguangsunhaichengdu(String dengguangsunhaichengdu) {
		this.dengguangsunhaichengdu = dengguangsunhaichengdu;
	}
	
	/**
	 * 获取：灯光损害程度
	 */
	public String getDengguangsunhaichengdu() {
		return dengguangsunhaichengdu;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：维修联系电话
	 */
	 
	public void setWeixiulianxidianhua(String weixiulianxidianhua) {
		this.weixiulianxidianhua = weixiulianxidianhua;
	}
	
	/**
	 * 获取：维修联系电话
	 */
	public String getWeixiulianxidianhua() {
		return weixiulianxidianhua;
	}
			
}
