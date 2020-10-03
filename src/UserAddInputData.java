public class UserAddInputData implements InputData<UserAddInputData> {
    // final:1度しか値を代入できない変数
    private final String userName;
    private final UserRole role;

    public UserAddInputData(String userName, UserRole role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() { return userName; }
    public UserRole getRole() { return role; }
}
