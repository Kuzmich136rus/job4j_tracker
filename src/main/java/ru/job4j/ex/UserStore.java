package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User fined = null;
        for (int index = 0; index < users.length; index++) {
            if (login.equals(users[index].getUsername())) {
                fined = users[index];
                break;
            }
        }
        if (fined == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return fined;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 3) {
            return true;
        }
            throw new UserInvalidException("Пользователь не валидный");
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
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}