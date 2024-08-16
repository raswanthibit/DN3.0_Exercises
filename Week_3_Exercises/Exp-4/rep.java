import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
