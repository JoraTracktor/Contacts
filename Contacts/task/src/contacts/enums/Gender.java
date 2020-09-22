package contacts.enums;

public enum Gender {
    M,
    F,
    UNKNOWN;

    @Override
    public String toString() {
        return name();
    }
}
