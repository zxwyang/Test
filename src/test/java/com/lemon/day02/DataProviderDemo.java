package com.lemon.day02;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**testng������
 *   ͨ��@DataProvider�������ṩ�ߣ�����ɵ����ܵ����������
 * @author Administrator
 *
 */
public class DataProviderDemo {
	/**ͨ��dataProviderע���������������
	 * @param username
	 * @param password
	 */
	@Test(dataProvider="datas")
	public void login(String username ,String password) {
		System.out.println(username+"-"+password);
	}
	
	/**�ṩ����������
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
