package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String company;
    private String password;

    public static UserInfo getUserData() {
        return new UserInfo();
    }


}
