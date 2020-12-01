//package org.assignmentTracker.repositoryTest;
//
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;
//
///**
// * @author Caleb Ruiters
// * student number: 215169751
// * Desc: Test case for Repository/Data Access Layer of the Task entity
// * Date: 29 August 2020
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TaskRepositoryImplTest {
////
////    private static TaskRepositoryImpl repository = TaskRepositoryImpl.getRepository();
////    private static Task task = TaskFactory.newTask(818323613, 215169751, 1);
////
////    @Test
////    public void a_create() {
////        Task created = repository.create(task);
////        Assert.assertEquals(created.getTaskId(), task.getTaskId());
////        System.out.println(created + ": Was created");
////    }
////
////    @Test
////    public void b_read() {
////        Task read = repository.read(task.getTaskId());
////        Assert.assertEquals(read.toString(), task.toString());
////        System.out.println(read + ": Was read");
////    }
////
////    @Test
////    public void c_update() {
////        Task updated = new Task.Builder().copy(task).setMemberId(2).build();
////        updated = repository.update(updated);
////        Assert.assertTrue(updated.toString(), true);
////        System.out.println(updated + ": Was updated");
////    }
////
////    @Test
////    public void d_getAll() {
////        System.out.println(repository.getAll() + ": Is everything");
////    }
////
////    @Test
////    public void e_delete() {
////        boolean deleted = repository.delete(task.getTaskId());
////        Assert.assertTrue(deleted);
////    }
//}