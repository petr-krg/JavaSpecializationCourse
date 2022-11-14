package krg.petr.otusjava;

// Третья версия викторины или тестера работа над замечаниями.

import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int MAX_QUESTIONS = 100;
        final int MAX_QUESTIONS_GAME = 10;

        String question;
        String[] optionAnswers;
        int correctAnswer;
        int randomQuestionIndex;

        QuizDataBase dbQuiz = new QuizDataBase(); // просто хранитель массива вопросов, что бы портянку длинную мою не держать на экране
        OutInterface print = new ConsoleOutput();
        InInterface  inputUserAnswer = new ConsoleInput();
        QuizElement[] qElement = new QuizElement[MAX_QUESTIONS_GAME];

        for (int i = 0; i < MAX_QUESTIONS_GAME; i++) {
            randomQuestionIndex = new Random().nextInt(MAX_QUESTIONS);
            question = dbQuiz.getQuestions(randomQuestionIndex);
            optionAnswers = dbQuiz.getAnswerOptions(randomQuestionIndex);
            correctAnswer = dbQuiz.getCorrectAnswers(randomQuestionIndex);
            qElement[i] = new QuizElement(question, optionAnswers, correctAnswer);
        }

        Quiz quiz = new Quiz(qElement, inputUserAnswer, print);
        quiz.start();
    }
}