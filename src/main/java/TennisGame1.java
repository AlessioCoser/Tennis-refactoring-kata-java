
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
        String score = getScoreString();

        if (scoresAreEqual()) {
            score = getDrawString();
        }else if (isPlayOff()) {
            int minusResult = player1.getScore() - player2.getScore();
            if (minusResult==1) score ="Advantage " + player1.getName();
            else if (minusResult ==-1) score ="Advantage " + player2.getName();
            else if (minusResult>=2) score = "Win for " + player1.getName();
            else score ="Win for " + player2.getName();
        }
        return score;
    }

    private String getScoreString() {
        return player1.getScoreCode() + "-" + player2.getScoreCode();
    }

    private String getDrawString() {
        if(scoreGreaterThanTwo())
            return "Deuce";
        return player1.getScoreCode() + "-All";
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