package model;

/**
 *
 * @author reza surya
 */
public class data_guru {

    private Integer id_guru;
    private String nama_guru;
    private String alamat_guru;
    private String kelas;
    private String jadwal;

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Integer getId_guru() {
        return id_guru;
    }

    public void setId_guru(Integer id_guru) {
        this.id_guru = id_guru;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getAlamat_guru() {
        return alamat_guru;
    }

    public void setAlamat_guru(String alamat_guru) {
        this.alamat_guru = alamat_guru;
    }
    
    
    
}
