package com.hello.boot.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User,Long> {


    public User findByEmail(String email);


}
