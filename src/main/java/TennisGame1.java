import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String namePlayer1;
    private String namePlayer2;

    private static Map<Integer, String> SCORE_CODE = new HashMap<Integer, String>();
    static {
        SCORE_CODE.put(0, "Love");
        SCORE_CODE.put(1, "Fifteen");
        SCORE_CODE.put(2, "Thirty");
        SCORE_CODE.put(3, "Forty");
    }

    public TennisGame1(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void wonPoint(String playerName) {
        if (playerName == namePlayer1)
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";

        if (scoresAreEqual(scorePlayer1, scorePlayer2)) {
            if( scorePlayer1 < 3)
                score = SCORE_CODE.get(scorePlayer1) + "-All";
            else
                score = "Deuce";
        }
        else if (atLeastOneScoreGreaterThanThree(scorePlayer1, scorePlayer2)) {
            int minusResult = scorePlayer1 - scorePlayer2;
            if (minusResult==1) score ="Advantage " + namePlayer1;
            else if (minusResult ==-1) score ="Advantage " + namePlayer2;
            else if (minusResult>=2) score = "Win for " + namePlayer1;
            else score ="Win for " + namePlayer2;
        }else {
            for (int i = 1; i < 3; i++) {
                score = SCORE_CODE.get(scorePlayer1) + "-" + SCORE_CODE.get(scorePlayer2) ;
            }
        }
        return score;
    }

    private boolean scoresAreEqual(int score1, int score2) {
        return (score1 == score2);
    }

    private boolean atLeastOneScoreGreaterThanThree(int score1, int score2) {
        return (score1 > 3 || score2 > 3);
    }
}