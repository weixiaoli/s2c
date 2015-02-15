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

	//î≠ìsìπï{åß
	public String transitFrom;
	
	//íÖìsìπï{åß
	public String transitTo;
	
	//â^í¿äz
	public String freight;
	
	//çsî‘çÜ
	public int rowNo;
	
	//óÒî‘çÜ
	public int columnNo;
	
	//îwåiÇÃêF
	public BackColor backColor;
	
	public FreightCell() {
		super();
		this.backColor = CheckController.BackColor.NOPROBLEM_BLANK;
	}
	
}
