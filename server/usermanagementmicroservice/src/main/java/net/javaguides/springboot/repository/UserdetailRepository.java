package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Userdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

@Repository
public interface UserdetailRepository extends JpaRepository<Userdetail, String>{
}


