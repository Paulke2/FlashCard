import java.util.Scanner;
import java.util.ArrayList;
public class CreateDeck{
    static Scanner scr = new Scanner(System.in);
    ArrayList<Card> deck = new ArrayList<>();
    public static int cardNum=1;



    public static void AddCard(ArrayList<Card> deck){
        System.out.println("type what question you want on the card then press \"enter\".");
        String question=scr.nextLine();
        System.out.println("type the answer to that question.");
        String answer=scr.nextLine();
        Card newCard= new Card(question,answer,cardNum);
        deck.add(newCard);
    }
}
