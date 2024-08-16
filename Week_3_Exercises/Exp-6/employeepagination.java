import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

   
    List<Employee> findAll(Sort sort);

    // Find all employees with pagination and sorting
    Page<Employee> findByPosition(String position, Pageable pageable);
}
