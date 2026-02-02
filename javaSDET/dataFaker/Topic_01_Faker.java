package dataFaker;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_01_Faker {
    public static void main(String[] args) {
        Faker fakerUS = new Faker();
        System.out.println(fakerUS.address().city());
        System.out.println(fakerUS.internet().domainName());
        System.out.println(fakerUS.internet().emailAddress());
        System.out.println(fakerUS.internet().password());
        System.out.println(fakerUS.internet().password(false));


        Faker fakeVN = new Faker(new Locale("vi"));
        System.out.println(fakeVN.address().lastName());
        System.out.println(fakeVN.address().firstName());



    }
}
