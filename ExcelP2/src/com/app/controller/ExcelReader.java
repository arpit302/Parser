package com.app.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import com.app.dao.DaoImpl;
import com.app.pojos.User;
import com.app.service.Utils;
import com.app.utils.HibUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class ExcelReader {
//   public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\arpit.r\\Downloads\\FordDirect_DisplayAnalytics_AddAccts_UPDATED_20190131 (2).xlsx";

	public static void main(String[] args) throws IOException, InvalidFormatException {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the file you want to parse or update ");
		String SAMPLE_XLSX_FILE_PATH = sc.nextLine();
		// FileConverter.getExtension(SAMPLE_XLSX_FILE_PATH);
		// final String excel1 = null;
		User user = new User();
		HashMap<String, User> hm = new HashMap<String, User>();
		if ((HibUtils.getExtension(SAMPLE_XLSX_FILE_PATH)).equals("csv")) {

			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(SAMPLE_XLSX_FILE_PATH))) {

				if ((line = br.readLine()) != null) {
					String[] arr = line.split(cvsSplitBy);
					System.out.println(line);
					for (int i = 0; i <= 10; i++) {
						Utils.numberChecker(arr[i], i);
					}
					if (Utils.validityCheck()) {
						while ((line = br.readLine()) != null) {
							arr = line.split(cvsSplitBy);
							for (int i = 0; i <= 10; i++) {
								if (i != 8) {
									Utils.setObj(i, user, arr[i]);
								}
							}
							user.setPk();
							hm.put(user.getPk(), new User(user));
						}
					}
				}
				DaoImpl.saveToDB(hm);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if ((HibUtils.getExtension(SAMPLE_XLSX_FILE_PATH)).equals("xls")) {

			/*
			 * InputStream ExcelFileToRead = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
			 * HSSFWorkbook wb = HSSFWorkbook(ExcelFileToRead);
			 */
			HSSFWorkbook wb = (HSSFWorkbook) HSSFWorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
			System.out.println("Workbook has " + wb.getNumberOfSheets() + " Sheets. ");

			Sheet sheet = wb.getSheetAt(0);
			System.out.println("Name of sheet being processed is \"" + wb.getSheetName(0) + "\"");
			int uniqueRows = 0;

			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			Row initialRow = sheet.getRow(rowStart);
			int intRowColLast = initialRow.getLastCellNum();

			for (int i = 0; i < intRowColLast; i++) {
				Cell c = initialRow.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (c == null) {
					Utils.numberChecker("", i);
				} else {
					Utils.numberChecker(c.toString(), i);
				}
			}
			rowStart++;
			// Processing the data in rows
			if (Utils.validityCheck()) {
				for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					if (r == null) {
						// This whole row is empty
						// Handle it as needed
						continue;
					}
					int lastColumn = r.getLastCellNum();
					for (int cn = 0; cn < lastColumn; cn++) {
						Cell c = r.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
						if (c == null) {
							Utils.setObj(cn, user, null);
							// System.out.print("\t");
						} else if (cn == 8) {

						} else {
							// System.out.print(c.toString() + "\t");
							Utils.setObj(cn, user, c.toString());
						}
					}
					uniqueRows++;
					// System.out.println();
					user.setPk();
					hm.put(user.getPk(), new User(user));
				}
			}

		} else {
			Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

			// Retrieving the number of sheets in the Workbook
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets. ");

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(0);
			System.out.println("Name of sheet being processed is \"" + workbook.getSheetName(0) + "\"");
			// Decide which rows to process
			int uniqueRows = 0;
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			Row initialRow = sheet.getRow(rowStart);
			int intRowColLast = initialRow.getLastCellNum();

			for (int i = 0; i < intRowColLast; i++) {
				Cell c = initialRow.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (c == null) {
					Utils.numberChecker("", i);
				} else {
					Utils.numberChecker(c.toString(), i);
				}
			}
			rowStart++;
			// Processing the data in rows
			if (Utils.validityCheck()) {
				for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					if (r == null) {
						// This whole row is empty
						// Handle it as needed
						continue;
					}
					int lastColumn = r.getLastCellNum();
					for (int cn = 0; cn < lastColumn; cn++) {
						Cell c = r.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
						if (cn == 8) {

						} else if (c == null) {
							Utils.setObj(cn, user, null);
							// System.out.print("\t");
						} else {
							// System.out.print(c.toString() + "\t");
							Utils.setObj(cn, user, c.toString());
						}
					}
					uniqueRows++;
					// System.out.println();
					user.setPk();
					hm.put(user.getPk(), new User(user));
				}
			}
			DaoImpl.saveToDB(hm);
		}

	}
}
