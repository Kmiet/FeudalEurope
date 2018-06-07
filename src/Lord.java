import java.util.LinkedList;
import java.util.List;

public class Lord {

    private List<Vassal> vassals;
    private List<Land> lands;
    public final String name;

    public Lord(List<Vassal> vassals, List<Land> lands, String name) {
        this.vassals = vassals;
        this.lands = lands;
        this.name = name;
    }

    public List<Land> getLands() {
        return lands;
    }

    public List<Land> listTerritory() {
        List<Land> lands = new LinkedList<Land>();
        lands.addAll(this.lands);
        for (Vassal vassal: this.vassals) {
            lands.addAll(vassal.listTerritory());
        }
        return lands;
    }

    public List<Vassal> getVassals() {
        return vassals;
    }

    public int getIncome() {
        int sum = 0;
        for (Vassal vassal : this.vassals) {
            sum += vassal.getIncome();
        }
        for (Land land : this.lands) {
            sum += land.getIncome();
        }
        return sum;
    }

    public Vassal vassalize(Lord vassalee, List<Land> lands, int warriors) throws Exception {
        if (this.getVassals().size() > 7) {
            throw new Exception("Cannot have more than 7 vassals");
        } else if(vassalee instanceof Vassal) {
            throw new Exception("Vassal cannot break his vow");
        } else {
            vassalee.getLands().addAll(lands);
            Vassal retvassal = new Vassal(vassalee, this, vassalee.getLands(), warriors);
            this.vassals.add(retvassal);
            List<Land> result = new LinkedList<>();
            for (Land land: this.lands) {
                if (!lands.contains(land)) {
                    result.add(land);
                }
            }
            System.out.println(result);
            this.lands = result;
            return retvassal;
        }
    }



    @Override
    public String toString() {
        System.out.println("TUUU " + this.getLands());
        return "N: " + this.name + " - L: " + this.getLands();
    }
}
