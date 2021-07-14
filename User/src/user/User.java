package user;

import java.util.Objects;

public class User {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;

    public User(String email, String password, String nickname, String phoneNumber) {
        setEmail(email);
        this.password = password;
        this.nickname = nickname;
        setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!email.contains("@")){
            throw new RuntimeException("eamil 형식이 올바르지 않습니다."); //메소드를 부르는 곳에서 try + catch
            //메소드에도 throws를 붙여야됨
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!phoneNumber.startsWith("010")){
            throw new RuntimeException("PhoneNumber 형식이 올바르지 않습니다.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(nickname, user.nickname) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nickname, phoneNumber);
    }
}
