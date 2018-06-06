import java.util.LinkedList;
import java.util.List;

public class Vassal extends Lord {

    private Lord senior;
    private int warriors;

    public Vassal(Lord vassalee, Lord vassaler, List<Land> lands, int warriors) {
        super(vassalee.getVassals(), lands, vassalee.name);
        this.senior = vassaler;
        this.warriors = warriors;
    }

    public Lord getSenior() {
        return senior;
    }

    public int getWarriors() {
        return warriors;
    }

    public int callToArms() {
        int army = 0;
        for (Vassal vassal: this.getVassals()) {
            army += vassal.callToArms();
        }
        return army + this.getWarriors();
    }
}
