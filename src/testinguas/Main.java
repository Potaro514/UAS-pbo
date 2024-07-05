package testinguas;

import java.util.Scanner;

public class Main {
    private static Pelanggan[] pelangganArray = new Pelanggan[3];
    private static int pelangganCounter = 0;
    private static final int CLEAR_SCREEN_LINES = 35;
    private static final String ANSI_RESET = "\u001B[0m"; // ANSI reset code
    private static final String ANSI_RED = "\u001B[31m"; // ANSI red color code

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            if (pelangganCounter >= pelangganArray.length) {
                System.out.println(ANSI_RED + "Limit kouta habis, silahkan coba lagi nanti" + ANSI_RESET);
                break; 
            }
            
            System.out.println("===== Program Cetak Kartu ======");
            System.out.println();
            System.out.print("Masukan nama Pelanggan: ");
            String nama = scanner.nextLine();
            System.out.print("Masukan email: ");
            String email = scanner.nextLine();
            System.out.print("Masukan no telpon: ");
            String telpon = scanner.nextLine();

            System.out.println();
            System.out.print("Masukkan tanggal daftar (dd): ");
            String inputHari = scanner.nextLine();
            System.out.print("Masukkan bulan daftar (mm): ");
            String inputBulan = scanner.nextLine();
            System.out.print("Masukkan tahun daftar (yyyy): ");
            String inputTahun = scanner.nextLine();
            
            if (inputHari.length() != 2 || inputBulan.length() != 2 || inputTahun.length() != 4) {
                System.out.println(ANSI_RED + "Format tanggal tidak sesuai (harus dd/mm/yyyy)" + ANSI_RESET);
                break;
            }

            int hari = Integer.parseInt(inputHari);
            int bulan = Integer.parseInt(inputBulan);
            int tahun = Integer.parseInt(inputTahun);
            
            System.out.println();
            System.out.println("Apakah anda mau menjadi Anggota Gold");
            System.out.println("hanya dengan dengan biaya Rp.50.000?");
            System.out.print("y/t: ");
            String membershipChoice = scanner.nextLine();

            Pelanggan pelanggan;
            if (membershipChoice.equalsIgnoreCase("y")) {
                pelanggan = new PelangganGOLD(nama, email, telpon, hari, bulan, tahun);
            } else {
                pelanggan = new Pelanggan(nama, email, telpon, hari, bulan, tahun);
            }

            pelangganArray[pelangganCounter] = pelanggan;
            pelangganCounter++;

            System.out.println("\nTekan Enter untuk mencetak ");
            scanner.nextLine();

            String kodeunik = "00" + pelangganCounter +hari + bulan + inputTahun.substring(2);

            System.out.println("Kartu anda sudah selesai:");
            System.out.println("==============================================");
            System.out.println("|             Kartu Tanda Anggota         "+ pelanggan.getType());
            System.out.println("|---------------------------------------------");
            System.out.println("|    -------");
            System.out.println("|    |  _  |  Nama     : "+ pelanggan.getNama());
            System.out.println("|    | ( ) |  Email    : "+ pelanggan.getEmail());
            System.out.println("|    |(   )|  No. Telp : "+ pelanggan.getTelpon());
            System.out.println("|    -------");
            System.out.println("|   exp : "+ pelanggan.getExp());
            System.out.println("|                                   #"+ kodeunik);
            System.out.println("|=============================================");
            System.out.println("==============================================");
            System.out.println("\nTerima kasih, silahkan ambil Kartu di loker.");
            System.out.print("Mau Mendaftar lagi? (y/t): ");
            String repeatChoice = scanner.nextLine();
            
            if (!repeatChoice.equalsIgnoreCase("y")) {
                continueProgram = false;
            }
            clearConsole();
            
        }
        scanner.close();
    }
    private static void clearConsole() {
        for (int i = 0; i < CLEAR_SCREEN_LINES; i++) {
            System.out.println();
        }
    }
}