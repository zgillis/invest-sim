package com.zgillis.investsim.repositories;

import com.zgillis.investsim.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByUsernameAndPassword(String username, String password);
    public UserAccount findByUsername(String username);

}
