import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

   
    @GetMapping("/paged")
    public Page<Employee> getAllEmployeesPaged(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    
    @GetMapping("/sorted")
    public List<Employee> getAllEmployeesSorted(@RequestParam String sortBy) {
        return employeeRepository.findAll(Sort.by(sortBy));
    }

  
    @GetMapping("/pagedAndSorted")
    public Page<Employee> getEmployeesPagedAndSorted(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }
}
