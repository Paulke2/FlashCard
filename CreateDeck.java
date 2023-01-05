import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
public class CreateDeck {
    static Scanner scr = new Scanner(System.in);
    ArrayList<Card> deck = new ArrayList<>();
    public static int cardNum = 1;


    public static void AddCard(ArrayList<Card> deck) {
        System.out.println("type what question you want on the card then press \"enter\".");
        String question = scr.nextLine();
        System.out.println("type the answer to that question.");
        String answer = scr.nextLine();
        Card newCard = new Card(question, answer, cardNum);
        deck.add(newCard);
    }

    public static void PrintDeck(ArrayList<Card> deck) {
        int temp = cardNum;
        while (temp - 1 > 0) {
            Card currCard = deck.get(temp - 1);
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
            cardAdder.write(temp + (")") + "\n");
            cardAdder.write("Q. " + currCard.getQuestion());
            cardAdder.write("A. " + currCard.getAnswer());
            temp--;
        }
    }

    public static void updateCard(ArrayList<Card> deck) {
        String update = "";
        String CardName = "";
        int cardIndex = 0;
        while (CardName == "") {
            System.out.println("please type out the question on the card you wish to modify.");
            update = scr.nextLine();
            int deckSize = deck.size();

            //perhaps hash all cards to make update card faster
            for (int i = 0; i < deckSize; i++) {
                if (update == deck.get(i).getQuestion()) {
                    CardName = update;
                    cardIndex = deck.get(i).getCardNum();
                    break;
                }
            }

        }
        String input = "";
        while (!(input == "a" || input == "q")) {
            System.out.println("enter \"q\" to modify the question and \"a\"to modify the answer");
            input = scr.next();
        }
        String oldQuestion = deck.get(cardIndex).getQuestion();
        String oldAnswer = deck.get(cardIndex).getAnswer();
        if (input == "a") {
            System.out.println("what do you wish the question to to changed to?");

            input = scr.nextLine();
            deck.get(cardIndex).setQuestion(input);
            System.out.println("changed card number " + cardIndex + " question from " + oldQuestion + " to " + input);
        } else {
            System.out.println("what do you wish the answer to to changed to?");

            input = scr.nextLine();
            deck.get(cardIndex).setQuestion(input);
            System.out.println("changed card number " + cardIndex + " answer from " + oldAnswer + " to " + input);
        }

    }
}
