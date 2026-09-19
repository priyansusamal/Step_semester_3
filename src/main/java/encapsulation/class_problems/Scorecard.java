package encapsulation.class_problems;

public class Scorecard {

    private boolean[] results;
    private int recordedAnswers;

    public Scorecard(int questionCount) {
        results = new boolean[questionCount];
        recordedAnswers = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers < results.length) {
            results[recordedAnswers] = correct;
            recordedAnswers++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}