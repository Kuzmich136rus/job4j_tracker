package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User finedUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                finedUser = user;
            } else {
                throw new UserNotFoundException("Пользователь не найден");
            }
        }
        return finedUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 3) {
            return true;
        } else {
            throw new UserInvalidException("Пользователь не валидный");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}