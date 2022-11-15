package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;
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

        for (int i = 0; i< elements.length; i++) {
            viewBlock.printMessage(i+1 + "] " + elements[i].question + "\n");
            for (int j = 0; j < elements[i].answers.length; j++) {
                viewBlock.printMessage(j+1 + ") " + elements[i].answers[j] + "\n");
            }
            if (elements[i].askUser()) {
               correctAnswer++;
            } else {
                wrongAnswer++;
            }
        }
        viewBlock.printMessage("\nРезультат: правильно %d, неправильно %d.\n",
                correctAnswer, wrongAnswer);
    }
}
