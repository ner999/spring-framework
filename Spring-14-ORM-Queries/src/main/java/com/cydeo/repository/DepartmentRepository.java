package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //display all departments in the toys department
    List<Department> findByDepartment(String department);

    //display all departments in the health division
    //same
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display top3 departments with division name includes "Hea" without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String division);


    @Query ("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);



// from properties file (meta-inf folder)
    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentDivisionContain(String pattern); // elec


}
