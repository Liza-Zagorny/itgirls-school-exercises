package model;

import exception.WrongLoginException;
import exception.WrongLoginOrPasswordException;
import exception.WrongPasswordException;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Account {

    private String login;
    private String password;
    private final HashMap<String, String> knownLoginsAndPasswordCombinations = new HashMap<>();


    public void setLogin(String login) throws WrongLoginException {
        if (checkLogin(login)) {
            this.login = login;
        } else {
            throw new WrongLoginException();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password, String passwordConfirmation) throws WrongPasswordException {
        if (checkPassword(password, passwordConfirmation)) {
            this.password = password;
        } else {
            throw new WrongPasswordException();
        }
    }

    public String getPassword() {
        return password;
    }

    public boolean checkLogin(String login) {
        return login != null && login.length() > 5 && login.length() < 20;
    }

    public boolean checkPassword(String password, String passwordConfirmation) {
        return Objects.equals(password, passwordConfirmation) && password != null && password.length() > 8 && password.length() < 20;
    }

    public boolean checkPassword(String password) {
        return password != null && password.length() >= 8 && password.length() < 20;
    }

    public void setKnownLoginsAndPasswordCombinations(String login, String password) {
        this.knownLoginsAndPasswordCombinations.put(login, password);
    }

    public HashMap<String, String> getKnownLoginsAndPasswordCombinations() {
        return knownLoginsAndPasswordCombinations;
    }

    public boolean checkLoginAndPassword(String login, String password) throws WrongLoginOrPasswordException {
        boolean result = false;
        Optional<String> expectedPassword = Optional.ofNullable(knownLoginsAndPasswordCombinations.get(login));
        if (expectedPassword.isPresent() && expectedPassword.get().equals(password)) {
            result = true;
        }
        return result;
    }
}
