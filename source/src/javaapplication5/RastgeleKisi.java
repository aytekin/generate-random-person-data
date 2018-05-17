/**
*
* @author Aytekin Erlale
* @since 03/04/2018
* <p>
* istenilen sayıda rastgele kişi oluşturan java sınıfı
* 
* </p>
*/
package javaapplication5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Aytekin
 */
public class RastgeleKisi {
    
    Kisi kisi; 
   
     
    public RastgeleKisi(int sayi,String yol)throws IOException{
       
        uret(sayi,yol);        
    }
    
    private void uret(int sayi,String yol)throws IOException{
        for (int i = 0; i < sayi; i++) {
            kisi = new Kisi(yol);
            String str = "";
            str += Donustur(kisi.getKimlikNo()) + " ";
            str += kisi.getAdSoyad() + " ";
            str += Integer.toString(kisi.getYas()) + " ";
            str += Donustur(kisi.getTelefon()) + " ";
            str += "(" + Donustur(kisi.getImeiNo()) + ")";

           Writer output;
           output = new BufferedWriter(new FileWriter("resource\\RastgeleKisi.txt",true));  
           output.append(str + "\r\n");
           
           
           output.close();
        }
            
    }
    
    private String Donustur(int[] dizi){
        
        StringBuilder sbfNumbers = new StringBuilder();
        
        String araDeger = "";
        
        if(dizi.length > 0){
            sbfNumbers.append(dizi[0]);
        
            for(int i=1; i < dizi.length; i++){
                sbfNumbers.append(araDeger).append(dizi[i]);
            }
			
	}
        return sbfNumbers.toString();
    }
    
    
}
        
