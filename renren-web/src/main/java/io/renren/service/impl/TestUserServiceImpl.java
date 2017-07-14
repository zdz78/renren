package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.TestUserDao;
import io.renren.entity.TestUserEntity;
import io.renren.service.TestUserService;



@Service("testUserService")
public class TestUserServiceImpl implements TestUserService {
	@Autowired
	private TestUserDao testUserDao;
	
	@Override
	public TestUserEntity queryObject(Integer id){
		return testUserDao.queryObject(id);
	}
	
	@Override
	public List<TestUserEntity> queryList(Map<String, Object> map){
		return testUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return testUserDao.queryTotal(map);
	}
	
	@Override
	public void save(TestUserEntity testUser){
		testUserDao.save(testUser);
	}
	
	@Override
	public void update(TestUserEntity testUser){
		testUserDao.update(testUser);
	}
	
	@Override
	public void delete(Integer id){
		testUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		testUserDao.deleteBatch(ids);
	}
	
}
