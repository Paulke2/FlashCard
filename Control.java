import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
public class Control {
    static Scanner scr = new Scanner(System.in);


    static String getNextAction(){
        /**
         * this method gets users next action
         */
        System.out.println("enter \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
   String input = scr.nextLine();
   while(!(input=="n"||input=="p"||input=="s"||input=="u")){

       System.out.println("please give a valid input.");
       System.out.println("again the options are \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
       input =scr.nextLine();
   }

   return input;
    }
    static void Continue() throws IOException {
        /**this method gets input from get next action and if its n,(new card) it will continue until the question matches u,p, or s
        **/
        ArrayList<Card> deck=new ArrayList<Card>();
        Deck newDeck = new Deck(deck,0);
        String input = getNextAction();
        String question;
        String answer;

        if (input =="n"){
            boolean add=true;
            while(add==true){
                add=newDeck.AddCard();
            }
        }
        if(input=="p"){
            newDeck.PrintDeck();
        }
        if(input=="s"){
            newDeck.CreateSheet();
        }
        if(input=="u"){
            newDeck.updateCard();
        }
    }
}
