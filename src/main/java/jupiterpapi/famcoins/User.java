package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

public class User {
    @Id private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
