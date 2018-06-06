public enum LandType {
    CITY,
    RURAL;

    @Override
    public String toString() {
        if(this == CITY) {
            return "CITY";
        } else {
            return "RURAL";
        }
    }
}
