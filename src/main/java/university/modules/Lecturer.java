package university.modules;

/**
 * Created by Norik on 28.03.2017.
 */
public class Lecturer {
    private String firstName;
    private String lastName;

    public Lecturer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
