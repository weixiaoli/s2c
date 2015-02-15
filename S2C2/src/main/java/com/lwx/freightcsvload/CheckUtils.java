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

import org.springframework.stereotype.Component;

/**
 *
 * @author lwx
 */
@Component
public class CheckUtils{
	
	public boolean checkIsNumber(String strValue){
		  Pattern pt = Pattern.compile("^\\d*");
		  Matcher mt = pt.matcher(strValue);
		  return mt.matches();
	}
	
}
