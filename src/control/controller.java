package control;

import model.*;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class controller {
    Koneksi koneksi;
    ArrayList<data_guru> arrdataguru;
    ArrayList<pendaftaran> arrpendaftaran;
    ArrayList<data_pendaftar> arrdatapendaftar;

    public controller () throws SQLException {
        this.koneksi= new Koneksi();
        arrdataguru = new ArrayList<>();
        arrpendaftaran = new ArrayList<>();
        arrdatapendaftar = new ArrayList<>();
    }
    
    public ArrayList<data_pendaftar> getPendaftar() throws SQLException{
        arrdatapendaftar.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM T_DATAPENDAFTAR");
        while(rs.next()){
            data_pendaftar dp = new data_pendaftar();
            dp.setId_pendaftar(rs.getInt("ID_PENDAFTAR"));
            dp.setNama_pendaftar(rs.getString("NAMA_PENDAFTAR"));
            dp.setUmur_pendaftar(rs.getInt("UMUR_PENDAFTAR"));
            dp.setKelas_pendaftar(rs.getString("KELAS_PENDAFTAR"));
            
            arrdatapendaftar.add(dp);
        }   
        return arrdatapendaftar;
    }
    
    public ArrayList<data_guru> getGuru() throws SQLException{
        arrdataguru.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM T_DATAGURU");
        while(rs.next()){
            data_guru dg = new data_guru();
            dg.setId_guru(rs.getInt("ID_GURU"));
            dg.setNama_guru(rs.getString("NAMA_GURU"));
            dg.setAlamat_guru(rs.getString("ALAMAT_GURU"));
            dg.setKelas(rs.getString("KELAS"));
            dg.setJadwal(rs.getString("JADWAL_GURU"));
            
            arrdataguru.add(dg);
        }
        
        return arrdataguru;
    }
    
    public ArrayList<pendaftaran> getpendaftaran() throws SQLException {
    arrpendaftaran.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM T_PENDAFTARAN JOIN T_DATAGURU ON "
                + "T_PENDAFTARAN.ID_GURU=T_DATAGURU.ID_GURU JOIN T_DATAPENDAFTAR ON "
                + "T_PENDAFTARAN.ID_PENDAFTAR=T_DATAPENDAFTAR.ID_PENDAFTAR");
        
        while (rs.next()) {
            data_guru dg = new data_guru();
            dg.setId_guru(rs.getInt("ID_GURU"));
            dg.setNama_guru(rs.getString("NAMA_GURU"));
            dg.setAlamat_guru(rs.getString("ALAMAT_GURU"));
            dg.setKelas(rs.getString("KELAS"));
            dg.setJadwal(rs.getString("JADWAL_GURU"));
            
            data_pendaftar dp = new data_pendaftar();
            dp.setId_pendaftar(rs.getInt("ID_PENDAFTAR"));
            dp.setNama_pendaftar(rs.getString("NAMA_PENDAFTAR"));
            dp.setUmur_pendaftar(rs.getInt("UMUR_PENDAFTAR"));
            dp.setKelas_pendaftar(rs.getString("KELAS_PENDAFTAR"));
            
            pendaftaran p = new pendaftaran();
            p.setNo_pendaftaran(rs.getInt("NO_PENDAFTARAN"));
            p.setData_Pendaftar(dp);
            p.setData_Guru(dg);
            p.setTanggal_pendaftar(rs.getDate("TANGGAL_PENDAFTAR"));
            p.setHarga_khursus(rs.getInt("HARGA_KHURSUS"));
            
            arrpendaftaran.add(p);
        }
    return arrpendaftaran;
    }  
    
    public void insertPendataran (pendaftaran Pendaftaran){
        try{
            String datePendaftar = new SimpleDateFormat("dd/MM/yyyy").format(Pendaftaran.getTanggal_pendaftar());
            koneksi.ManipulasiData("INSERT INTO T_PENDAFTARAN VALUES (NO_PENDAFTARAN.NEXTVAL," 
                + Pendaftaran.getData_Pendaftar().getId_pendaftar() + "," 
                + Pendaftaran.getData_Guru().getId_guru() + ",TO_DATE('" + datePendaftar +"','dd/MM/yyyy')," + Pendaftaran.getHarga_khursus()+")") ;
        ResultSet rs = koneksi.GetData("SELECT NO_PENDAFTARAN.CURRVAL FROM DUAL");
        System.err.println(rs);
        rs.next();
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    public void insertPendaftar(data_pendaftar data_Pendaftar){
        try {
            koneksi.ManipulasiData("INSERT INTO T_DATAPENDAFTAR VALUES (ID_PENDAFTAR.NEXTVAL, '" +data_Pendaftar.getNama_pendaftar()+ "'," +data_Pendaftar.getUmur_pendaftar()+ ",'" +data_Pendaftar.getKelas_pendaftar()+ "')");
            ResultSet rs = koneksi.GetData("SELECT ID_PENDAFTAR.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatePendaftar(data_pendaftar data_Pendaftar, String nama, int umur, String kelas){
        koneksi.ManipulasiData("UPDATE T_DATAPENDAFTAR SET NAMA_PENDAFTAR = '" +nama+ "', UMUR_PENDAFTAR = " +umur+ ", KELAS_PENDAFTAR = '" +kelas+ "' WHERE ID_PENDAFTAR = " +data_Pendaftar.getId_pendaftar());
    }
    public void deletePendaftar(data_pendaftar data){
        koneksi.ManipulasiData("DELETE T_DATAPENDAFTAR WHERE ID_PENDAFTAR = " +data.getId_pendaftar());
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    