import java.util.HashMap;

public class UserDataStore {
    private HashMap<String, String> userDB;

    public UserDataStore() {
        userDB = new HashMap<>();
        // Hardcoded users for demo
        userDB.put("parent1", "password123");
        userDB.put("caregiver1", "carepass");
        userDB.put("security1", "secure123");
    }

    public boolean validateUser(String username, String password) {
        return userDB.containsKey(username) && userDB.get(username).equals(password);
    }
}
