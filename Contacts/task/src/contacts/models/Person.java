package contacts.models;

import contacts.enums.Gender;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Person extends Contact implements Serializable {

    private static final long serialVersionUID = 7L;
    private String surName;
    private String birthDay;
    private String gender;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        try{
            LocalDate date = LocalDate.parse(birthDay);
            this.birthDay = date.toString();
        } catch (DateTimeParseException e){
            System.out.println("Bad birth date!");
            this.birthDay = "[no data]";
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        Gender g;
        try {
            g = Gender.valueOf(gender.toUpperCase());
            this.gender = g.toString();
        } catch (IllegalArgumentException e) {
            g = Gender.UNKNOWN;
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), surName);
    }

    @Override
    public void toStringDetail() {
        String info = String.format("Name: %s\n" +
                        "Surname: %s\n" +
                        "Birth date: %s\n" +
                        "Gender: %s\n" +
                        "Number: %s\n" +
                        "Time created: %s\n" +
                        "Time last edit: %s",
                        this.getName(), this.surName,this.birthDay, this.gender, this.getTelephone(), this.getDataCreation(), this.getLastDataEditing());
        System.out.println(info);
    }

    @Override
    public void canModifyFields() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
    }

    @Override
    public void setField(String field, String value) {
        switch(field){
            case "name":
                setName(value);
                break;
            case "surname":
                setSurName(value);
                break;
            case "birth":
                setBirthDay(value);
                break;
            case "gender":
                setGender(value);
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
        return String.format("%s %s %s", getName(), getSurName(), getTelephone());
    }

}
