package org.assignmentTracker.controller.choice;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.service.choice.impl.ChoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author Anganathi Ngodwane
 * @Date: 27 September 2020
 */

@RestController
@RequestMapping("/choice")
public class ChoiceController {

    @Autowired
    private ChoiceServiceImpl choiceService;

    public ChoiceController(ChoiceServiceImpl choiceService) {
        this.choiceService = choiceService;
    }

    @PostMapping("/create")
    public Choice create(@RequestBody Choice choice){
        List<Vote> voteList = new ArrayList<>();
        voteList.add(VoteFactory.createVote(UserFactory.createUser("Kruben", "Naidoo", "ilovecode", "knaidoo@cput.ac.za")));
        Choice newChoice = ChoiceFactory.createChoice("AppDve 3", voteList);
        choiceService.create(choice);
        return choice;
    }

    @GetMapping("/read/{id}")
    public Choice read(@PathVariable int id){
        return choiceService.read(id);
    }

    @PostMapping("/update")
    public Choice update(@RequestBody Choice choice){
        return choiceService.update(choice);
    }

    @GetMapping("/all")
    public Set getAll(){
        return choiceService.getAll() ;
    }

    @DeleteMapping("/delete/{deleteId}")
    public boolean delete(@PathVariable int deleteId){
        return choiceService.delete(deleteId);
    }
}
