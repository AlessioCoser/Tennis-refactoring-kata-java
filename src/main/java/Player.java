import java.util.HashMap;
import java.util.Map;

public class Player {
    private int score = 0;
    private String name;

    private static Map<Integer, String> SCORE_CODES = new HashMap<Integer, String>();
    static {
        SCORE_CODES.put(0, "Love");
        SCORE_CODES.put(1, "Fifteen");
        SCORE_CODES.put(2, "Thirty");
        SCORE_CODES.put(3, "Forty");
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addScore() {
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public String getScoreCode() {
        return SCORE_CODES.get(score);
    }
}
