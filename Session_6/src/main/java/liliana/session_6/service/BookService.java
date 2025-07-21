package liliana.session_6.service;

import liliana.session_6.dto.request.AddBookRequest;
import liliana.session_6.dto.request.UpdateBookRequest;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import liliana.session_6.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements GenericService<Book, Long, UpdateBookRequest, AddBookRequest> {
    private final BookRepository bookRepository;

    @Override
    public DataResponse<Book> create(AddBookRequest book) {
        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setPrice(book.getPrice());
        newBook.setPublished(LocalDateTime.now());
        return DataResponse.<Book>builder()
                .key("book")
                .data(bookRepository.save(newBook))
                .build();
    }

    @Override
    public DataResponse<Book> update(Long id,UpdateBookRequest request) {
        if (!bookRepository.existsById(id)) {
            return null; // sau này ném lỗi exception
        }
        Book book = bookRepository.findById(id).get();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        return DataResponse.<Book>builder().key("book").data(bookRepository.save(book)).build();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public DataResponse<Book> findById(Long id) {
        return DataResponse.<Book>builder().key("book").data(bookRepository.findById(id).get()).build();
    }

    @Override
    public DataResponse<List<Book>> findAll() {
        return DataResponse.<List<Book>>builder()
                .key("books")
                .data(bookRepository.findAll())
                .build();
    }
}
