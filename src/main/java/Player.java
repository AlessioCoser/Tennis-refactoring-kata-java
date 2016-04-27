
public class Player {
    private int score = 0;
    private String name;

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
}
