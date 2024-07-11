package com.company.bpmdemo.provider;

import com.company.bpmdemo.entity.User;
import io.jmix.bpm.provider.UserProvider;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@UserProvider(value = "randomRobinUserProvider")
public class RandomRobinUserProvider {
    private static final Logger log = LoggerFactory.getLogger(RandomRobinUserProvider.class);

    private final DataManager dataManager;
    private final SystemAuthenticator systemAuthenticator;

    public RandomRobinUserProvider(DataManager dataManager, SystemAuthenticator systemAuthenticator) {
        this.dataManager = dataManager;
        this.systemAuthenticator = systemAuthenticator;
    }

    /**
     * This method returns username
     */
    public String getUser() {
        systemAuthenticator.begin("admin");
        try {
            List<User> accountants = dataManager.load(User.class)
                    .query("select u from User u where u.position = 'accountant'")
                    .list();
            int randomNumber = new Random().nextInt(accountants.size());
            String usernameToReturn = accountants.get(randomNumber).getUsername();
            log.info("Returned: " + usernameToReturn);
            return usernameToReturn;
        } finally {
            systemAuthenticator.end();
        }
    }

}
