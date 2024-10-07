package org.example.perviyrazvsegdabolno.Repository;

import org.example.perviyrazvsegdabolno.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
