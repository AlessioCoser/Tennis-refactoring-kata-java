
public class ScoreFormatter {
    private final Player player1;
    private final Player player2;

    private static String[] SCORE_CODES = {"Love", "Fifteen", "Thirty", "Forty"};

    public ScoreFormatter(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String format() {
        if (scoresAreEqual())
            return drawString();

        if (isPlayOff())
            return winningString();

        return scoreString();
    }

    private String scoreString() {
        return SCORE_CODES[player1.getScore()] + "-" + SCORE_CODES[player2.getScore()];
    }

    private String drawString() {
        if(scoreGreaterThanTwo())
            return "Deuce";
        return SCORE_CODES[player1.getScore()] + "-All";
    }

    private String winningString() {
        if (scoreDifference() >= 2)
            return "Win for " + getWinningPlayer().getName();

        return "Advantage " + getWinningPlayer().getName();
    }

    private Player getWinningPlayer() {
        if (player1.getScore() > player2.getScore())
            return player1;

        return player2;
    }

    private int scoreDifference(){
        return Math.abs(player1.getScore() - player2.getScore());
    }

    private boolean scoresAreEqual() {
        return (player1.getScore() == player2.getScore());
    }

    private boolean scoreGreaterThanTwo() {
        return (player1.getScore() >= 3);
    }

    private boolean isPlayOff() {
        return (player1.getScore() > 3 || player2.getScore() > 3);
    }
}
