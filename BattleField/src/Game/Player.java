
package Game;

public class Player {
    private String name;
    private Army army;
    private int score;

    public Player(String name, Army army, int score) {
        this.name = name;
        this.army = army;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
