package com.scaler.productservice.inheritanceexamples.singleclass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface STUserRepository extends JpaRepository<User,Long> {
    User save(User user);

    User findUsersById(Long id);
}
