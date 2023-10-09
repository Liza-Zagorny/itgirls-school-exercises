package _main;

import exception.WrongLoginException;
import exception.WrongLoginOrPasswordException;
import exception.WrongPasswordException;
import model.Account;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Account account = new Account();
        account.setKnownLoginsAndPasswordCombinations("liza1234", "liza12345");
        account.setKnownLoginsAndPasswordCombinations("LizaNeiman", "strongPass@!");
        try {
            System.out.println("Введите ваш логин:");
            Scanner scanner1 = new Scanner(System.in);
            String login = scanner1.next();
            account.setLogin(login);
            System.out.println("Введите ваш пароль:");
            Scanner scanner2 = new Scanner(System.in);
            String password = scanner2.next();
            if (!account.checkPassword(password)) {
                throw new WrongPasswordException();
            }
            System.out.println("Ещё раз введите ваш пароль:");
            Scanner scanner3 = new Scanner(System.in);
            String passwordCheck = scanner3.next();
            account.setPassword(password, passwordCheck);
            scanner1.close();
            scanner2.close();
            scanner3.close();
            System.out.println("Проверка введенных логина и пароля в базе данных...");

            if (!account.checkLoginAndPassword(login, password)) {
                throw new WrongLoginOrPasswordException();
            } else {
                System.out.println("Логин и пароль подтвержены успешно!");
            }
        } catch (WrongLoginException e) {
            System.out.println("Ошибка: Логин не присвоен аккаунту. Значение логина null или длина меньше 5 или больше 20 символов.");
        } catch (WrongPasswordException e) {
            System.out.println("Ошбибка: Значение пароля null или длина меньше 8 или больше 20 символов.");
        } catch (WrongLoginOrPasswordException e) {
            System.out.println("Ошибка: Значение логина и пароля не соответвует базе данных!");
        } finally {
            System.out.println("Текущий логин в аккаунте:" + account.getLogin());
            System.out.println("Текущий пароль в аккаунте:" + account.getPassword());

        }
    }
}
