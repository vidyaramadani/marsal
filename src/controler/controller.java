/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.List; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableModel; 
import dao.m_dao; 
import dao.implement; 
import model.m_model; 
import view.home; 
import model.tableModel; 
/**
 *
 * @author Vidya
 */
public class controller {
     home hm;     
     implement impmar;     
     List<m_model> lt; 
     
     public controller (home hm){         
         this.hm = hm;         
         impmar = (implement) new m_dao();         
         lt = impmar.getAll();    
     }
     
     //mengkosongkan isian field     
     public void Reset(){         
         hm.getId().setText("");         
         hm.getPid().setText("");         
         hm.getSid().setText("");         
         hm.getSnm().setText("");   
         hm.getJns().setSelectedItem(null);  
         hm.getOpt().setText("");
     } 
     
     //menghapus data yang dipilih     
     public void Hapus(){         
         if (hm.getId().getText().trim().isEmpty()){             
             JOptionPane.showMessageDialog(hm, "Pilih Data");         
         }else{             
             String kode = (hm.getId().getText());             
             impmar.HapusData(kode);             
             JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");        
         }      
}
     
      //menyimpan data     
     public void SimpanData(){        
         m_model mdl = new m_model();         
         mdl.setid(hm.getId().getText());         
         mdl.setpid(hm.getPid().getText());         
         mdl.setsid(hm.getSid().getText());         
         mdl.setsnm(hm.getSnm().getText());         
         mdl.setjns(hm.getJns().getSelectedItem().toString()); 
         mdl.setopt(hm.getOpt().getText());
         impmar.SimpanData(mdl);     
}
     
      //mengubah data    
     public void Ubah(){         
         m_model mdl = new m_model();         
         mdl.setid(hm.getId().getText());         
         mdl.setpid(hm.getPid().getText());         
         mdl.setsid(hm.getSid().getText());         
         mdl.setsnm(hm.getSnm().getText());         
         mdl.setjns(hm.getJns().getSelectedItem().toString()); 
         mdl.setopt(hm.getOpt().getText());
         impmar.UbahData(mdl);
     }
     
      public void isiTable() {     
          lt =impmar.getAll();
           tableModel tmt = new tableModel(lt);     
           hm.getTableData().setModel(tmt);
      } 
      
       public void isiField(int row){     
           hm.getId().setText(lt.get(row).getID().toString());     
           hm.getPid().setText(lt.get(row).getPid().toString());   
           hm.getSid().setText(lt.get(row).getSid().toString());
           hm.getSnm().setText(lt.get(row).getSnm().toString());
           hm.getJns().setSelectedItem(lt.get(row).getJns().toString());     
           hm.getOpt().setText(lt.get(row).getOpt().toString());                   
       } 
       
        public void CariKategori(){         
            if (!hm.getCariKategori().getText().toString().isEmpty()) {             
                isiTableCariKategori();
            } else {             
                JOptionPane.showMessageDialog(hm, "Silahkan Ketik ID Mitratel");
            }     
        } 

    private void isiTableCariKategori() {
         String item = hm.getCariKategori().getText().toString(); 
         lt =impmar.getCari(item);        
         tableModel tmt = new tableModel(lt);        
         hm.getTableData().setModel(tmt); 
    }
}
