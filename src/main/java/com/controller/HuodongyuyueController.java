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

import com.entity.HuodongyuyueEntity;
import com.entity.view.HuodongyuyueView;

import com.service.HuodongyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 活动预约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@RestController
@RequestMapping("/huodongyuyue")
public class HuodongyuyueController {
    @Autowired
    private HuodongyuyueService huodongyuyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongyuyueEntity huodongyuyue,
		HttpServletRequest request){
        EntityWrapper<HuodongyuyueEntity> ew = new EntityWrapper<HuodongyuyueEntity>();
		PageUtils page = huodongyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongyuyueEntity huodongyuyue, HttpServletRequest request){
        EntityWrapper<HuodongyuyueEntity> ew = new EntityWrapper<HuodongyuyueEntity>();
		PageUtils page = huodongyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongyuyueEntity huodongyuyue){
       	EntityWrapper<HuodongyuyueEntity> ew = new EntityWrapper<HuodongyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongyuyue, "huodongyuyue")); 
        return R.ok().put("data", huodongyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongyuyueEntity huodongyuyue){
        EntityWrapper< HuodongyuyueEntity> ew = new EntityWrapper< HuodongyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongyuyue, "huodongyuyue")); 
		HuodongyuyueView huodongyuyueView =  huodongyuyueService.selectView(ew);
		return R.ok("查询活动预约成功").put("data", huodongyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongyuyueEntity huodongyuyue = huodongyuyueService.selectById(id);
        return R.ok().put("data", huodongyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongyuyueEntity huodongyuyue = huodongyuyueService.selectById(id);
        return R.ok().put("data", huodongyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongyuyueEntity huodongyuyue, HttpServletRequest request){
    	huodongyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongyuyue);
        huodongyuyueService.insert(huodongyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongyuyueEntity huodongyuyue, HttpServletRequest request){
    	huodongyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongyuyue);
        huodongyuyueService.insert(huodongyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongyuyueEntity huodongyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongyuyue);
        huodongyuyueService.updateById(huodongyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongyuyueService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuodongyuyueEntity> wrapper = new EntityWrapper<HuodongyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = huodongyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
