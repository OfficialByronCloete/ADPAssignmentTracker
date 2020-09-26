package org.assignmentTracker.service.choice.impl;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.repository.choice.impl.ChoiceRepository;
import org.assignmentTracker.service.choice.IChoiceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChoiceServiceImpl implements IChoiceService {

    private static ChoiceServiceImpl choiceService = null;
    private ChoiceRepository choiceRepository;

    private ChoiceServiceImpl(){
        this.choiceRepository = ChoiceRepository.getRepository();
    }

    public static ChoiceServiceImpl getChoiceService(){
        if(choiceService == null)
            return new ChoiceServiceImpl();
         else{
            return choiceService;
        }
    }

    @Override
    public Set<Choice> getAll() {
        return this.choiceRepository.getAll();
    }

    @Override
    public Choice create(Choice choice) {
        return this.choiceRepository.create(choice);
    }

    @Override
    public Choice read(Integer integer) {
        return this.choiceRepository.read(integer);
    }

    @Override
    public Choice update(Choice choice) {
        return this.choiceRepository.update(choice);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.choiceRepository.delete(integer);
    }
}
