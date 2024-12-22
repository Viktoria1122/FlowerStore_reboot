package ua.edu.ucu.apps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("SELECT u FROM AppUser u WHERE u.email = ?1")
    Optional<AppUser> findUserByEmail(String email);
}
