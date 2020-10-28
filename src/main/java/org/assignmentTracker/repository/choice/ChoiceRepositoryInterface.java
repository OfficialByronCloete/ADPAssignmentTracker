package org.assignmentTracker.repository.choice;

import org.assignmentTracker.entity.Choice;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Anganathi Ngodwane
 * desc: ChoiceRepositoryInterface.java
 * date 31 August 2020 SAST
 * student number: 217078907
 */
@Repository
public interface ChoiceRepositoryInterface extends JpaRepository<Choice, Integer>{
}
