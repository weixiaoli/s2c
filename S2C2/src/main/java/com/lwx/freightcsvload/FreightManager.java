/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lwx.freightcsvload;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

import org.springframework.stereotype.Component;

/**
 *
 * @author lwx
 */
@Component
public class FreightManager{

	//Œ´ŽnCSV“ü—ÍƒŠƒXƒg
	public List<String[]> originalFreightList;
	
	private Map<String, List<FreightCell>> mapFreightTeam;

    public Map<String, List<FreightCell>> getMapFreightTeam() {
        if (mapFreightTeam == null) {
        	mapFreightTeam = new LinkedHashMap<String, List<FreightCell>>();
        }
		return mapFreightTeam;
	}
	
}
