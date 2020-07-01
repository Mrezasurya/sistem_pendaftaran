package model;

import java.util.Date;
/**
 *
 * @author reza surya
 */
public class pendaftaran {
    private Integer no_pendaftaran;
    private data_pendaftar Data_Pendaftar;
    private data_guru Data_Guru;
    private Date tanggal_pendaftar;
    private Integer harga_khursus;    

    public Integer getNo_pendaftaran() {
        return no_pendaftaran;
    }

    public void setNo_pendaftaran(Integer no_pendaftaran) {
        this.no_pendaftaran = no_pendaftaran;
    }

    public data_pendaftar getData_Pendaftar() {
        return Data_Pendaftar;
    }

    public void setData_Pendaftar(data_pendaftar Data_Pendaftar) {
        this.Data_Pendaftar = Data_Pendaftar;
    }

    public data_guru getData_Guru() {
        return Data_Guru;
    }

    public void setData_Guru(data_guru Data_Guru) {
        this.Data_Guru = Data_Guru;
    }

    public Date getTanggal_pendaftar() {
        return tanggal_pendaftar;
    }

    public void setTanggal_pendaftar(Date tanggal_pendaftar) {
        this.tanggal_pendaftar = tanggal_pendaftar;
    }

    public Integer getHarga_khursus() {
        return harga_khursus;
    }

    public void setHarga_khursus(Integer harga_khursus) {
        this.harga_khursus = harga_khursus;
    }

    
    
}
