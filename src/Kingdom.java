import java.util.List;

public class Kingdom {

    public Lord king;
    public String name;

    public Kingdom(String name, Lord king) {
        this.king = king;
        this.name = name;
    }

    public List<Land> getTerritory() {
        return this.king.listTerritory();
    }

    public int getIncome() {
        return this.king.getIncome();
    }

    public double declareWar(Kingdom other) {
        int ourArmy = 0;
        int enemyArmy = 0;
        for (Vassal vassal: this.king.getVassals()) {
            ourArmy += vassal.callToArms();
        }
        for (Vassal vassal: other.king.getVassals()) {
            enemyArmy += vassal.callToArms();
        }

        return ((double) ourArmy/ (double) (ourArmy + enemyArmy));
    }

    @Override
    public String toString() {
        return "Kingdom: " + this.name + " - King: " + this.king.name;
    }
}
