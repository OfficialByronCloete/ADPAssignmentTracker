package org.assignmentTracker.controller.lecturer;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Lecture controller class that creat , read , update, read.
 * Date: 26 September 2020
 */

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.factory.LectureFactory;
import org.assignmentTracker.repository.lecture.impl.LectureRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lecture")
public class LecturerController {

    @Autowired
    private LectureRepositoryImpl lectureService;

    @PostMapping("/create")
    public Lecture create (@RequestBody Lecture lecture){

        Lecture newLecture = LectureFactory.newLecture(
                lecture.getName(),
                lecture.getSurname(),
                lecture.getEmail(),
                lecture.getCell_num(),
                lecture.getRoom());

        return lectureService.create(newLecture);
    }

    @PostMapping("/read/{id}")
    public Lecture read(@PathVariable int id){
        return lectureService.read(id);
    }

    @PostMapping("/update")
    public Lecture update (@RequestBody Lecture lecture){

        return lectureService.update(lecture);
    }

    @PostMapping("/delete/{id}")
     public void delete(@PathVariable int id){
          lectureService.delete(id);
     }

    @GetMapping("/all")
    public Set<Lecture> getAll(){
        return lectureService.getAll();
    }


}
