@Transactional
public class UserAddInteractor implements UserAddUseCase {
    @Inject
    private UserRepository userRepository;
    @Inject
    private UserAddPresenter userAddPresenter;

    @Override
    public void handle(UserAddInputData, inputData) {
        String uuid = UUID.randomUUID().toString();

        User user = new User(
                new UserId(uuid),
                new UserName(inputData.getUserName()),
                inputData.getRole()
        );

        userRepository.save(user);

        UserAddOutputData outputData = new UserAddOutputData(uuid);
        userAddPresenter.output(outputData);
    }
}
