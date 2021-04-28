import java.util.Random;
import java.util.Scanner;

public class SezarSifrelemeCozme {

	public static void main(String[] args) {
		String sifreliMetin = "";
        String cozumlenmýsMetin = "";
        char[] alfabe = new char[52];
        int indis = 0;
        int gidilecekIndis;
        System.out.print("Þifrelenecek Metni Giriniz ::");
        Scanner alinanMetin = new Scanner(System.in);
        String metin = alinanMetin.nextLine();
        Random rnd = new Random();
        int anahtar = rnd.nextInt(1000) + 1;

        for (int i = 65; i < 91; i++) {
            alfabe[indis] = (char) i;
            indis++;
        }
        for (int i = 97; i < 123; i++) {
            alfabe[indis] = (char) i;
            indis++;
        }
        // ÞÝFRELEME
        for (int i = 0; i < metin.length(); i++) {
            for (int j = 0; j < alfabe.length; j++) {
                if (metin.charAt(i) == alfabe[j]) {
                    if (metin.charAt(i)==' ') {
                        sifreliMetin +=" ";
                    } else {
                        gidilecekIndis = ((j + anahtar) % alfabe.length);
                        sifreliMetin += alfabe[gidilecekIndis];
                        System.out.println(gidilecekIndis + " indise git");
                    }
                }
            }
        }

        if (!metin.equals(sifreliMetin)) {
            System.out.println("Metin : " + metin);
            System.out.println("Anahtar Sayýnýzý Kimseyle Paylaþmayýn :" + anahtar);
            System.out.println("Þifreli metin : " + sifreliMetin);
        }

        //ÞÝFRE ÇÖZME
        for (int i = 0; i < sifreliMetin.length(); i++) {
            for (int j = 0; j < alfabe.length; j++) {
                if (sifreliMetin.charAt(i) == alfabe[j]) {

                    gidilecekIndis = (Math.abs(alfabe.length - (Math.abs(j - anahtar)) % alfabe.length));
                    if (gidilecekIndis < alfabe.length) {
                        cozumlenmýsMetin += alfabe[gidilecekIndis];
                    } else if (gidilecekIndis >= alfabe.length) {
                        cozumlenmýsMetin += alfabe[gidilecekIndis % alfabe.length];
                    }
                    System.out.println(gidilecekIndis + " indise git");
                }
            }
        }
           
            System.out.println("Þifreli metin : " + sifreliMetin);
             System.out.println("Anahtar Sayýnýzý Kimseyle Paylaþmayýn :" + anahtar);
            System.out.println("Þifresi Çözümlenmiþ metin " + cozumlenmýsMetin);
	}

}
