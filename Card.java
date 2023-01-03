public interface Card {
    /** this is the card structure.
     * card num is irreavent besides when we create a study txt. file and the questions are numbered.
     * hash the question to find the answer if it is stored in the card array already
     */
    public abstract int cardNum;
    public abstract string question;
    public abstract string answer;
}
