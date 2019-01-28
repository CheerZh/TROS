package ustc.zgq.entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {
    private String userId;
    private String userName;
    private String passWord;
    private String role;
    private int permission;
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}