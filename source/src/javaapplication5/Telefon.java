/**
*
* @author Aytekin Erlale
* @since 03/04/2018
* <p>
* Kurallara uygun Tc kimlik numarası üreten ve kontrol eden java sınıfı
* 
* </p>
*/
package javaapplication5;
import java.util.Random;
/**
 *
 * @author Aytekin
 */
public class Telefon {
    
    private int[] TelefonNo = new int[11];

    public int[] getTelefonNo() {
        return TelefonNo;
    }

    public void setTelefonNo(int[] TelefonNo) {
        this.TelefonNo = TelefonNo;
    }
    
    //telefon numarası uretilen method
    public void TelefonNoUret(){
        Random rand = new Random();
        int n;
        
        TelefonNo[0] = 0;
        TelefonNo[1] = 5;
        
        do
        n = rand.nextInt(5);
        while(n == 2 || n == 1);
        
        TelefonNo[2] = n;
        
        for (int i = 3; i < 10; i++) {
            TelefonNo[i] = rand.nextInt(9);
        }
        
    }
    
    //telefon numarası dogrulugu kontrol ediliyor
    public boolean TelefonNoKontrol(int[] telefon){
        
        if(telefon.length == 11){
            if(telefon[0] == 0 && telefon[1] == 5)
                if(telefon[3] == 0 || telefon[3] == 3 || telefon[3] == 4 || telefon[3] == 5)
                    return true;

        }
        return false;
    }
    
}
