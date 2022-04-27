package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Display all employees with email address xxx
    List<Employee> findByEmail(String email);

    //Display all employees with first name "xx", last name "xxx", also show all employees with email address
List<Employee> findByFirstNameAndLastNameOrEmail(String name, String lastName, String email);

// Display all employees that first name is not "xx";
    List<Employee> findByFirstNameNot(String name);


    // Display all employees that last name  starts with ...
    List<Employee> findByLastNameStartingWith(String lastname);

    //Display all employees higher than xxxx
    List<Employee> findBySalaryGreaterThan(int salary);

    //Display all employees less than xxxx
    List<Employee> findBySalaryLessThan(int salary);

    //Display all employees that were hired between ...
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater or equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top 3 unique employees that making less than xxx
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

@Query("SELECT e FROM Employee e WHERE e.email = 'myakovlivf@ucsd.edu'")
    Employee getEmployeeDetail();


    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'myakovlivf@ucsd.edu'")
    Integer getEmployeeSalary();


    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);


    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email, int salary);


}
