package io.renren.service;

import io.renren.entity.TestUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-12 16:50:01
 */
public interface TestUserService {
	
	TestUserEntity queryObject(Integer id);
	
	List<TestUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TestUserEntity testUser);
	
	void update(TestUserEntity testUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
