import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck {

    static Scanner scr = new Scanner(System.in);
    ArrayList<Card> deck = new ArrayList<>();
    public int cardNum = 1;

    public Deck(ArrayList<Card> deck, int cardNum){
        this.cardNum=cardNum;
        this.deck=deck;
    }

    public boolean AddCard() {
        /**
         * This method takes a list of cards and creates a new card. a boolean is returned(true if card has been added and false if user wants to stop adding cards
         */
        System.out.println("type what question you want on the card then press \"enter\". if you wish to stop adding cards, make the question\"s\".");
        String question = scr.nextLine();
        if(question.equals("s")){
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
        int temp = 1;
        while (temp <= this.cardNum) {
            Card currCard = this.deck.get(temp - 1);
            System.out.println("---------------------------------------------");
            System.out.println("Card number "+temp);
            System.out.println("question: ");
            System.out.println(currCard.getQuestion());
            System.out.println("||||||||||||||||||||||||||||||||||");
            System.out.println("answer: ");
            System.out.println(currCard.getAnswer());
            System.out.println("---------------------------------------------");
            temp++;
        }
    }

    public void CreateSheet() throws IOException {
        /**
         * this method creates a .txt file out of the current cards
         */
        System.out.println("creating a study guide. What should the file name be?");
        String fileName = scr.nextLine();
        fileName = fileName + ".txt";
        System.out.println("what class is this for/what test?(this will be printed at the head of your file.");
        String headerName = scr.nextLine();
        File studyGuide = new File(fileName);
        System.out.println("path:" + studyGuide.getAbsolutePath());
        //now writing to file.
        // FileWriter cardAdder = new FileWriter(studyGuide);

        int temp = this.deck.size();
        FileWriter Sheet = new FileWriter(fileName);
        int count =0;
        for (int i = 0; i < headerName.length(); i++){
            Sheet.write(headerName.charAt(i));

        }

        while (count<temp) {

            Card currCard = this.deck.get(count);
            count++;

            String a ="A) ";
            String q ="Q" +count+") ";
            q=q+ currCard.getQuestion();
            a =a+ currCard.getAnswer();
            Sheet.write('\n');
            Sheet.write('\n');

            for (int i = 0; i < q.length(); i++){
                Sheet.write(q.charAt(i));

            }
            Sheet.write('\n');

            for (int i = 0; i < a.length(); i++){
                Sheet.write(a.charAt(i));

            }

        }
        Sheet.close();
    }

    public void readFile() throws IOException {
        /**
         * this method will read a file with the format of Q) gets card 1 Q '\n' A)gets card 1 A '\n' '\n' creates new card
         */
        System.out.println("Enter the name of the .txt file");
        String fileName = scr.nextLine();
        fileName=fileName +".txt";

        File oldFile=new File(fileName);

        //until a good file is entered
        while(!(oldFile.exists()!=false)){
            System.out.println("no file found");
            System.out.println("Enter the name of the .txt file");
            fileName = scr.nextLine();
            fileName=fileName +".txt";

            oldFile=new File(fileName);
        }
        Scanner fileScan=new Scanner(oldFile);

        System.out.println("got past while ");
        int count=1;

        String Question="";

        while(fileScan.hasNextLine()){

            if(fileScan.next().charAt(0)=='Q'){
                fileScan.skip(" ");
                Question=fileScan.nextLine();

            }
            if(fileScan.next().charAt(0)=='A'){
                fileScan.skip(" ");
                String Answer=fileScan.nextLine();
                //now create a new card
                ;
                Card Creating=new Card(Question,Answer,count);

                this.deck.add(Creating);
                count++;
                this.cardNum++;
            }


        }


    }

    public void updateCard() {
        /**
         * this methods finds a card and updates it
         */
        Deck OurDeck= new Deck(this.deck,this.deck.size());
        String update = "";
        String CardName = "";
        int cardIndex = 0;
        while (CardName.equals("")) {
            System.out.println("please type out the question or card number of the card you wish to modify.");
            update = scr.nextLine();
            int deckSize = this.deck.size();

            if (update.charAt(0) > '0' || update.charAt(0) < '9') {
                String SNum = "" + update.charAt(0);
                //now we need to loop until condition for ints is false.
                int i = 1;
                while ( i <update.length()) {
                    SNum = SNum + update.charAt(i);
                    i++;
                }
                cardIndex = Integer.parseInt(SNum);
                System.out.println("your card number is " + cardIndex);
                CardName=deck.get(cardIndex-1).getQuestion();
                //if first char is not an int, they are not giving a card num
            } else {
                for (int i = 0; i < deckSize; i++) {
                    if (update == this.deck.get(i).getQuestion()) {
                        CardName = update;
                        cardIndex = this.deck.get(i).getCardNum();
                        break;
                    }
                }


            }
        }
        String newA= "";
        String newQ="";
        String input = "";
        while (!(input.equals("a") || input.equals("q"))) {
            System.out.println("enter \"q\" to modify the question and \"a\"to modify the answer");
            input = scr.next();
        }
        String oldQuestion = this.deck.get(cardIndex-1).getQuestion();
        String oldAnswer = this.deck.get(cardIndex-1).getAnswer();
        Scanner NewScr = new Scanner(System.in);
        if (input.equals("q")) {
            System.out.println("what do you wish the question to to changed to?");

            newQ = NewScr.nextLine();
            this.deck.get(cardIndex-1).setQuestion(newQ);
            System.out.println("changed card number " + cardIndex + " question from " + oldQuestion + " to " + newQ);
            OurDeck.PrintDeck();
        } else {
            System.out.println("what do you wish the answer to to changed to?");

            newA = NewScr.nextLine();
            this.deck.get(cardIndex-1).setAnswer(newA);
            System.out.println("changed card number " + cardIndex + " answer from " + oldAnswer + " to " + newA);
            OurDeck.PrintDeck();
        }

    }
    public void play(){
        ArrayList<Card> Temp = this.deck;
        boolean[] cardsUsed = new boolean[cardNum];
        int cardCount=0;

        while(cardNum>0){
            Random NumFinder = new Random();
            int currCard=NumFinder.nextInt(cardNum);
            System.out.println(Temp.get(currCard).getQuestion());
            System.out.println("Type out the answer ");
            String userA=scr.nextLine();

            if(userA.equals(Temp.get(currCard).getAnswer())){
                Temp.remove(currCard);
                cardNum--;
                System.out.println("correct");
            }else{
                System.out.println("wrong. correct answer is: "+Temp.get(currCard).getAnswer());
            }
        }


    }
}


