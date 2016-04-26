
public class TennisGame1 implements TennisGame {
    private Player player1;
    private Player player2;

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
        String score = scoreString();

        if (scoresAreEqual()) {
            score = drawString();
        }else if (isPlayOff()) {
            score = winningString();
        }

        return score;
    }

    private Player getWinningPlayer() {
        if (player1.getScore() > player2.getScore())
            return player1;

        return player2;
    }

    private int scoreDifference(){
        return Math.abs(player1.getScore() - player2.getScore());
    }

    private String scoreString() {
        return player1.getScoreCode() + "-" + player2.getScoreCode();
    }

    private String drawString() {
        if(scoreGreaterThanTwo())
            return "Deuce";
        return player1.getScoreCode() + "-All";
    }

    private String winningString() {
        if (scoreDifference() >= 2)
            return "Win for " + getWinningPlayer().getName();

        return "Advantage " + getWinningPlayer().getName();
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