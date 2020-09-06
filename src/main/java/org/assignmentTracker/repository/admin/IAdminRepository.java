package org.assignmentTracker.repository.admin;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;
/**
 * @author Brandon Villet
 * student number: 214056791
 * Desc: Interface for admin repository
 * Date: 30 August 2020
 */

public interface IAdminRepository extends IRepository<Admin,Integer> {

    Set<Admin> getAll();
}