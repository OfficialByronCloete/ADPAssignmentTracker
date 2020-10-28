package org.assignmentTracker.repository.note;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 30 August 2020
 * INoteRepository interface
 */

import org.assignmentTracker.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface INoteRepository extends JpaRepository<Note, Integer> {

   // Set<Note> getAll();

}