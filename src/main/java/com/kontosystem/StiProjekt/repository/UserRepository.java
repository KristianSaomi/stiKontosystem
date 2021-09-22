package com.kontosystem.StiProjekt.repository;

import com.kontosystem.StiProjekt.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long >  {

 // CRUD förfrågningar ingår i denna Jpa repos, bl.a andra förfrågningar klicka och titta
    User findByName(String name);
}
