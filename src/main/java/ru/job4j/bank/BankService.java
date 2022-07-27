package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис.
 * @author Nikita Shcherbakov
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     * в коллекции типа LinkedList.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     */
    public void addAccount(String passport, Account account) {
        User finedUser = findByPassport(passport);
        if (finedUser != null) {
            List<Account> allUser = users.get(finedUser);
            if (!allUser.contains(account)) {
                allUser.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспорту
     * @param passport содержит паспортные данные
     * @return найденного пользователя типа User или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User finedUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                finedUser = user;
                break;
            }
        }
        return finedUser;
    }

    /**
     * Метод осуществляет поиск пользователя по реквизитам
     * @param passport содержит паспортные данные и осуществляет поиск
     * пользователя через метод {@link public User findByPassport}
     * @param requisite содержит реквизиты, которые затем ищутся в списке
     * счетов пользователя
     * @return аккаунт или null, если счет по реквизитам не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User finedUser = findByPassport(passport);
        if (finedUser != null) {
           for (Account finedAccount : users.get(finedUser)) {
               if (finedAccount.getRequisite().equals(requisite)) {
                   account = finedAccount;
                   break;
               }
            }
        }
        return account;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport принимает паспортные данные пользователя со счета которого нужно перевести
     * деньги,
     * @param srcRequisite принимает реквизиты счета с которого нужно перевести деньги
     * @param destPassport ринимает паспортные данные пользователя на счет которого нужно перевести
     *деньги,
     * @param destRequisite принимает реквизиты счета на который нужно перевести деньги
     * @param amount сумма, которую необходимо перевести в формате числа с плавающей точкой
     * @return false, если счёт не найден или не хватает денег на счёте
     * srcAccount (с которого переводят)
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if ((accountSrc != null) && (accountDest != null) && (accountSrc.getBalance() >= amount)) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
