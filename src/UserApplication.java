import java.util.Optional;

public class UserApplication {
    private static Dao<User> userDao;

    public static void main(String[] args) {
        userDao = new UserDao();
        User user1 = getUser(0);
        userDao.getAll().forEach(user -> System.out.println(user.getName()));
        System.out.println("-------------------");

        userDao.update(user1, new String[]{"Jake", "jake@domain.com"});
        userDao.getAll().forEach(user -> System.out.println(user.getName()));
        System.out.println("---------------------------");

        User user2 = getUser(1);
        userDao.delete(user2);
        userDao.add(new User("Julie", "julie@domain.com"));

        userDao.getAll().forEach(user -> System.out.println(user.getName()));
    }


    private static User getUser(long id){
        Optional<User> user = userDao.get(id);

        return user.orElseGet(() -> new User("non-existing user", "no-email"));
    }
}
