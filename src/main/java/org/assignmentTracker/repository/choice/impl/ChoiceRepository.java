//package org.assignmentTracker.repository.choice.impl;
//
//import org.assignmentTracker.entity.Choice;
//import org.assignmentTracker.repository.choice.ChoiceRepositoryInterface;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ChoiceRepository implements ChoiceRepositoryInterface {
//    private final Set<Choice> ChoiceDB;
//    public static ChoiceRepository choice = null;
//
//    public ChoiceRepository() {
//        this.ChoiceDB = new HashSet<>();
//    }
//
//    public static ChoiceRepository getRepository() {
//        if (choice == null) choice = new ChoiceRepository();
//        return choice;
//    }
//
//    @Override
//    public Choice create(Choice c) {
//        this.ChoiceDB.add(c);
//        return c;
//    }
//
//    @Override
//    public Choice read(Integer id) {
//        for (Choice c : this.ChoiceDB) {
//            if (c.getId() == id)    return c;
//        }
//        return null;
//    }
//
//    @Override
//    public Choice update(Choice c) {
//        Choice oldChoice = read(c.getId());
//        if (oldChoice != null) {
//            delete(oldChoice.getId());
//            this.ChoiceDB.add(c);
//        }
//        return c;
//    }
//
//    @Override
//    public boolean delete(Integer deleteId) {
//        Choice choice = read(deleteId);
//        if (choice != null) {
//            this.ChoiceDB.remove(choice);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Choice> getAll() {
//        return this.ChoiceDB;
//    }
//}
