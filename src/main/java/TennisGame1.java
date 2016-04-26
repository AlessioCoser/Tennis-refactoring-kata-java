import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {
    private Player player1;
    private Player player2;

    private static Map<Integer, String> SCORE_CODE = new HashMap<Integer, String>();
    static {
        SCORE_CODE.put(0, "Love");
        SCORE_CODE.put(1, "Fifteen");
        SCORE_CODE.put(2, "Thirty");
        SCORE_CODE.put(3, "Forty");
    }

    public TennisGame1(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.addScore();
        else
            player2.addScore();
    }

    public String getScore() {
        String score = "";

        if (scoresAreEqual(player1.getScore(), player2.getScore())) {
            if( player1.getScore() < 3)
                score = SCORE_CODE.get(player1.getScore()) + "-All";
            else
                score = "Deuce";
        }
        else if (atLeastOneScoreGreaterThanThree(player1.getScore(), player2.getScore())) {
            int minusResult = player1.getScore() - player2.getScore();
            if (minusResult==1) score ="Advantage " + player1.getName();
            else if (minusResult ==-1) score ="Advantage " + player2.getName();
            else if (minusResult>=2) score = "Win for " + player1.getName();
            else score ="Win for " + player2.getName();
        }else {
            for (int i = 1; i < 3; i++) {
                score = SCORE_CODE.get(player1.getScore()) + "-" + SCORE_CODE.get(player2.getScore()) ;
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