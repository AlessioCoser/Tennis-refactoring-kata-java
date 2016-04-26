import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    private static Map<Integer, String> SCORE_CODE = new HashMap<Integer, String>();
    static {
        SCORE_CODE.put(0, "Love");
        SCORE_CODE.put(1, "Fifteen");
        SCORE_CODE.put(2, "Thirty");
        SCORE_CODE.put(3, "Forty");
    }

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";

        if (m_score1==m_score2)
        {
            if( m_score1 < 3)
                score = SCORE_CODE.get(m_score1) + "-All";
            else
                score = "Deuce";
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                score = SCORE_CODE.get(m_score1) + "-" + SCORE_CODE.get(m_score2) ;
            }
        }
        return score;
    }
}