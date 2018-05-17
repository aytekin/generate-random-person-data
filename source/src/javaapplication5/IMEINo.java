/**
*
* @author Aytekin Erlale 
* @since 03/04/2018
* <p>
* Kurallara uygun imei numarası üreten ve kontrol eden java sınıfı
* 
* </p>
*/
package javaapplication5;

import java.util.Random;

/**
 *
 * @author Aytekin
 */
public class IMEINo {
    
    private int imeiNo[] = new int[15];

    public int[] getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(int[] imeiNo) {
        this.imeiNo = imeiNo;
    }
    
    public void imeiNoUret(){
        
        Random rand = new Random();
        int n;
        do
        n = rand.nextInt(9);
        while(n == 0);
        
        imeiNo[0] = n;
        
        for (int i = 1; i < 14; i++) {
            imeiNo[i] = rand.nextInt(9);
        }
        
        int tek,cift,araDeger,birler,onlar;
        cift = tek = 0;
        
        for (int i = 0; i < 14; i++) {
            if(i % 2 == 0)
                tek += imeiNo[i];
            else
            {
                araDeger = imeiNo[i] * 2;
                if(araDeger < 10)
                    cift += araDeger;
                else{
                    birler = araDeger % 10;
                    onlar = araDeger / 10;
                    cift += (birler + onlar);
                }
                
            }
        }
        
        imeiNo[14] = 10 - ((cift + tek)%10);
        
    }
    
    public boolean imeiNoKontrol(int[] imei){
        
        if(imei.length == 15)
        {
            if(imei[0] == 0)
                return false;
            
            int tek,cift,araDeger,birler,onlar;
            cift = tek = 0;

            for (int i = 0; i < 14; i++) {
                if(i % 2 == 0)
                    tek += imei[i];
                else
                {
                    araDeger = imei[i] * 2;
                    if(araDeger < 10)
                        cift += araDeger;
                    else{
                        birler = araDeger % 10;
                        onlar = araDeger / 10;
                        cift += (birler + onlar);
                    }

                }
            }
            
            boolean durum = 10 - ((cift + tek)%10) == imei[14];
            
            if(durum)
                return true;
            
            
            
        }
        return false;
    }
    
 
} 
