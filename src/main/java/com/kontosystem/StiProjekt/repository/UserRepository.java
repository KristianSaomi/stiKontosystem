package com.kontosystem.StiProjekt.repository;

import com.kontosystem.StiProjekt.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long >  {

    // @Query("SELECT s FROM User s WHERE s.id=?1")
        // Optional<User> findUserById(Integer id);
 // CRUD förfrågningar ingår i denna Jpa repos, bl.a andra förfrågningar klicka och titta
    User findByName(String name);
}
