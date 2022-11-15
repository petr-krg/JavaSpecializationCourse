package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;

public class Quiz {
    QuizElement[] elements;
    InInterface inputUserAnswer;
    OutInterface viewBlock;

    public Quiz(QuizElement[] quizElement, InInterface input, OutInterface output){
        elements = quizElement;
        inputUserAnswer = input;
        viewBlock = output;
    }

    private boolean askUser(int lengthAnswers, int rightIndex) {
        if (inputUserAnswer.inputUserAnswer(lengthAnswers) == rightIndex) {
            return true;
        }
        return false;
    }

    public void start() {
        int correctAnswer = 0;
        int wrongAnswer = 0;

        for (int i = 0; i< elements.length; i++) {
            viewBlock.printMessage(i+1 + "] " + elements[i].question + "\n");
            //viewBlock.printMessage("Правильный ответ: " + element.rightAnswerIndex + "\n");
            for (int j = 0; j < elements[i].answers.length; j++) {
                viewBlock.printMessage(j+1 + ") " + elements[i].answers[j] + "\n");
            }
            if (askUser(elements[i].answers.length, elements[i].rightAnswerIndex)) {
               correctAnswer++;
            } else {
                wrongAnswer++;
            }
        }
        viewBlock.printMessage("\nРезультат: правильно %d, неправильно %d.\n",
                correctAnswer, wrongAnswer);
    }
}
