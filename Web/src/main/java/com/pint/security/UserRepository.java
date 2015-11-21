package com.pint.security;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pint.entity.User;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.*;

import org.springframework.stereotype.Repository;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * This method will find an User instance in the database by its email.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public User findByEmail(String email);

}