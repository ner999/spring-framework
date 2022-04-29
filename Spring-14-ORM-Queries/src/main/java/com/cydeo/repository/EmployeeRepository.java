package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
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


    //Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    // like/contains/startwith/endswith..
    @Query("SELECT e FROm Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmpployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeEmailIsNull();

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    //sorting in Asc
    @Query("SELECT e FROm Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //sorting in Desc
    @Query("SELECT e from Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();


    //NATIVE SQL
    @Query(value = "SELECT * FROM employees WHERE salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary (int salary);


    //params
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);


    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'admin@email.com' WHERE id=:id", nativeQuery = true)
    void updateEmployeeNative(@Param("id") int id);




}
