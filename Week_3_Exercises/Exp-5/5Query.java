import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query using method name convention
    List<Employee> findByPosition(String position);

    // Custom query using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findEmployeesByNameContains(String name);
}

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Custom query using method name convention
    List<Department> findByName(String name);

    // Custom query using @Query annotation
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> findDepartmentsByNameContains(String name);
}
