/**
*
* @author Aytekin Erlale 
* @since 03/04/2018
* <p>
* Kisi sınıfı 
* 
* </p>
*/
package javaapplication5;

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
 * @author Aytekin
 */
public final class Kisi {
    
    private Telefon telefon;
    private KimlikNo kimlikNo;
    private IMEINo imeiNo;
    private String adSoyad;
    private int yas;
    
    
    public Kisi(String Yol) throws IOException {
        telefon=new Telefon();
        telefon.TelefonNoUret();
        kimlikNo = new KimlikNo();
        kimlikNo.KimlikNoUret();
        imeiNo = new IMEINo();
        imeiNo.imeiNoUret();
        
        YasAta();
        AdSoyadAta(Yol);    
    }

    public int getYas() {
        return yas;
    }

    public int[] getTelefon() {
        return telefon.getTelefonNo();
    }

    public int[] getKimlikNo() {
        return kimlikNo.getKimlikNo();
    }

    public int[] getImeiNo() {
        return imeiNo.getImeiNo();
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void YasAta() {
        Random r = new Random();
        this.yas = r.nextInt(99) + 1; 
    }
    
    public void AdSoyadAta(String KlasorYolu)throws IOException{
        Random r = new Random();
        int n = r.nextInt(2999) + 1;
        int sayac = 0;
        
        File file = new File(KlasorYolu);
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
                String data = reader.readLine();
                    
                    while (data!=null) {
                        data = reader.readLine();
                        if(sayac == n){
                            adSoyad = data;
                            break;
                        }
                        else
                            sayac++;  
                    }
   
    }


    
  
}
