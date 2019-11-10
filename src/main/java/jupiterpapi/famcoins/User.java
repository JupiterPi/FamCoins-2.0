package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

public class User {
    @Id private String id;
    private String firstName;
    private String lastName;
    private String password;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public boolean proofPassword(String password) {
        return (this.password.equals(password));
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
