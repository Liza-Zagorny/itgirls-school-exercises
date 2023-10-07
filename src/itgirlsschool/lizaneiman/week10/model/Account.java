package model;

public class Account {

    private String login;

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

    public boolean checkLogin(String login) {
        return login != null && login.length() > 5 && login.length() < 20;
    }

}
