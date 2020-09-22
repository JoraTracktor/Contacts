package contacts.enums;

public enum Action {
    ADD,
    DELETE,
    EDIT,
    COUNT,
    LIST,
    SEARCH,
    INVALID,
    EXIT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
