package io.renren.api;

import io.renren.annotation.IgnoreAuth;
import io.renren.annotation.LoginUser;
import io.renren.entity.UserEntity;
import io.renren.utils.R;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }
    
    @GetMapping("test")
    public R test(){
    	Map<String,Object> map = new HashMap<>();
    	map.put("name", "Mr.Zhang");
    	map.put("age", 25);
    	map.put("sex", "男");
        return R.ok().put("user", map);
    }

    /**
     * 忽略Token验证测试
     */
    @IgnoreAuth
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }
}
