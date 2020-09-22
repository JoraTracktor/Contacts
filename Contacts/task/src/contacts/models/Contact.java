package contacts.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    private static final long serialVersionUID = 7L;
    private String name;
    private String telephone = "[no number]";
    private LocalDateTime dataCreation;
    private LocalDateTime lastDataEditing;

    public Contact(){
        this.dataCreation = LocalDateTime.now().withSecond(0).withNano(0);
        this.lastDataEditing = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDateTime getDataCreation() {
        return dataCreation;
    }

    public LocalDateTime getLastDataEditing() {
        return lastDataEditing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        if (checkTelephone(telephone)){
            this.telephone = telephone;
        } else {
            System.out.println("Wrong number format!");
            this.telephone = "[no data]";
        }
    }

    private boolean checkTelephone(String telephone){
        String regex = "\\+?(\\([\\da-zA-Z]+\\)|[\\da-zA-Z]+([ -]\\([\\da-zA-Z]{2,}+\\))?)([ -][\\da-zA-Z]{2,})*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telephone);
        return matcher.matches();
    }

    public void setLastDataEditing(){
        this.lastDataEditing = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public abstract void toStringDetail();

    public abstract void canModifyFields();

    public abstract void setField(String field, String value);

    public abstract String getField(String field);

    public abstract String getFullName();

}
