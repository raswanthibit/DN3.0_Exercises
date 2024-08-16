import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Employee.findByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    // Getters and Setters
}

@Entity
@NamedQuery(name = "Department.findByName",
        query = "SELECT d FROM Department d WHERE d.name = :name")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and Setters
}
