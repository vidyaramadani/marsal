/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import controler.m_koneksi; 
import model.m_model;
/**
 *
 * @author Vidya
 */
public class m_dao implements implement{
     Connection connection; 
     
      public String TampilData = "SELECT * FROM `data`";
      public String UbahData = "UPDATE `data` SET `PID`=?, `SID`=?, `SNM`=?, `JNS`=?,`OPT`=? Where `ID`=?;";
      public String SimpanData = "INSERT INTO `data` VALUES (?, ?, ?, ?, ?)";
      public String HapusData = "DELETE FROM `data` WHERE ID=?"; 
      public String CariKategori = "SELECT `ID`, `PID`, `SID`, `SNM`, `JNS`, `OPT` FROM `data` WHERE ID like ?";
      
      public m_dao(){
          connection = m_koneksi.setKoneksi();
      }
    @Override
    public void TampilData(m_model a) {
    }

    @Override
    public void UbahData(m_model a) {
        PreparedStatement statement = null; 
         try {         
             statement = connection.prepareStatement(UbahData);        
             statement.setString(5, a.getID());        
             statement.setString(1, a.getPid());         
             statement.setString(2, a.getSid());         
             statement.setString(3, a.getSnm());        
             statement.setString(4, a.getJns()); 
             statement.setString(6, a.getOpt());
             statement.executeUpdate();              
         }   catch (SQLException ex) {            
             Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);         
         }
    }

    @Override
    public void SimpanData(m_model a) {
        PreparedStatement statement = null;     
        try {         
            statement = connection.prepareStatement(SimpanData);         
            statement.setString(1, a.getID());        
             statement.setString(2, a.getPid());         
             statement.setString(3, a.getSid());         
             statement.setString(4, a.getSnm());        
             statement.setString(5, a.getJns()); 
             statement.setString(6, a.getOpt());
             statement.executeUpdate();        
            ResultSet rs = statement.getGeneratedKeys();         
            while (rs.next()){             
                a.setid(rs.getString(1));         
            }     
        }   catch (SQLException ex) {             
            Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);        
        }   
    }

    //hapus data
    @Override
    public void HapusData(String id) {
        PreparedStatement statement = null;
        try {         
            statement = connection.prepareStatement(HapusData);         
            statement.setString(1, id);         
            statement.executeUpdate();              
        }  catch (SQLException ex) {             
            Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);        
        } 
    }

     //menampilkan data ke tabel sesuai pencarian
    @Override
    public List<m_model> getCariKategori(String kategori) {
         List<m_model> lt=null; 
         try {         
             lt = new ArrayList<m_model>();          
             PreparedStatement st=connection.prepareStatement(CariKategori);         
             st.setString(1, "%"+kategori+"%");         
             ResultSet rs = st.executeQuery();         
             while (rs.next()){             
                 m_model mdl = new m_model();             
                 mdl.setid(rs.getString("ID"));             
                 mdl.setpid(rs.getString("PID"));            
                 mdl.setsid(rs.getString("SID"));            
                 mdl.setsnm(rs.getString("SNM"));            
                 mdl.setjns(rs.getString("JNS"));    
                 mdl.setopt(rs.getString("OPT"));
                 lt.add(mdl);     }     
         
         }   catch (SQLException ex) {
    Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);         
}    
         return lt;     
    }
//menampilkan data ke Tabel
    @Override
    public List<m_model> getAll() {
         List<m_model> lt=null; 
         try {         
             lt = new ArrayList<m_model>();         
         Statement st = connection.createStatement();         
         ResultSet rs = st.executeQuery(TampilData);         
         while (rs.next()){             
               m_model mdl = new m_model();             
                 mdl.setid(rs.getString("ID"));             
                 mdl.setpid(rs.getString("PID"));            
                 mdl.setsid(rs.getString("SID"));            
                 mdl.setsnm(rs.getString("SNM"));            
                 mdl.setjns(rs.getString("JNS"));    
                 mdl.setopt(rs.getString("OPT"));
                 lt.add(mdl);     } 
         }catch (SQLException ex) {             
             Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);        
         }    
         return lt; }
 

   //pencarian data     
public void CariKategori(int id) {     
PreparedStatement statement = null; 
 try {         
statement = connection.prepareStatement(CariKategori);         
statement.setInt(1, id);         
statement.executeUpdate();             

} catch (SQLException ex) {             
Logger.getLogger(m_dao.class.getName()).log(Level.SEVERE, null, ex);        
}
}

    @Override
    public List<m_model> getCari(String item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

