package com.lemon.api;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemon.pojo.Result;
import com.lemon.api.User;




/**Controller:控制器（实现请求分发，一般会在控制器中定义接口）
 * @author Administrator
 *
 */
@RestController                 //声明类是控制器类
@RequestMapping("/user")        //请求映射，映射路径
public class UserController {
	/**注册接口-->http://ip:端口/user/register
	 * 需求：
	 * 1.用户名为空，就提示“用户名不能为空”
	 * 2.密码为空，就提示“密码不能为空”
	 * 3.如果用户名为nickjiang，提示账号已注册，其他情况提示注册成功
	 * @param username 用户名 （必传字段）
	 * @param password 密码（必传字段）
	 * @return 接口返回，status字段（1：代表成功，0：代表登录失败），message字段（用户提示信息）
	 */
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public Result register(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		//如果用户名为空
		if (username==null||username.trim().length()==0) {
			Result result = new Result("0","用户名为空");
			return result;
		}
		//如果密码为空
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","密码不能为空");
			return result;
		}
		//账号已注册
		if ("nickjiang".equals(username)) {
			Result result = new Result("0","账号已注册");
			return result;
		}
		//注册成功
		return new Result("1","账号注册成功");
	}
	
	
	/**登录接口-->http://ip:端口/user/login
	 * 需求：
	 * 1.用户名为空，就提示“用户名不能为空”
	 * 2.密码为空，就提示“密码不能为空”
	 * 3.如果用户名为nickjiang，密码为123456我们就认为它登录成功了，否则登录失败
	 * @param username 用户名 （必传字段）
	 * @param password 密码（必传字段）
	 * @return 接口返回，status字段（1：代表成功，0：代表登录失败），message字段（用户提示信息）
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/x-www-form-urlencoded")        
	public Result login(String username ,String password) {
		//如果用户名为空
		if (username==null||username.trim().length()==0) {
			Result result = new Result("0","用户名不能为空");
			return result;
		}
		//如果密码为空
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","密码不能为空");
			return result;
		}
		//用户名或者密码不正确
		if ("nickjiang".equals(username)&&"123456".equals(password)) {
			Result result = new Result("1","用户登录成功");
			return result;
		}
		Result result = new Result("0","用户名或密码不正确");
		return result;
	}
	
	/**登录接口-->http://ip:端口/user/resetPassword
	 * 需求：
	 * 1.用户名为空，就提示“用户名不能为空”
	 * 2.密码为空，就提示“密码不能为空”
	 * 3.如果用户名为nickjiang，就返回查无此人，否则返回密码重置成功
	 * @param user 用户名 （必传字段）    密码（必传字段）
	 * @return 接口返回，status字段（1：代表成功，0：代表登录失败），message字段（用户提示信息）
	 */
	@RequestMapping(value="/resetpassword",method=RequestMethod.POST,consumes="application/json")
	public Result resetpassword(@RequestBody (required=false) User user) {
		String username = null;
		String password = null;
		//user不能为空
		if (user!=null) {
			username = user.getUsername();
			password = user.getPassword();
		}
		//用户名不能为空
		if (username == null||username.trim().length()==0) {
			Result result = new Result("0","用户名为空");
			return result;
		}
		//密码不能为空
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","密码不能为空");
			return result;
		}
		//用户名重复
		if ("nickjiang".equals(username)) {
			Result result = new Result("0", "查无此人");
			return result;
		}
		//密码重置成功
		return new Result("1", "密码重置成功");
		
	}
	
}
