public class EBeanUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        UserId id = user.getId();
        models.User userData = Optional
                .ofNullable(models.User.find.byId(id.getValue()))
                .orElseGet(() -> createNew(id, user.getRole()));

        userData.setName(user.getName().getValue());

        models.User.db().save(userData);
    }
}
