package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;

public class QuizElement {

    private final InInterface inputUserAnswer;
    private final OutInterface viewBlock;
    private final String question;
    private final String[] answers;
    private final int rightAnswerIndex;

    public QuizElement(String qValue, String[] aValue, int rValue, InInterface input, OutInterface output) {
        this.question = qValue;
        this.answers  = aValue;
        this.rightAnswerIndex = rValue;
        this.inputUserAnswer = input;
        this.viewBlock = output;
    }
    public boolean askUser() {
        viewBlock.printMessage(this.question + "\n");
        for (int i = 0; i < this.answers.length; i++) {
            viewBlock.printMessage(i+1 + ") " + this.answers[i] + "\n");
        }
        return this.inputUserAnswer.inputUserAnswer(this.answers.length) == this.rightAnswerIndex;
    }
}
