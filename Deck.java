import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
public class Deck {

    static Scanner scr = new Scanner(System.in);
    ArrayList<Card> deck = new ArrayList<>();
    public int cardNum = 1;

    public Deck(ArrayList<Card> deck,int cardNum){
        this.cardNum=cardNum;
        this.deck=deck;
    }

    public boolean AddCard() {
        /**
         * This method takes a list of cards and creates a new card. a boolean is returned(true if card has been added and false if user wants to stop adding cards
         */
        System.out.println("type what question you want on the card then press \"enter\". if you wish to stop adding cards, make the question\"s\".");
        String question = scr.nextLine();
        if(question=="s"){
            return false;
        }
        System.out.println("type the answer to that question.");
        String answer = scr.nextLine();
        Card newCard = new Card(question, answer, cardNum);
        this.deck.add(newCard);
        return true;
    }

    public void PrintDeck() {
        /**
         * this prints the current deck to the console
         */
        int temp = this.cardNum;
        while (temp - 1 > 0) {
            Card currCard = this.deck.get(temp - 1);
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

    public void CreateSheet() throws IOException {
        /**
         * this method creates a .txt file out of the current cards
         */
        System.out.println("creating a study guide. What should the file name be?");
        String fileName = scr.nextLine();
        fileName = fileName + ".txt";
        File studyGuide = new File(fileName);
        //now writing to file.
        FileWriter cardAdder = new FileWriter(fileName);

        int temp = this.cardNum;
        while (temp - 1 > 0) {
            Card currCard = this.deck.get(temp - 1);
            cardAdder.write(temp + (")") + "\n");
            cardAdder.write("Q. " + currCard.getQuestion());
            cardAdder.write("A. " + currCard.getAnswer());
            temp--;
        }
    }

    public void updateCard() {
        /**
         * this methods finds a card and updates it
         */
        String update = "";
        String CardName = "";
        int cardIndex = 0;
        while (CardName == "") {
            System.out.println("please type out the question on the card you wish to modify.");
            update = scr.nextLine();
            int deckSize = this.deck.size();

            //perhaps hash all cards to make update card faster
            for (int i = 0; i < deckSize; i++) {
                if (update == this.deck.get(i).getQuestion()) {
                    CardName = update;
                    cardIndex = this.deck.get(i).getCardNum();
                    break;
                }
            }

        }
        String input = "";
        while (!(input == "a" || input == "q")) {
            System.out.println("enter \"q\" to modify the question and \"a\"to modify the answer");
            input = scr.next();
        }
        String oldQuestion = this.deck.get(cardIndex).getQuestion();
        String oldAnswer = this.deck.get(cardIndex).getAnswer();
        if (input == "a") {
            System.out.println("what do you wish the question to to changed to?");

            input = scr.nextLine();
            this.deck.get(cardIndex).setQuestion(input);
            System.out.println("changed card number " + cardIndex + " question from " + oldQuestion + " to " + input);
        } else {
            System.out.println("what do you wish the answer to to changed to?");

            input = scr.nextLine();
            this.deck.get(cardIndex).setQuestion(input);
            System.out.println("changed card number " + cardIndex + " answer from " + oldAnswer + " to " + input);
        }

    }
}

