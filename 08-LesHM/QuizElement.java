package krg.petr.otusjava;

public class QuizElement {
    String question;
    String[] answers;
    int rightAnswerIndex;

    public QuizElement(String qValue, String[] aValue, int rValue) {
        question = qValue;
        answers  = aValue;
        rightAnswerIndex = rValue;
    }
}
