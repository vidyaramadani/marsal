/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List; 
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vidya
 */

public class tableModel extends AbstractTableModel{    
    List<m_model>lt;     
    public tableModel(List<m_model> lt) {     
    this.lt=lt;     

}

    @Override
    public int getRowCount() {
       return lt.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }
     public String getColumnName(int column) {     
         switch (column){         
             case 0:             
                 return"ID";         
             case 1:             
                 return"PID";         
             case 2:             
                 return"SID";         
             case 3:             
                 return"SNM";         
             case 4:             
                 return"JNS"; 
             case 5:             
                 return"OPT"; 
             default:             
                 return null;     
     }}

    @Override
    public Object getValueAt(int row, int column) {
   switch (column){
        case 0:             
            return lt.get(row).getID();         
        case 1:             
            return lt.get(row).getPid();         
        case 2:             
            return lt.get(row).getSid();         
        case 3:             
            return lt.get(row).getSnm();         
        case 4:             
            return lt.get(row).getOpt();  
        case 5:             
            return lt.get(row).getJns();
        default:
            return null;
   }
    }
}

