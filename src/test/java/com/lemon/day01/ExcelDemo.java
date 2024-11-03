package com.lemon.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelDemo {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		//1.创建workbook工作簿对象
		File file = new File("src/test/resources/student.xlsx");//文件的相对路径
		InputStream inputStream = new FileInputStream(file);//读取Excel文件
		Workbook workbook = WorkbookFactory.create(inputStream);//创建Excel文件对象
		
		//2.创建sheet表单对象
		Sheet sheet = workbook.getSheetAt(0);            //根据索引获取第几张表单
		//Sheet sheet1 = workbook.getSheet("Sheet1");      //根据表单的名字获取第几张表单
		
		//获取表单的Row（行）对象
		for (int i = 0; i <= 2; i++) {
			Row row = sheet.getRow(i);
			//System.out.println(row);
			for (int j = 0; j <= 3; j++) {
				Cell cell = row.getCell(j);
				//将每一列数据当做字符串处理
				cell.setCellType(CellType.STRING);
				//获取每一列的值
				String cellvalue = cell.getStringCellValue();
				System.out.println(cellvalue);
			}
		}

	}

}
