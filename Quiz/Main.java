package Quiz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Question[] questions = {
                new MultipleChoice("What is the capital of Canada?", "Ottawa", "Toronto", "Vancouver", "Montreal",
                        "Ottawa"),
                new MultipleChoice("What is the highest mountain in the world?", "Mount Everest", "K2", "Kangchenjunga",
                        "Lhotse", "Mount Everest"),
                new TrueFalse("The Great Wall of China is visible from space.", "False")
        };

        Quiz quiz = new Quiz(questions);

        Scanner scanner = new Scanner(System.in);
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1));
            questions[i].printQuestion();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            System.out.println();
            // Map the answer letter to the correct answer
            switch (answer) {
                case "a":
                    answers[i] = questions[i].getChoices()[0];
                    break;
                case "b":
                    answers[i] = questions[i].getChoices()[1];
                    break;
                case "c":
                    answers[i] = questions[i].getChoices()[2];
                    break;
                case "d":
                    answers[i] = questions[i].getChoices()[3];
                    break;
                default:
                    answers[i] = answer;
                    break;
            }
        }

        quiz.enterResults(answers);
        quiz.checkResults();

        quiz.displayResults();

    }

}
