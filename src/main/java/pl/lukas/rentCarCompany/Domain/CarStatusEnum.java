package pl.lukas.rentCarCompany.Domain;

public enum CarStatusEnum {

    RENTED("rented"),
    AVALIABLE("available"),
    UNAVALIABLE("unavailable");

    private final String value;

    CarStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
