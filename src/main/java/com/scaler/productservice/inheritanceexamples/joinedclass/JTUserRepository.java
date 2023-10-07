package com.scaler.productservice.inheritanceexamples.joinedclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTUserRepository extends JpaRepository<User,Long> {
    User save(User user);

    User findUsersById(Long id);
}
