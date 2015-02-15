/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitinsurana.struts2spring3hibernate.actions;

import com.lwx.freightcsvload.CheckController;
import com.lwx.freightcsvload.FreightCell;
import com.lwx.freightcsvload.FreightManager;
import com.opensymphony.xwork2.ModelDriven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nitin
 */
//The Struts2 action is no longer need to extends the ActionSupport, Spring will handle it.
@Component
public class CustomerAction {

	@Autowired
	CheckController checkController;
	
	@Autowired
	FreightManager freightManager;
	
    public String addCustomer() throws Exception {
        //save it
		CsvConfig cfg = new CsvConfig();
		cfg.setIgnoreEmptyLines(true);                       // ãÛçsÇñ≥éãÇ∑ÇÈÇÊÇ§Ç…ÇµÇ‹Ç∑ÅB
		
		//System.out.println(new File(".").getAbsolutePath());
		//System.getProperty("java.class.path")
		
		try {
			//System.getProperty("user.dir");
			freightManager.originalFreightList = Csv.load(new File(System.getProperty("user.dir")+"/freightlist01.csv"), cfg, new StringArrayListHandler());
			//System.out.println("listsize:"+list.size());
			checkController.isFormatErrorGlobalFlg = true;
			checkController.debugPrint(freightManager.originalFreightList);
			
			for(int i = 2;i<freightManager.originalFreightList.size();i++){
				String[] oneRow = freightManager.originalFreightList.get(i);
				for (int j = 3;j<oneRow.length;j++){
					String oneCell = oneRow[j];
					FreightCell freightCell = new FreightCell();
					freightCell.rowNo = i+1;
					freightCell.columnNo = j+1;
					freightCell.transitFrom = freightManager.originalFreightList.get(i)[0];
					freightCell.transitTo = freightManager.originalFreightList.get(1)[j];
					freightCell.freight = oneCell;
					
					checkController.checkFormatErrorFreightIsNumber(freightCell);
					
					String strKey = freightCell.transitFrom + "_" + freightCell.transitTo;
					List<FreightCell> lstFreightCell = freightManager.getMapFreightTeam().get(strKey);
					if(lstFreightCell == null){
						lstFreightCell = new LinkedList<FreightCell>();
					}
					lstFreightCell.add(freightCell);
					freightManager.getMapFreightTeam().put(strKey, lstFreightCell);
					
					if (j+1==oneRow.length){

					} else {
						
					}
				}
			}
			
			for (Map.Entry<String, List<FreightCell>> entry : freightManager.getMapFreightTeam().entrySet()) {
				for (FreightCell freightCell:entry.getValue()){
					System.out.println("key= " + entry.getKey() + " and value= " + freightCell.rowNo + "-" + freightCell.columnNo + "-" + freightCell.freight);
				}
			}
			
			//System.out.print(String.format("%-10s", "a"));
			//System.out.print(checkController.isFormatError);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "success";

    }

    public String listCustomer() throws Exception {
        return "success";

    }
}
