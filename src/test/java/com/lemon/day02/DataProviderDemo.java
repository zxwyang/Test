package com.lemon.day02;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**testng参数化
 *   通过@DataProvider（数据提供者）来完成单功能点的批量测试
 * @author Administrator
 *
 */
public class DataProviderDemo {
	/**通过dataProvider注入了三组测试数据
	 * @param username
	 * @param password
	 */
	@Test(dataProvider="datas")
	public void login(String username ,String password) {
		System.out.println(username+"-"+password);
	}
	
	/**提供了三组数据
	 * @return
	 */
	@DataProvider(name="datas")
	public Object[][] datas(){
		Object[][] datas = {
				{"nick","123456"},
				{"peter","123456"},
				{"jeremy","123456"}	
		};
		return datas;
	}
}
