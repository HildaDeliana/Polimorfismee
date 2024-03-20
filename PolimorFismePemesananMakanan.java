import java.util.HashMap;
import java.util.Map;

// Kelas utama PemesananMakanan
class PemesananMakanan {
    private Map<String, Integer> menu = new HashMap<>();

    // Menambahkan item menu ke daftar pesanan
    public void tambahPesanan(String item, int jumlah) {
        menu.put(item, jumlah);
    }

    // Overloading: Menghitung total harga pesanan
    public double hitungTotalHarga() {
        double total = 0;
        for (String item : menu.keySet()) {
            total += hargaItem(item) * menu.get(item);
        }
        return total;
    }

    // Overloading: Menghitung total harga pesanan dengan diskon
    public double hitungTotalHarga(double diskon) {
        double total = hitungTotalHarga();
        return total - (total * diskon);
    }

    // Mendapatkan harga sebuah item menu (fungsi fiktif)
    private double hargaItem(String item) {
        // Implementasi fiktif untuk harga item
        if (item.equals("Nasi Goreng")) {
            return 25000;
        } else if (item.equals("Ayam Goreng")) {
            return 30000;
        } else {
            return 0; // Harga default jika item tidak ditemukan
        }
    }
}

// Kelas PemesananMakananVIP sebagai subclass yang mengatasi kelemahan sistem pemesanan terkait pelanggan VIP
class PemesananMakananVIP extends PemesananMakanan {
    // Overriding: Menghitung total harga pesanan dengan diskon tambahan untuk pelanggan VIP
    @Override
    public double hitungTotalHarga(double diskon) {
        double total = super.hitungTotalHarga(diskon);
        return total * 0.9; // Diskon tambahan 10% untuk pelanggan VIP
    }
}

public class PolimorfismePemesananMakanan {
    public static void main(String[] args) {
        PemesananMakanan pesananBiasa = new PemesananMakanan();
        pesananBiasa.tambahPesanan("Nasi Goreng", 2);
        pesananBiasa.tambahPesanan("Ayam Goreng", 1);
        System.out.println("Total Harga Pesanan Biasa: " + pesananBiasa.hitungTotalHarga());

        PemesananMakananVIP pesananVIP = new PemesananMakananVIP();
        pesananVIP.tambahPesanan("Nasi Goreng", 2);
        pesananVIP.tambahPesanan("Ayam Goreng", 1);
        System.out.println("Total Harga Pesanan VIP: " + pesananVIP.hitungTotalHarga(0.1));
    }
}
