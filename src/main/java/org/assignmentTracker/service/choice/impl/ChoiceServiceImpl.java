package org.assignmentTracker.service.choice.impl;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.repository.choice.ChoiceRepositoryInterface;
import org.assignmentTracker.service.choice.IChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChoiceServiceImpl implements IChoiceService {

    private static ChoiceServiceImpl choiceService;

    @Autowired
    private ChoiceRepositoryInterface choiceRepository;

    @Override
    public Set<Choice> getAll() {
        return this.choiceRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Choice> getByName(String name) {
        Set<Choice> choices = getAll();
        choices.removeIf(choice -> !choice.getName().equalsIgnoreCase(name));
        return choices;
    }

    @Override
    public Choice create(Choice choice) {
        return this.choiceRepository.save(choice);
    }

    @Override
    public Choice read(Integer integer) {
        return this.choiceRepository.findById(integer).orElseGet(null);
    }



    @Override
    public Choice update(Choice choice) {
        if(this.choiceRepository.existsById(choice.getId())) {
            return this.choiceRepository.save(choice);
        }
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
         this.choiceRepository.deleteById(integer);
         if(this.choiceRepository.existsById(integer)){
             return false;
         }
         return true;
    }
}
