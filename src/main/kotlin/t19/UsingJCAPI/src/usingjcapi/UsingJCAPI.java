/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t19.UsingJCAPI.src.usingjcapi;

import java.util.*;

import static t19.UsingJCAPI.src.usingjcapi.ComparatatorKt.*;

/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }

        final int sortTypes = 4;
        for(int i2 = 1; i2 <= sortTypes; i2++){
            if(i2 == 1){
                cardUsers = sortByBalance(cardUsers);
                System.out.println("Sorder by Balance: (decending)");
            } else if (i2 == 2){
                cardUsers = sortBymOwnerName(cardUsers);
                System.out.println("Sorder by Owner name: (decending)");
            } else if(i2 == 3){
                cardUsers = sortByCustom(cardUsers);
                System.out.println("Sorder by custom (owner-name): (acending)");
            } else {
                cardUsers = sortByCustom2(cardUsers);
                System.out.println("Sorder by custom2 (number): (acending)");
            }

            Iterator itr = cardUsers.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }
    
}
