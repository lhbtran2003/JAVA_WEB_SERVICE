package liliana.session_6.controller;

import liliana.session_6.dto.request.AddBookRequest;
import liliana.session_6.dto.request.UpdateBookRequest;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import liliana.session_6.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Book>>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Book>> addBook(@RequestBody AddBookRequest book) {
       return new ResponseEntity<>( bookService.create(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Book>> updateBook(@PathVariable long id ,@RequestBody UpdateBookRequest book) {
        return new ResponseEntity<>( bookService.update(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<Book>> deleteBook( @PathVariable long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
