package user;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public User createUser(String email, String password, String checkPassword, String nickname, String phoneNumber){
        return userService.createUser(email, password, checkPassword, nickname, phoneNumber);
    }

    public User searchUserByEmail(String email){
        User user = userService.searchUserByEmail(email);

        if(user == null){
            throw new RuntimeException("Email 정보 없음");
        }
        return user;
    }
    public User searchUserByNickname(String nickname){
        return userService.searchUserByNickname(nickname);
    }
    public User searchUserByPhoneNumber(String phoneNumber){
        return userService.searchUserByPhoneNumber(phoneNumber);
    }

    public User deleteUserByEmail(String email){
        return userService.deleteUser((searchUserByEmail(email)));
    }
    public User deleteUserByNickname(String nickname){
        return userService.deleteUser((searchUserByEmail(nickname)));
    }
    public User deleteUserByPhoneNumber(String phoneNumber){
        return userService.deleteUser((searchUserByEmail(phoneNumber)));
    }

    List<User> getUsers(){
        return userService.getUsers();
    }
}
