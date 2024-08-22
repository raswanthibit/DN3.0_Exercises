import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@GetMapping("/{id}")
public ResponseEntity<Book> getBookWithCustomHeaders(@PathVariable("id") int id) {
    Book book = books.stream()
                     .filter(b -> b.getId() == id)
                     .findFirst()
                     .orElseThrow(() -> new BookNotFoundException("Book not found"));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "CustomHeaderValue");

    return new ResponseEntity<>(book, headers, HttpStatus.OK);
}
