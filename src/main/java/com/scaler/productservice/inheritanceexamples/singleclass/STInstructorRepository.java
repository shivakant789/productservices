package com.scaler.productservice.inheritanceexamples.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STInstructorRepository extends JpaRepository<Instructor,Long> {

    Instructor save(Instructor instructor);
}
