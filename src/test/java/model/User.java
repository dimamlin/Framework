package model;

public class User {

    private String userName;
    private String phoneNumber;
    private String shortPhoneNumber;
    private String organization;
    private String phoneCode;
    private String time;

    public User(String userName, String phoneNumber){
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public User(String userName, String shortPhoneNumber, String organization, String phoneCode, String time){
        this.userName = userName;
        this.shortPhoneNumber = shortPhoneNumber;
        this.organization = organization;
        this.phoneCode = phoneCode;
        this.time = time;

    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getUserOrganization() { return organization; }

    public String getUserCode() {return phoneCode; }

    public String getUserShortPhoneNumber() { return shortPhoneNumber; }

    public String getUserTime() { return time; }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userName + '\'' +
                ", phone='" + phoneNumber + '\'' +
                '}';
    }
}
