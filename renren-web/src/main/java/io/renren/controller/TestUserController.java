package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.TestUserEntity;
import io.renren.service.TestUserService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-12 16:50:01
 */
@RestController
@RequestMapping("testuser")
public class TestUserController {
	@Autowired
	private TestUserService testUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("testuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TestUserEntity> testUserList = testUserService.queryList(query);
		int total = testUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(testUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("testuser:info")
	public R info(@PathVariable("id") Integer id){
		TestUserEntity testUser = testUserService.queryObject(id);
		
		return R.ok().put("testUser", testUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("testuser:save")
	public R save(@RequestBody TestUserEntity testUser){
		testUserService.save(testUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("testuser:update")
	public R update(@RequestBody TestUserEntity testUser){
		testUserService.update(testUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("testuser:delete")
	public R delete(@RequestBody Integer[] ids){
		testUserService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
