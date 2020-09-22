package contacts.enums;

public enum Record {
    PERSON,
    ORGANIZATION,
    UNKNOWN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
