
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
        ScoreFormatter scoreFormatter = new ScoreFormatter(player1, player2);
        return scoreFormatter.format();
    }
}