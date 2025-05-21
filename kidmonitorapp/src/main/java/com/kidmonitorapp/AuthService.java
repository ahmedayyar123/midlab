public class AuthService {
    private UserDataStore dataStore;

    public AuthService(UserDataStore dataStore) {
        this.dataStore = dataStore;
    }

    public boolean authenticate(String username, String password) {
        // Business logic can go here (e.g., check password complexity, logging)
        return dataStore.validateUser(username, password);
    }
}
