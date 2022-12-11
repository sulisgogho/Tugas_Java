import java.util.Scanner;  // Import the Scanner class
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

class Main {
  /**
   * @param args1
   */
  public static void main(String[] args) {
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
         //Deklarasi variabel
         int jum=0, i=0;
         double total_bayar=0;
         //Deklarasi array
         int [] kode = new int[5];
         int [] qty = new int[5];
         int [] harga = new int[5];
         double [] sub_total = new double[5];
         String [] barang = new String[5];

    System.out.println("GEROBAK AYAM GORENG PAK KAMIDI");
    System.out.println("--------------------------------");

    System.out.println("Kode   Jenis     Harga");
    System.out.println("--------------------------------");
    System.out.println("[1]    Dada     Rp.2500");
    System.out.println("[2]    Paha     Rp.2000");
    System.out.println("[3]    Sayap    Rp.1500");
    System.out.println("--------------------------------");

    Scanner beli = new Scanner(System.in);
    System.out.print("Berapa jenis yang dibeli : " );
    jum= beli.nextInt();
         System.out.println("--------------------------------");
         //Memasukan elemen didalam array
         for (i=0; i<jum;i++){
              System.out.println ("Jenis Ke- "+(i+1));
              System.out.print("Jenis Potong [1/2/3] : ");
              kode[i] = beli.nextInt();
              System.out.print("Banyak Potong : ");
              qty[i]=beli.nextInt();
              //Menentukan barang berdasarkan kode yang dimmasukan
              switch (kode[i]){
                  case 1 : 
                            barang[i]="Dada";
                            harga[i]=2500;
                            break;
                  case 2 : 
                            barang[i]="Paha";
                            harga[i]=2000;
                            break;
                  case 3 : 
                            barang[i]="Sayap";
                            harga[i]=1500;
                            break;
                  default : 
                            System.out.println("Kode Barang Tidak Tersedia");
              }

         }
          //Pengaturan format number
          formatRp.setCurrencySymbol("Rp. ");
          formatRp.setMonetaryDecimalSeparator(',');
          formatRp.setGroupingSeparator('.');
          kursIndonesia.setDecimalFormatSymbols(formatRp);
          
          System.out.println(" ");
          System.out.println("No.   | Jenis      | Harga          | Banyak  | Jumlah");  
          //Menampilkan seluruh elemen di dalam array
          for (i=0; i<jum;i++){ 
             sub_total[i]=((qty[i]*harga[i]));
             total_bayar+=sub_total[i];
              System.out.println(i+1+"      "+barang[i]+ "         "+kursIndonesia.format(harga[i])+"     "+qty[i]+"          "+kursIndonesia.format(sub_total[i])); 
          }
          System.out.println(" ");
          //Menampilkan total bayar
          System.out.println("Total Bayar : "+kursIndonesia.format(total_bayar));
  }
}
