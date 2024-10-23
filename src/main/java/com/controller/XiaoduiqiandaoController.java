package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiaoduiqiandaoEntity;
import com.entity.view.XiaoduiqiandaoView;

import com.service.XiaoduiqiandaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 校队签到
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@RestController
@RequestMapping("/xiaoduiqiandao")
public class XiaoduiqiandaoController {
    @Autowired
    private XiaoduiqiandaoService xiaoduiqiandaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoduiqiandaoEntity xiaoduiqiandao,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date qiandaoshijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date qiandaoshijianend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		xiaoduiqiandao.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<XiaoduiqiandaoEntity> ew = new EntityWrapper<XiaoduiqiandaoEntity>();
		if(qiandaoshijianstart!=null) ew.ge("qiandaoshijian", qiandaoshijianstart);
        	if(qiandaoshijianend!=null) ew.le("qiandaoshijian", qiandaoshijianend);
		PageUtils page = xiaoduiqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoduiqiandao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoduiqiandaoEntity xiaoduiqiandao, HttpServletRequest request){
        EntityWrapper<XiaoduiqiandaoEntity> ew = new EntityWrapper<XiaoduiqiandaoEntity>();
		PageUtils page = xiaoduiqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoduiqiandao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoduiqiandaoEntity xiaoduiqiandao){
       	EntityWrapper<XiaoduiqiandaoEntity> ew = new EntityWrapper<XiaoduiqiandaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoduiqiandao, "xiaoduiqiandao")); 
        return R.ok().put("data", xiaoduiqiandaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoduiqiandaoEntity xiaoduiqiandao){
        EntityWrapper< XiaoduiqiandaoEntity> ew = new EntityWrapper< XiaoduiqiandaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoduiqiandao, "xiaoduiqiandao")); 
		XiaoduiqiandaoView xiaoduiqiandaoView =  xiaoduiqiandaoService.selectView(ew);
		return R.ok("查询校队签到成功").put("data", xiaoduiqiandaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoduiqiandaoEntity xiaoduiqiandao = xiaoduiqiandaoService.selectById(id);
        return R.ok().put("data", xiaoduiqiandao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoduiqiandaoEntity xiaoduiqiandao = xiaoduiqiandaoService.selectById(id);
        return R.ok().put("data", xiaoduiqiandao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoduiqiandaoEntity xiaoduiqiandao, HttpServletRequest request){
    	xiaoduiqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoduiqiandao);
    	xiaoduiqiandao.setUserid((Long)request.getSession().getAttribute("userId"));
        xiaoduiqiandaoService.insert(xiaoduiqiandao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoduiqiandaoEntity xiaoduiqiandao, HttpServletRequest request){
    	xiaoduiqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoduiqiandao);
        xiaoduiqiandaoService.insert(xiaoduiqiandao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoduiqiandaoEntity xiaoduiqiandao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoduiqiandao);
        xiaoduiqiandaoService.updateById(xiaoduiqiandao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoduiqiandaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XiaoduiqiandaoEntity> wrapper = new EntityWrapper<XiaoduiqiandaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = xiaoduiqiandaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
