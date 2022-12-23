package hw.unit4;

public class Owner {
    private String name;
    private String aptNumber;
    private String telNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches(".*\\d.*")) {
            System.out.println("Not a valid name. Please enter another one");
        } else {
            this.name = name;
        }
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
