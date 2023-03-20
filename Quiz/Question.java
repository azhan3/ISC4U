package Quiz;

public class Question {
    private String question;
    private String[] choices;
    private String correctAnswer;

    public Question(String question, String[] choices, String correctAnswer) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public boolean isCorrect(String answer) {
        return answer.equals(correctAnswer);
    }

    public void printQuestion() {
        System.out.println(this.question);
        char letter = 'a';
        for (String choice : this.choices) {
            System.out.println(letter++ + ". " + choice);
        }
        System.out.println();
    }
    
}
