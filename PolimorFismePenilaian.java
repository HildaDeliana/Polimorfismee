// Kelas utama Penilaian
class Penilaian {
    // Overloading: Menghitung nilai rata-rata dari beberapa nilai
    public double hitungRataRata(double[] nilai) {
        double total = 0;
        for (double n : nilai) {
            total += n;
        }
        return total / nilai.length;
    }

    // Overloading: Menghitung nilai rata-rata dari beberapa nilai dengan bobot tertentu
    public double hitungRataRata(double[] nilai, double[] bobot) {
        double total = 0;
        double totalBobot = 0;
        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i] * bobot[i];
            totalBobot += bobot[i];
        }
        return total / totalBobot;
    }
}

// Kelas PenilaianAkademik sebagai subclass yang memberikan bobot default jika bobot tidak disertakan
class PenilaianAkademik extends Penilaian {
    // Overriding: Menghitung nilai rata-rata dengan bobot nilai, namun memberikan bobot default jika bobot tidak disertakan
    @Override
    public double hitungRataRata(double[] nilai, double[] bobot) {
        if (bobot == null || bobot.length != nilai.length) {
            // Bobot default: Semua bobot bernilai 1
            bobot = new double[nilai.length];
            for (int i = 0; i < nilai.length; i++) {
                bobot[i] = 1;
            }
        }
        return super.hitungRataRata(nilai, bobot);
    }
}

public class PolimorfismePenilaian {
    public static void main(String[] args) {
        Penilaian penilaian = new Penilaian();
        double[] nilai = {80, 75, 85, 90};
        double[] bobot = {0.25, 0.25, 0.25, 0.25};
        System.out.println("Rata-rata: " + penilaian.hitungRataRata(nilai));
        System.out.println("Rata-rata dengan bobot: " + penilaian.hitungRataRata(nilai, bobot));

        PenilaianAkademik penilaianAkademik = new PenilaianAkademik();
        System.out.println("Rata-rata akademik: " + penilaianAkademik.hitungRataRata(nilai));
    }
}
