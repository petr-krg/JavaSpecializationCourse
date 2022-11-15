package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.OutInterface;

public class Quiz {
    private final QuizElement[] elements;
    private final OutInterface viewBlock;

    public Quiz(QuizElement[] quizElement, OutInterface output){
        this.elements = quizElement;
        this.viewBlock = output;
    }

    public void start() {
        int correctAnswer = 0;
        int wrongAnswer = 0;

        for (QuizElement element : elements) {
            if (element.askUser()) {
                correctAnswer++;
            } else {
                wrongAnswer++;
            }
        }
        viewBlock.printMessage("\nРезультат: правильно %d, неправильно %d.\n",
                correctAnswer, wrongAnswer);
    }
}
