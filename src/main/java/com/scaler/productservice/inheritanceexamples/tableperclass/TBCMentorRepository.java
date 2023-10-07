package com.scaler.productservice.inheritanceexamples.tableperclass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TBCMentorRepository extends JpaRepository<Mentor,Long> {

    Mentor save(Mentor mentor);

    Mentor findMentorById(Long id);
}
