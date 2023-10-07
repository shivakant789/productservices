package com.scaler.productservice.inheritanceexamples.singleclass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface STMentorRepository extends JpaRepository<Mentor,Long> {

    Mentor save(Mentor mentor);

    Mentor findMentorById(Long id);
}
