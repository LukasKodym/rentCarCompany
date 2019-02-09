package pl.lukas.rentCarCompany.Domain;

public enum CarTypEnum {

    // each enum should have representation as String

    SEDAN("sedan"),
    COMBI("combi"),
    CABRIO("cabrio"),
    HATCHBACK("hatchback");

    private final String value;

    CarTypEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
