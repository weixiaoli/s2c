/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwx.freightcsvload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lwx
 */
@Component
public class CheckController{
	
	@Autowired
	CheckUtils checkUtils;
	
	public enum BackColor {  
		NOPROBLEM_BLANK, 
		ERROR_RED, 
		ALERT_YELLOW  
	} 
	
	public boolean isFormatErrorGlobalFlg = false;
	
	public boolean isLogicErrorGlobalFlg = false;
	
	public boolean isLogicAlertGlobalFlg = false;
	
	
	//---------------------------------フォーマットチェック　開始------------------------------------//
	/**
	 * 運賃額が半角数字のチェック
	 * @param freightCell
	 */
	public void checkFormatErrorFreightIsNumber(FreightCell freightCell){
		if(checkUtils.checkIsNumber(freightCell.freight)){
			return;
		} else {
			writeFormatErrorLog(freightCell, "半角数字しかできない。");
		}
	}
	//---------------------------------フォーマットチェック　終了------------------------------------//
	
	
	//---------------------------------ロジックチェック　開始--------------------------------------//
	/**
	 * 運賃額が半角数字のチェック
	 * @param freightCell
	 */
	/*public void checkFormatErrorFreightIsNumber(FreightCell freightCell){
		if(checkUtils.checkIsNumber(freightCell.freight)){
			return;
		} else {
			writeFormatErrorLog(freightCell, "半角数字しかできない。");
		}
	}*/
	//---------------------------------ロジックチェック　終了--------------------------------------//
	
	
	
	
	
	static Logger formatErrorLog = Logger.getLogger(CheckController.class.getClass());
	
	public void writeFormatErrorLog(FreightCell freightCell, String errorMessage){
		System.out.println("フォーマットエラー：[" + freightCell.rowNo + "]行、[" + freightCell.columnNo + "]列のレコードは" + errorMessage);
		isFormatErrorGlobalFlg = true;
	}
	
	public void debugPrint(List<String[]> list){		
		for(String[] oneRow:list){
			for (int j = 0;j<oneRow.length;j++){
				String oneCell = oneRow[j];
				if (j+1==oneRow.length){
					System.out.println(String.format("%-12s", oneCell));
				}else{
					System.out.print(String.format("%-12s", oneCell)+",");
				}
			}
		}		
	}
	
	
	
	
	
	private static List<String> lstFormatError;
 
    public static void setLstFormatError(List<String> lstFormatError) {
		CheckController.lstFormatError = lstFormatError;
	}

	public static List<String> getLstFormatError() {
       if (lstFormatError == null) {
    	   lstFormatError = new LinkedList<String>();
       }
       return lstFormatError;
    }

	
	

	
	
	
	

	
}
