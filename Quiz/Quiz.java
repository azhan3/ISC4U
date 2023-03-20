package Quiz;

public class Quiz {
    private Question[] questions;
    private int totalMarks;
    private int score;
    private boolean[] results;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.totalMarks = questions.length;
        this.score = 0;
        this.results = new boolean[questions.length];
    }

    public Quiz() {
        this.totalMarks = 10;
        this.score = 0;
        this.results = new boolean[10];
    }

    public void enterResults(String[] answers) {
        for (int i = 0; i < questions.length; i++) {
            results[i] = questions[i].isCorrect(answers[i]);
        }
    }

    public void checkResults() {
        for (boolean result : results) {
            if (result) {
                score++;
            }
        }
    }

    public void displayResults() {
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Score: " + score);
        System.out.println("Percentage earned: " + String.format("%.2f", score * 100.0 / totalMarks) + "%");
    }
}

