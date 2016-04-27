
public class ScoreFormatter {
    private final Player player1;
    private final Player player2;

    private static String[] SCORE_CODES = {"Love", "Fifteen", "Thirty", "Forty"};

    public ScoreFormatter(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String format() {
        if (isDrawAndPlayOff())
            return "Deuce";

        if (isDraw())
            return draw();

        if (isWinning())
            return winning();

        if (isAdvantage())
            return advantage();

        return normal();
    }

    private String normal() {
        return SCORE_CODES[player1.getScore()] + "-" + SCORE_CODES[player2.getScore()];
    }

    private String draw() {
        return SCORE_CODES[player1.getScore()] + "-All";
    }

    private String winning() {
        return "Win for " + getWinningPlayerName();
    }

    private String advantage() {
        return "Advantage " + getWinningPlayerName();
    }

    private String getWinningPlayerName() {
        if (player1.getScore() > player2.getScore())
            return player1.getName();

        return player2.getName();
    }

    private boolean isDrawAndPlayOff() {
        return isDraw() && (player1.getScore() > 2);
    }

    private boolean isDraw() {
        return (player1.getScore() == player2.getScore());
    }

    private boolean isWinning() {
        return isAdvantage() && (difference() >= 2);
    }

    private boolean isAdvantage() {
        return (player1.getScore() > 3 || player2.getScore() > 3);
    }

    private int difference(){
        return Math.abs(player1.getScore() - player2.getScore());
    }
}
