import java.util.Scanner;
public class Control {
    static Scanner scr = new Scanner(System.in);


    static String getNextAction(){
        System.out.println("enter \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
   String input = scr.nextLine();
   while(!(input=="n"||input=="p"||input=="s"||input=="u")){

       System.out.println("please give a valid input.");
       System.out.println("again the options are \"n\" to make a new card, \"u\" to update an existing card, \"p\" to print the current list of cards, and \"s\" to create a study sheet from the current cards.");
       input =scr.nextLine();
   }

   return input;
    }
}
