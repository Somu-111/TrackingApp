package com.test.tracking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.tracking.model.Signup;

public interface SignupRepository extends MongoRepository<Signup, String> {

	Optional<Signup> findAllByEmail(String email);
}
