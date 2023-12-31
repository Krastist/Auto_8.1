package ru.netology.docker.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }
    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static AuthInfo getAuthInfoWithRandomPassword() {return new AuthInfo("petya", generateRandomPassword());}
    public static String generateRandomLogin() {
        return faker.name().username();
    }
    public static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("#####"));
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class VerificationCode {
        String code;
    }
}