public class Account {
    private static int INDEX =1;

    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;

    public Account() {
        this.id = INDEX++;
    }

    public Account(String userName, String password, String fullName, String phoneNumber, String address) {
        this.id = INDEX++;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Account(int i, String s) {
    }



    public Account(String id, String userName, String password, String fullName, String phoneNumber, String address) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
