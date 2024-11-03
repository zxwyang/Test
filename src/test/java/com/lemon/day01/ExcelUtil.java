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
		
		//创建workbook工作簿对象
		File file = new File("src/test/resources/cases_v1.xls");//文件的相对路径
		InputStream inputStream = new FileInputStream(file);//读取Excel文件
		Workbook workbook = WorkbookFactory.create(inputStream);//创建Excel文件对象
		
		//获取sheet表单对象，
		Sheet sheet = workbook.getSheetAt(0);//获取第一张表单对象，其索引为0
		
		//创建一个集合用于存放获取的数据
		List<RestApi> restApis = new ArrayList<RestApi>();
		
		//循环遍历，获取每一行
		for (int i = 0; i <= 6;i++) {
			Row row = sheet.getRow(i);
			//RestApi restApi = new RestApi();   ————————对应restApi.setCaseId(cellvalue);    第一种方法
			
			String caseId = null;//第二种赋值方法
			String name = null;
			String url = null;
			String type = null;
			String desc = null;
			String mobilephone = null;
			String pwd = null;
			
			//循环遍历获取每一列的数据
			for (int j=0;j<=6; j++) {
				Cell cell = row.getCell(j);
				//将每一列的数据当做字符串处理
				cell.setCellType(CellType.STRING);
				//获取列值
				String cellvalue = cell.getStringCellValue();
				//将数据赋予相应列中
				if (j==0) {
					caseId =cellvalue;                         //第二种赋值方法
					//restApi.setCaseId(cellvalue);          //第一种赋值方法
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
			//将数据添加到集合                                 ————对应restApi.setCaseId(cellvalue);
			//restApis.add(restApi);
			
			
			//封装RestApi类
			RestApi restApi = new RestApi(caseId, name, url, type, desc, mobilephone, pwd);
			//将数据添加到集合
			restApis.add(restApi);
		}
		//返回集合
		return restApis;
	}
    
    //创建一个二维数组方法
    public Object[][] datas(List<RestApi> restApis){
    	//创建一个数组对象用于储存URL、mobilephone、pwd数据
		Object [][] arr = new Object[restApis.size()] [3];
		//遍历restApi集合
    	for (int i = 0; i < restApis.size(); i++) {
    		//获取每一行
    		RestApi restApi =  restApis.get(i);
    		//获取相应的URL、mobilephone、pwd数据
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
