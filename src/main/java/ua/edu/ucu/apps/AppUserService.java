package ua.edu.ucu.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser createUser(AppUser user) {
        Optional<AppUser> existingUser = appUserRepository.findUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("A user with this email already exists.");
        }
        return appUserRepository.save(user);
    }

    public AppUser getUserByEmail(String email) {
        return appUserRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User with email " + email + " not found."));
    }
}
