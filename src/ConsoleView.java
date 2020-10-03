public class ConsoleView {
    public void showCreatedUserId(ConsoleViewModel viewModel) {
        System.out.println("User Created");
        System.out.println("UserId: " + viewModel.getUuid());
    }
}
