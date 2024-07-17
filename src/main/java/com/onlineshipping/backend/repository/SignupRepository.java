package com.onlineshipping.backend.repository;

import com.onlineshipping.backend.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Signup,Long> {
}
