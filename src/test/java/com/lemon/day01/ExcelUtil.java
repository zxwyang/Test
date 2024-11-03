package com.lemon.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		ExcelUtil eUtil = new ExcelUtil();
		
		List<RestApi> restApis = eUtil.loadApis();
		for (RestApi restApi : restApis) {
			System.out.println(restApi);
		}
		
		Object[][] datas = eUtil.datas(restApis);
		for (Object[] objects : datas) {
			System.out.println(Arrays.toString(objects));
		}
		

	}
    public List<RestApi> loadApis() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		//����workbook����������
		File file = new File("src/test/resources/cases_v1.xls");//�ļ������·��
		InputStream inputStream = new FileInputStream(file);//��ȡExcel�ļ�
		Workbook workbook = WorkbookFactory.create(inputStream);//����Excel�ļ�����
		
		//��ȡsheet������
		Sheet sheet = workbook.getSheetAt(0);//��ȡ��һ�ű�����������Ϊ0
		
		//����һ���������ڴ�Ż�ȡ������
		List<RestApi> restApis = new ArrayList<RestApi>();
		
		//ѭ����������ȡÿһ��
		for (int i = 0; i <= 6;i++) {
			Row row = sheet.getRow(i);
			//RestApi restApi = new RestApi();   ������������������ӦrestApi.setCaseId(cellvalue);    ��һ�ַ���
			
			String caseId = null;//�ڶ��ָ�ֵ����
			String name = null;
			String url = null;
			String type = null;
			String desc = null;
			String mobilephone = null;
			String pwd = null;
			
			//ѭ��������ȡÿһ�е�����
			for (int j=0;j<=6; j++) {
				Cell cell = row.getCell(j);
				//��ÿһ�е����ݵ����ַ�������
				cell.setCellType(CellType.STRING);
				//��ȡ��ֵ
				String cellvalue = cell.getStringCellValue();
				//�����ݸ�����Ӧ����
				if (j==0) {
					caseId =cellvalue;                         //�ڶ��ָ�ֵ����
					//restApi.setCaseId(cellvalue);          //��һ�ָ�ֵ����
				}else if(j==1){
					name = cellvalue;
					//restApi.setName(cellvalue);
				}else if(j==2){
					url = cellvalue;
					//restApi.setUrl(cellvalue);
				}else if(j==3){
					type = cellvalue;
					//restApi.setType(cellvalue);
				}else if(j==4){
					desc = cellvalue;
					//restApi.setDesc(cellvalue);
				}else if(j==5){
					mobilephone = cellvalue;
					//restApi.setMobilephone(cellvalue);
				}else if(j==6){
					pwd = cellvalue;
					//restApi.setPwd(cellvalue);
				}	
				
			}
			//��������ӵ�����                                 ����������ӦrestApi.setCaseId(cellvalue);
			//restApis.add(restApi);
			
			
			//��װRestApi��
			RestApi restApi = new RestApi(caseId, name, url, type, desc, mobilephone, pwd);
			//��������ӵ�����
			restApis.add(restApi);
		}
		//���ؼ���
		return restApis;
	}
    
    //����һ����ά���鷽��
    public Object[][] datas(List<RestApi> restApis){
    	//����һ������������ڴ���URL��mobilephone��pwd����
		Object [][] arr = new Object[restApis.size()] [3];
		//����restApi����
    	for (int i = 0; i < restApis.size(); i++) {
    		//��ȡÿһ��
    		RestApi restApi =  restApis.get(i);
    		//��ȡ��Ӧ��URL��mobilephone��pwd����
    		String url = restApi.getUrl();
    		String mobilephone = restApi.getMobilephone();
    		String pwd = restApi.getPwd();
    		arr[i][0] = url;
    		arr[i][1] = mobilephone;
    		arr[i][2] = pwd;
		}
    	
    	return arr;
    	
    }
	
	
}
