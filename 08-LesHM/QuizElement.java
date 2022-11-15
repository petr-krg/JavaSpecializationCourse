package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;

public class QuizElement {

    private final InInterface inputUserAnswer;
    private final String question;
    private final String[] answers;
    private final int rightAnswerIndex;

    public QuizElement(String qValue, String[] aValue, int rValue, InInterface input) {
        this.question = qValue;
        this.answers  = aValue;
        this.rightAnswerIndex = rValue;
        this.inputUserAnswer = input;
    }

    public String getAnswers(int arrayIndex) {
        return this.answers[arrayIndex];
    }

    public String getQuestion() {
        return this.question;
    }

    public int getRightAnswerIndex() {
        return this.rightAnswerIndex;
    }

    public int getAnswersLength() {
        return this.answers.length;
    }

    public boolean askUser() {
        return this.inputUserAnswer.inputUserAnswer(this.answers.length) == this.rightAnswerIndex;
    }
}
