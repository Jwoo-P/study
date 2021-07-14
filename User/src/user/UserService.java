package user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    User createUser(String email, String password, String checkPassword, String nickname, String phoneNumber) {
        if (!isEqualPasswords(password, checkPassword)) {
            throw new RuntimeException("Password가 일치하지 않습니다.");
        }
        User addedUser = new User(email, password, nickname, phoneNumber);
        users.add(addedUser);
        return addedUser;
    }

    boolean isEqualPasswords(String password, String checkPassword) {
        if (password.equals(checkPassword)) {
            return true;
        }
        return false;
    }

    User searchUserByEmail(String email) {
        for (int i = 0; i <= users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }

    User searchUserByNickname(String Nickname) {
        for (int i = 0; i <= users.size(); i++){
            if(users.get(i).getNickname().equals(Nickname)){
                return users.get(i);
            }
        }
        return null;
    }

    User searchUserByPhoneNumber(String PhoneNumber) {
        for (int i = 0; i <= users.size(); i++){
            if(users.get(i).getPhoneNumber().equals(PhoneNumber)){
                return users.get(i);
            }
        }
        return null;
    }

    User deleteUser(User deleteUser) {
        if(deleteUser == null){ //들어온 애가 null인지 check, 예외처리는 메소드 맨첨에.
            throw new RuntimeException("유저가 없음");
        }

        User deletedUser = deleteUser;
        users.remove(deleteUser);
        return deletedUser;
    }
}
