public interface EmployeeNamePositionProjection {
    String getName();
    String getPosition();
}


import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    
    List<EmployeeNamePositionProjection> findAllBy();
}
