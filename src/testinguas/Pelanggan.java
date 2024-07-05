package testinguas;

class Pelanggan {
    private String nama;
    private String email;
    private String telpon;
    private int hari;
    private int bulan;
    private int tahun;
    protected String exp;

    //konstruktor
    public Pelanggan(String nama, String email, String telpon, int hari, int bulan, int tahun) {
        this.nama = nama;
        this.email = email;
        this.telpon = telpon;
        this.hari = hari;
        this.bulan = bulan;
        this.tahun = tahun;
        this.exp = String.valueOf(tahun + 2);
    }

    //Aksesor tachi
    public String getNama() {return nama;}
    public String getEmail() {return email;}
    public String getTelpon() {return telpon;}
    
    public int getHari() {return hari;}
    public int getBulan() {return bulan;}
    public int getTahun() {return tahun;}

    public String getExp() {return exp;}

    public String getDetails() {
        return "Nama: " + nama + ", Email: " + email + ", No. Telp: " + telpon;
    }
    public String getType() {
        return "%%%%";
    }
    
    //Mutator tachi
    public void setExp(String exp) {
        this.exp = exp;
    }
}
