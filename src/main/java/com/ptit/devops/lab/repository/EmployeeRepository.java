
package com.ptit.devops.lab.repository;

import com.ptit.devops.lab.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
