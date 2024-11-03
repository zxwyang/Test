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
		
		//1.����workbook����������
		File file = new File("src/test/resources/student.xlsx");//�ļ������·��
		InputStream inputStream = new FileInputStream(file);//��ȡExcel�ļ�
		Workbook workbook = WorkbookFactory.create(inputStream);//����Excel�ļ�����
		
		//2.����sheet������
		Sheet sheet = workbook.getSheetAt(0);            //����������ȡ�ڼ��ű�
		//Sheet sheet1 = workbook.getSheet("Sheet1");      //���ݱ������ֻ�ȡ�ڼ��ű�
		
		//��ȡ����Row���У�����
		for (int i = 0; i <= 2; i++) {
			Row row = sheet.getRow(i);
			//System.out.println(row);
			for (int j = 0; j <= 3; j++) {
				Cell cell = row.getCell(j);
				//��ÿһ�����ݵ����ַ�������
				cell.setCellType(CellType.STRING);
				//��ȡÿһ�е�ֵ
				String cellvalue = cell.getStringCellValue();
				System.out.println(cellvalue);
			}
		}

	}

}
