import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
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
    public static void PrintDeck(ArrayList<Card> deck){
        int temp=cardNum;
        while(temp-1>0) {
            Card currCard= deck.get(temp - 1);
            System.out.println("---------------------------------------------");
            System.out.println("question: ");
            System.out.println(currCard.getQuestion());
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("answer: ");
            System.out.println(currCard.getAnswer());
            System.out.println("---------------------------------------------");
            temp--;
        }
    }
    public static void CreateSheet(ArrayList<Card> deck) throws IOException {
        System.out.println("creating a study guide. What should the file name be?");
        String fileName = scr.nextLine();
        fileName = fileName + ".txt";
        File studyGuide = new File(fileName);
        //now writing to file.
        FileWriter cardAdder = new FileWriter(fileName);

        int temp = cardNum;
        while (temp - 1 > 0) {
            Card currCard = deck.get(temp - 1);
        cardAdder.write(temp+(")")+"\n");
            cardAdder.write("Q. "+currCard.getQuestion());
            cardAdder.write("A. "+currCard.getAnswer());
        temp--;
        }
    }

}
