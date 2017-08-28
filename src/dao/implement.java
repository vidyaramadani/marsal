/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_model;

/**
 *
 * @author Vidya
 */
public interface implement {

     public void TampilData(m_model a);     
     public void UbahData(m_model a);     
     public void SimpanData(m_model a);     
     public void HapusData(String kode);     
     public List<m_model> getCariKategori(String kategori);     
     public List<m_model> getAll(); 

    public List<m_model> getCari(String item);
    
}
