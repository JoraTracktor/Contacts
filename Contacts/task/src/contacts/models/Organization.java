package contacts.models;

import java.io.Serializable;

public class Organization extends Contact implements Serializable {

    private static final long serialVersionUID = 7L;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }

    @Override
    public void toStringDetail() {
        String info = String.format("Organization name: %s\n" +
                "Address: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s",
                this.getName(), this.address, this.getTelephone(), this.getDataCreation(), this.getLastDataEditing());
        System.out.println(info);
    }

    @Override
    public void canModifyFields() {
        System.out.print("Select a field (name, address, number): ");
    }

    @Override
    public void setField(String field, String value) {
        switch(field){
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setTelephone(value);
                break;
            default:
                System.out.println("Unknown field!");
                break;
        }
        setLastDataEditing();
    }

    @Override
    public String getField(String field) {
        return null;
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", getName(), getTelephone());
    }
}
