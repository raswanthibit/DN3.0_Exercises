public class EmployeeDTO {
    private String name;
    private String position;

    public EmployeeDTO(String name, String position) {
        this.name = name;
        this.position = position;
    }

    
}


import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.demo.EmployeeDTO(e.name, e.position) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();
}
