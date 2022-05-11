package lloretenriquez.jaume.tenda.classes;

public class Person {
    private String username;
    private String name;
    private String birthdate;

    public Person(){}

    public Person(String username, String name, String birthdate){
        this.birthdate = birthdate;
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getUsername() {
        return username;
    }
}
