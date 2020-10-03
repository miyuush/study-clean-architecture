public interface UserRepository {
    public void save(User user);
    public void remove(User user);
    public List<user> findAll();
    public Optional<User> find(UserId id);
}
