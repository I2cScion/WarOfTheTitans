
package Game;

public class Unit {
    private String name;
    private String type;
    private int HP;
    private int strength;
    private int defense;
    private Bullet bulletType;
    private int numOfBullets;
    private int speedOfShooting;

    public Unit(String name, String type, int HP, int strength, int defense, Bullet bulletType, int numOfBullets, int speedOfShooting) {
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.strength = strength;
        this.defense = defense;
        this.bulletType = bulletType;
        this.numOfBullets = numOfBullets;
        this.speedOfShooting = speedOfShooting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Bullet getBulletType() {
        return bulletType;
    }

    public void setBulletType(Bullet bulletType) {
        this.bulletType = bulletType;
    }

    public int getNumOfBullets() {
        return numOfBullets;
    }

    public void setNumOfBullets(int numOfBullets) {
        this.numOfBullets = numOfBullets;
    }

    public int getSpeedOfShooting() {
        return speedOfShooting;
    }

    public void setSpeedOfShooting(int speedOfShooting) {
        this.speedOfShooting = speedOfShooting;
    }
    
    
}
