/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwx.freightcsvload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

import org.springframework.stereotype.Component;

import com.lwx.freightcsvload.CheckController.BackColor;

/**
 *
 * @author lwx
 */
public class FreightCell{

	//���s���{��
	public String transitFrom;
	
	//���s���{��
	public String transitTo;
	
	//�^���z
	public String freight;
	
	//�s�ԍ�
	public int rowNo;
	
	//��ԍ�
	public int columnNo;
	
	//�w�i�̐F
	public BackColor backColor;
	
	public FreightCell() {
		super();
		this.backColor = CheckController.BackColor.NOPROBLEM_BLANK;
	}
	
}
