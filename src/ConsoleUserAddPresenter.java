public class ConsoleUserAddPresenter implements UserAddPresenter {
    private ConsoleView consoleView = new ConsoleView();

    public void output(UserAddOutputData outputData) {
        String userUuid = outputData.getCreatedId();
        ConsoleViewModel viewModel = new ConsoleViewModel(userUuid);
        consoleView.showCreatedUserId(viewModel);
    }
}
