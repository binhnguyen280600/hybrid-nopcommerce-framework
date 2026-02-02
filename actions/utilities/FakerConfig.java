package utilities;

import com.github.javafaker.Faker;

public class FakerConfig {
    private Faker faker;

    public FakerConfig() {
        faker = new Faker();
    }

    public static FakerConfig getFaker() {
        return new FakerConfig();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getPassword() {
        return faker.internet().password(10, 20);
    }
}
