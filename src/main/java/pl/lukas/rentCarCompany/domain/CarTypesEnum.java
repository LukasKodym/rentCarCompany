package pl.lukas.rentCarCompany.domain;

public enum CarTypesEnum {

    // each enum should have representation as String

    SEDAN("sedan"),
    COMBI("combi"),
    CABRIO("cabrio"),
    HATCHBACK("hatchback");

    private final String value;

    CarTypesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
