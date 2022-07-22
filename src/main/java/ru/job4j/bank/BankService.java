package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User finedUser = findByPassport(passport);
        if (finedUser != null) {
            List<Account> allUser = users.get(finedUser);
            if (!allUser.contains(account)) {
                allUser.add(account);
            }
        }
    }

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
