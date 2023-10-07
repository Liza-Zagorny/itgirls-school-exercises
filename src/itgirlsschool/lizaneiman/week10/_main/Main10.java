package _main;

import model.Account;
import model.WrongLoginException;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Account account = new Account();
        try {
            System.out.println("Введите ваш логин:");
            Scanner scanner = new Scanner(System.in);
            account.setLogin(scanner.next());
        } catch (WrongLoginException e) {
            System.out.println("Ошибка: Логин не присвоен аккаунту. Значение логина null или длина меньше 5 или больше 20 символов.");
        } finally {
            System.out.println("Текущий логин в аккаунте:" + account.getLogin());
        }
    }
}
