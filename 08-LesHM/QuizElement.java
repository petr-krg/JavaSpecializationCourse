package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;

public class QuizElement {

    protected final InInterface inputUserAnswer;
    protected final String question;
    protected final String[] answers;
    protected final int rightAnswerIndex;

    public QuizElement(String qValue, String[] aValue, int rValue, InInterface input) {
        this.question = qValue;
        this.answers  = aValue;
        this.rightAnswerIndex = rValue;
        this.inputUserAnswer = input;
    }
    public boolean askUser() {
        return this.inputUserAnswer.inputUserAnswer(this.answers.length) == this.rightAnswerIndex;
    }
}
