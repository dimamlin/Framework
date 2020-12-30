package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME = "dimamlin";
    public static final String USER_PHONE = "+375445730777";

    public static User withDefaultOptions(){
        return new User(USER_NAME, USER_PHONE);
    }

    public static User withEmptyUserName(){
        return new User("", USER_PHONE);
    }

    public static User withEmptyPhoneNumber(){
        return new User(USER_NAME, "");
    }

    public static User withBusinessOptions(){
        return new User(USER_NAME, "8484845", "EPAM", "29", "9000");
    }

}
