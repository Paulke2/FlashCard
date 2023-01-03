public class FlashCards extends Card{

public static int cardNumber=1;


public static void createCard(String q, String a){
    /**this method creates a card then calls a method to add it to the stack where we hash each card
     *
     */
    Card newCard=new Card(q,a,cardNumber);
    cardNumber++;
    }

}
