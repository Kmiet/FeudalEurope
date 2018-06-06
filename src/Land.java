public class Land {

    private LandType type;
    public final String name;
    private int income;

    public Land(String name, int income, LandType type) {
        this.type = type;
        this.name = name;
        this.income = income;
    }

    public int getIncome() {
        return this.income;
    }

    @Override
    public String toString() {
        return "Land: " + this.name + " - Type: " + this.type;
    }
}
