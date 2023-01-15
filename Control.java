import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    static Scanner scr = new Scanner(System.in);

    public Control(){

    }
    public String getNextAction(){
        /**
         * this method gets users next action.
         */
        System.out.println("enter \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
        String input = scr.next();
        while(!(input.equals("n")||input.equals("p")||input.equals("s")||input.equals("u"))){


            System.out.println("please give a valid input. you said "+input);
            System.out.println("again the options are \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
            input =scr.nextLine();

            System.out.println("test "+input);

        }
        System.out.println(input);
        return input;
    }
    public void Continue() throws IOException {
        /**this method gets input from get next action and if its n,(new card) it will continue until the question matches u,p, or s
         **/
        ArrayList<Card> deck=new ArrayList<Card>();
        Deck newDeck = new Deck(deck,0);
        String input = getNextAction();
        String question;
        String answer;

        if (input.equals("n")){
            boolean add=true;
            while(add==true){
                add=newDeck.AddCard();
                newDeck.cardNum++;
                newDeck.PrintDeck();
                System.out.println("should print cards");
            }
        }
        if(input.equals("p")){
            newDeck.PrintDeck();
        }
        if(input.equals("s")){
            newDeck.CreateSheet();
        }
        if(input.equals("u")){
            newDeck.updateCard();
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Starting");
        Control controller = new Control();
        controller.Continue();


    }
}
