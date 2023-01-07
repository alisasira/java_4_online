package hw.unit1.level2;

public class Student {
    private String name;
    private String email;
    private String git;
    private String tg;
    private Object smth;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGit() {
        return git;
    }

    public String getTg() {
        return tg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
