package Quiz;
public class MultipleChoice extends Question {
    public MultipleChoice(String question, String choiceA, String choiceB, String choiceC, String choiceD, String correctAnswer) {
        super(question, new String[]{choiceA, choiceB, choiceC, choiceD}, correctAnswer);
    }
}