// Kelas utama TokoOnline
class TokoOnline {
    // Overloading: Menghitung total harga belanja
    public double hitungTotalHarga(double hargaBarang, int jumlah) {
        return hargaBarang * jumlah;
    }

    // Overloading: Menghitung total harga belanja dengan diskon
    public double hitungTotalHarga(double hargaBarang, int jumlah, double diskon) {
        double total = hitungTotalHarga(hargaBarang, jumlah);
        return total - (total * diskon);
    }
}

// Kelas TokoOnlinePremium sebagai subclass yang mengatasi kelemahan sistem toko online terkait pelanggan premium
class TokoOnlinePremium extends TokoOnline {
    // Overriding: Menghitung total harga belanja dengan diskon tambahan untuk pelanggan premium
    @Override
    public double hitungTotalHarga(double hargaBarang, int jumlah, double diskon) {
        double total = super.hitungTotalHarga(hargaBarang, jumlah, diskon);
        return total * 0.95; // Diskon tambahan 5% untuk pelanggan premium
    }
}

public class PolimorfismeTokoOnline {
    public static void main(String[] args) {
        
    }