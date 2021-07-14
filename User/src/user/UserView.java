package user;

import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    void askForUserAction() {
        System.out.println("=== User 기능 선택 ===");
        System.out.println("1. 회원가입 / 2. 회원삭제 / 3. 회원조회");
        String choiceNumber = scanner.nextLine();
        isAnswerNumberFromOneToThree(choiceNumber);
        if (choiceNumber.equals("1")) {
            askSignUp();
        }
        if (choiceNumber.equals("2")) {
            askUserInfoForDelete();
        }
        if (choiceNumber.equals("3")) {
            askAnswerNumberForShowUser();
        }
    }

    void isAnswerNumberFromOneToThree(String answerNumber) {
        if (Integer.parseInt(answerNumber) > 3 || Integer.parseInt(answerNumber) < 1) {
            System.out.println("다시 입력");
            askForUserAction();
        }
        return;
    }

    void askSignUp() {
        System.out.println("===회원가입===");
        System.out.println("가입할 정보를 입력해주세요.");
        System.out.println("Email : ");
        String email = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        System.out.println("Check your Password : ");
        String checkPassword = scanner.nextLine();
        System.out.println("Nickname : ");
        String nickname = scanner.nextLine();
        System.out.println("PhoneNumber : ");
        String phoneNumber = scanner.nextLine();

        try {
            userController.createUser(email, password, checkPassword, nickname, phoneNumber);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    void askUserInfoForDelete() {
        System.out.println("===회원 삭제===");
        System.out.println("1. Email로 정보 삭제 / 2. Nickname으로 정보 삭제 / 3. PhoneNumber로 정보 삭제");
        String answerNumber = scanner.nextLine();
        isAnswerNumberFromOneToThree(answerNumber);
        if (answerNumber.equals("1")) {
            askEmailForDeleteUser();
        }
        if (answerNumber.equals("2")) {
            askNicknameForDeleteUser();
        }
        if (answerNumber.equals("3")) {
            askPhoneNumberForDeleteUser();
        }
    }

    void askEmailForDeleteUser() {
        System.out.println("삭제할 Email: ");
        String email = scanner.nextLine();
        User deletedUser = isNullFromUsers(userController.deleteUserByEmail(email));
        if (deletedUser == null) {
            System.out.println("처음으로 돌아감");
        } else {
            System.out.println("Email " + deletedUser.getEmail() + "이 포함된 정보 삭제 완료");
        }
    }

    void askNicknameForDeleteUser() {
        System.out.println("삭제할 Nickname: ");
        String nickname = scanner.nextLine();
        User deletedUser = isNullFromUsers(userController.deleteUserByNickname(nickname));
        if (deletedUser == null) {
            System.out.println("처음으로 돌아감");
        } else {
            System.out.println("Nickname " + deletedUser.getEmail() + "이 포함된 정보 삭제 완료");
        }
    }

    void askPhoneNumberForDeleteUser() {
        System.out.println("삭제할 Email: ");
        String phoneNumber = scanner.nextLine();
        User deletedUser = isNullFromUsers(userController.deleteUserByPhoneNumber(phoneNumber));
        if (deletedUser == null) {
            System.out.println("처음으로 돌아감");

        } else {
            System.out.println("Nickname " + deletedUser.getEmail() + "이 포함된 정보 삭제 완료");
        }
        askForUserAction();
    }

    User isNullFromUsers(User user) {
        if (user == null) {
            System.out.println("삭제할 정보가 없습니다.");
            return null;
        }
        return user;
    }

    void askAnswerNumberForShowUser() {
        System.out.println("===회원조회===");
        System.out.println("1. 특정회원 조회 / 2. 전체회원 조회");
        String answerNumber = scanner.nextLine();
        isAnswerNumberForShowUsersQuestion(answerNumber);
        if (answerNumber.equals("1")) {
            //구현안됨
        }
        if (answerNumber.equals("2")) {
            showUsersInfo();
        }
    }

    void showUsersInfo() {
        System.out.println("===전체 회원 정보 조회===");
        List<User> shownUsers = userController.getUsers();
        if (shownUsers.isEmpty()) {
            System.out.println("회원 정보가 없습니다.");
            return;
        }
        for (User user : shownUsers) {
            System.out.println(user);
        }
    }

    void isAnswerNumberForShowUsersQuestion(String answerNumber) {
        if (Integer.parseInt(answerNumber) > 2 || Integer.parseInt(answerNumber) < 1) {
            System.out.println("다시 입력");
            askAnswerNumberForShowUser();
        }
        return;
    }

}
