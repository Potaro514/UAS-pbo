package testinguas;

class PelangganGOLD extends Pelanggan {
    public PelangganGOLD(String nama, String email, String telpon, int hari, int bulan, int tahun) {
        super(nama, email, telpon, hari, bulan, tahun);
        this.setExp("-");
    }

    @Override
    public String getType() {
        return "GOLD";
    }
}