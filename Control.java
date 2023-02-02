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
        System.out.println("enter \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards,\n \"r\" to read cards from an existing text file and \"s\" to create a study sheet from the current cards.");
        String input = scr.next();
        while(!(input.equals("n")||input.equals("p")||input.equals("s")||input.equals("u")||input.equals("r"))){


            System.out.println("please give a valid input. you said "+input);
            System.out.println("again the options are \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards,\n \"r\" to read cards from an existing text file and \"s\" to create a study sheet from the current cards.");
            input =scr.nextLine();

            System.out.println("test "+input);

        }

        return input;
    }
    public void Continue() throws IOException {
        /**this method gets input from get next action and if its n,(new card) it will continue until the question matches u,p, or s
         **/
        boolean determine_End=true;
        ArrayList<Card> deck=new ArrayList<Card>();
        Deck newDeck = new Deck(deck,0);
        //String input = getNextAction();
        String question;
        String answer;
        //this loops through until users satisfied with thier set
        while(determine_End) {
            String input = getNextAction();
            if (input.equals("n")) {
                boolean add = true;
                while (add == true) {
                    add = newDeck.AddCard();
                    if(add==true) {
                        newDeck.cardNum++;
                    }
                    newDeck.PrintDeck();

                }
                //test issue of when add is false.


            }
            if(input.equals("r")){
                newDeck.readFile();
                System.out.println("Printing new Deck");
                newDeck.PrintDeck();
            }
            if (input.equals("p")) {
                newDeck.PrintDeck();
            }
            if (input.equals("s")) {
                newDeck.CreateSheet();
            }
            if (input.equals("u")) {
                newDeck.updateCard();
            }

            determine_End=End();
            if(determine_End==false){
                //break out of loop only if user says they want to stop working with curr set.
                break;
            }
        }
        newDeck.CreateSheet();

    }
    public void readFile(){
        /**
         * this method will read a file with the format of Q) gets card 1 Q '\n' A)gets card 1 A '\n' '\n' creates new card
         */


    }
    public static boolean End(){
        /**
         * this is a helper function for continue to determine if user wants to continue with curr cards or end. returns false to end and true to continue
         */
        String input ="";
        System.out.println("would you like to end the set or continue working with this set? press \"c\" to continue and \"e\" to end.");
        input = scr.next();
        while(!(input.equals("e")||input.equals("c"))){
            System.out.println("again, press \"c\" to continue and \"e\"to end.");
            input = scr.next();
        }

        if(input.equals("e")){
            return false;
        }
        return true;

    }



    public static void main(String[] args) throws IOException {
        System.out.println("Starting");
        Control controller = new Control();
        controller.Continue();
        System.out.println("-----------------------Final Deck-----------------------");


    }
}
