/**
*
* @author Aytekin Erlale 
* @since 03/04/2018
* <p>
*Kurallara uygun telefon numarası üreten ve kontrol eden java sınıfı
* 
* </p>
*/
package javaapplication5;

import java.util.Random;

/**
 *
 * @author Aytekin
 */
public class KimlikNo {
    
     private int[] kimlikNo = new int[11];

     public int[] getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(int[] kimlikNo) {
        this.kimlikNo = kimlikNo;
    }
     
    public void KimlikNoUret(){
      
        int sayac = 0;
        
        while(sayac<11){
            Random rand = new Random();
          int  n = rand.nextInt(9);
          
          while(sayac == 0 && n == 0)
            n = rand.nextInt(9);
          
          if(sayac < 9)
          {
              kimlikNo[sayac] = n;
              sayac++;
          }
          else if(sayac == 9)
          {
              int tek,cift;
              tek = cift = 0;
              for (int i = 0; i < 9; i++) {
                  
                  if((i+1) % 2 == 1)
                      tek += kimlikNo[i]; 
                  else if((i+1) % 2 == 0)
                      cift += kimlikNo[i];  
              }
              
              kimlikNo[9]  = ((tek * 7) - cift) %10;
              sayac++;
          }
          else if (sayac == 10)
          {
              int toplam = 0;
              
              for (int i = 0; i < 10; i++) {
                  toplam += kimlikNo[i]; 
              }
              kimlikNo[10] = toplam % 10;
              sayac++;
          }
            
        }
 
    }
     
     public boolean KimlikNoKontrol(int[] tcNo){
        if(tcNo.length == 11)
        {
            if(tcNo[0] == 0)
                return false;
            
            int tek,cift,durum;
            tek = cift = durum = 0;
            
            for (int i = 0; i < 9; i++) {
                if((i + 1)%2 == 1)
                    tek += tcNo[i];
                else
                    cift += tcNo[i];
            }
            boolean d_durum = ((tek * 7)-cift)%10 == tcNo[9]; 
            if(d_durum)
                durum=1;
            else
                return false;
            
            d_durum = (tek + cift + tcNo[9])%10 == tcNo[10];
            if(d_durum && durum == 1)
                return true;
        }
        return false;
     }
     
}
     
     
        