/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.ControllerTeman;

import UAS.Model.Modelteman;
import UAS.Util.Koneksi;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ControllerTeman {
    Koneksi koneksi = new Koneksi();
    
    
   public void simpanData(Modelteman mt){
       koneksi.koneksiDatabase();
       String query ="insert into tbl_teman(nama,nope,email) values ('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
       try {
           koneksi.state.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"data berhasil disimpan");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "tidak berhasil disimpan");
           System.err.println(""+e);
       }
       
   }
   public void hapusData(Modelteman mt){
       try {
           koneksi.koneksiDatabase();
           String query ="delete from tbl_teman where id=('"+mt.getId()+"')";
           koneksi.state.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"data berhasil dihapus");
         } catch (SQLException e) {
             System.err.println("Error:"+e);
             JOptionPane.showMessageDialog(null,"data tidak terhapus");
       }
   }
   
   public void ubahData(Modelteman  mt){
       koneksi.koneksiDatabase();
       try {
           int id =mt.getId();
           String nama =mt.getNama();
           String nope =mt.getNope();
           String Email=mt.getEmail();
           
           String query ="update tbl_teman"
                         +"set namaTeman=('"+nama+"');"
                         +"set nope=('"+nope+"')"
                         +"set email=('"+Email+"')"
                         +"where Id=('"+id+"')";
           koneksi.state.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Data berhasi; di update");
           } catch (SQLException e) {
               System.err.println("Error:"+e);
               JOptionPane.showMessageDialog(null,"Data gagal di update");
       }
   }
}
