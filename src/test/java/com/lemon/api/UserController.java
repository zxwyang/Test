package com.lemon.api;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemon.pojo.Result;
import com.lemon.api.User;




/**Controller:��������ʵ������ַ���һ����ڿ������ж���ӿڣ�
 * @author Administrator
 *
 */
@RestController                 //�������ǿ�������
@RequestMapping("/user")        //����ӳ�䣬ӳ��·��
public class UserController {
	/**ע��ӿ�-->http://ip:�˿�/user/register
	 * ����
	 * 1.�û���Ϊ�գ�����ʾ���û�������Ϊ�ա�
	 * 2.����Ϊ�գ�����ʾ�����벻��Ϊ�ա�
	 * 3.����û���Ϊnickjiang����ʾ�˺���ע�ᣬ���������ʾע��ɹ�
	 * @param username �û��� ���ش��ֶΣ�
	 * @param password ���루�ش��ֶΣ�
	 * @return �ӿڷ��أ�status�ֶΣ�1������ɹ���0�������¼ʧ�ܣ���message�ֶΣ��û���ʾ��Ϣ��
	 */
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public Result register(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		//����û���Ϊ��
		if (username==null||username.trim().length()==0) {
			Result result = new Result("0","�û���Ϊ��");
			return result;
		}
		//�������Ϊ��
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","���벻��Ϊ��");
			return result;
		}
		//�˺���ע��
		if ("nickjiang".equals(username)) {
			Result result = new Result("0","�˺���ע��");
			return result;
		}
		//ע��ɹ�
		return new Result("1","�˺�ע��ɹ�");
	}
	
	
	/**��¼�ӿ�-->http://ip:�˿�/user/login
	 * ����
	 * 1.�û���Ϊ�գ�����ʾ���û�������Ϊ�ա�
	 * 2.����Ϊ�գ�����ʾ�����벻��Ϊ�ա�
	 * 3.����û���Ϊnickjiang������Ϊ123456���Ǿ���Ϊ����¼�ɹ��ˣ������¼ʧ��
	 * @param username �û��� ���ش��ֶΣ�
	 * @param password ���루�ش��ֶΣ�
	 * @return �ӿڷ��أ�status�ֶΣ�1������ɹ���0�������¼ʧ�ܣ���message�ֶΣ��û���ʾ��Ϣ��
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/x-www-form-urlencoded")        
	public Result login(String username ,String password) {
		//����û���Ϊ��
		if (username==null||username.trim().length()==0) {
			Result result = new Result("0","�û�������Ϊ��");
			return result;
		}
		//�������Ϊ��
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","���벻��Ϊ��");
			return result;
		}
		//�û����������벻��ȷ
		if ("nickjiang".equals(username)&&"123456".equals(password)) {
			Result result = new Result("1","�û���¼�ɹ�");
			return result;
		}
		Result result = new Result("0","�û��������벻��ȷ");
		return result;
	}
	
	/**��¼�ӿ�-->http://ip:�˿�/user/resetPassword
	 * ����
	 * 1.�û���Ϊ�գ�����ʾ���û�������Ϊ�ա�
	 * 2.����Ϊ�գ�����ʾ�����벻��Ϊ�ա�
	 * 3.����û���Ϊnickjiang���ͷ��ز��޴��ˣ����򷵻��������óɹ�
	 * @param user �û��� ���ش��ֶΣ�    ���루�ش��ֶΣ�
	 * @return �ӿڷ��أ�status�ֶΣ�1������ɹ���0�������¼ʧ�ܣ���message�ֶΣ��û���ʾ��Ϣ��
	 */
	@RequestMapping(value="/resetpassword",method=RequestMethod.POST,consumes="application/json")
	public Result resetpassword(@RequestBody (required=false) User user) {
		String username = null;
		String password = null;
		//user����Ϊ��
		if (user!=null) {
			username = user.getUsername();
			password = user.getPassword();
		}
		//�û�������Ϊ��
		if (username == null||username.trim().length()==0) {
			Result result = new Result("0","�û���Ϊ��");
			return result;
		}
		//���벻��Ϊ��
		if (password==null||password.trim().length()==0) {
			Result result = new Result("0","���벻��Ϊ��");
			return result;
		}
		//�û����ظ�
		if ("nickjiang".equals(username)) {
			Result result = new Result("0", "���޴���");
			return result;
		}
		//�������óɹ�
		return new Result("1", "�������óɹ�");
		
	}
	
}
