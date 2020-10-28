package org.assignmentTracker.repository.user;

import org.assignmentTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Integer> {


}
