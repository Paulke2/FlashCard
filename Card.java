public class Card {
    /** this is the card structure.
     * card num is irreavent besides when we create a study txt. file and the questions are numbered.
     * hash the question to find the answer if it is stored in the card array already
     */
    public int cardNum;
    public String question;
    public String answer;

public String getQuestion(){
    return this.question;
}
public String getAnswer(){
    return this.answer;
}
public int getCardNum(){return this.cardNum;}


    public Card(String question, String answer,int number){
    this.question =question;
    this.answer=answer;
    this.cardNum=number;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setQuestion(String question){
    this.question=question;
    }
    public void setCardNum(int cardNumber){
    this.cardNum=cardNumber;
    }
}
