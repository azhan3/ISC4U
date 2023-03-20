package Quiz;
public class TrueFalse extends Question {
    public TrueFalse(String question, String correctAnswer) {
        super(question, new String[]{"True", "False"}, correctAnswer);
    }
}
