import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book bookDetails) {
        // Logic to update a book by ID
        return new ResponseEntity<>(bookDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        // Logic to delete a book by ID
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   @GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
    Book book = books.stream()
                     .filter(b -> b.getId() == id)
                     .findFirst()
                     .orElse(null);

    if (book != null) {
        return new ResponseEntity<>(book, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@GetMapping("/search")
public ResponseEntity<List<Book>> searchBooks(@RequestParam(value = "title", required = false) String title,
                                              @RequestParam(value = "author", required = false) String author) {
    List<Book> filteredBooks = books;

    if (title != null) {
        filteredBooks = filteredBooks.stream()
                                     .filter(b -> b.getTitle().equalsIgnoreCase(title))
                                     .toList();
    }

    if (author != null) {
        filteredBooks = filteredBooks.stream()
                                     .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                                     .toList();
    }

    return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
}
@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(@RequestParam("name") String name,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("address") String address) {
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmail(email);
    customer.setAddress(address);

    // Logic to save the customer

    return new ResponseEntity<>(customer, HttpStatus.CREATED);
}


}


