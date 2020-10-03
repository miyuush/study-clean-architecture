public class UserController {
    @Inject
    private UserAddUseCase addUseCase;

    public void createUser(String name, String roleId) {
        UserRole role = convertRole(roleId);
        UserAddInputData inputData = new UserAddInputData(name, role);
        addUseCase.handle(inputData);
    }

    private UserRole convertRole(String roleId) {
        switch (roleId) {
            case "admin": return UserRole.ADMIN;
            case "member": return UserRole.MEMBER;
            default: throw new RuntimeException();
        }
    }
}
