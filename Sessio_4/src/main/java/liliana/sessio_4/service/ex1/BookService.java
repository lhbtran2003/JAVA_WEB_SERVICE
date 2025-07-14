package liliana.sessio_4.service.ex1;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import liliana.sessio_4.dto.ex1.AddBookRequest;
import liliana.sessio_4.dto.ex1.UpdateBookRequest;
import liliana.sessio_4.entity.ex1.Book;
import liliana.sessio_4.repository.ex1.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> findAll(int page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page,5,sort);
        return bookRepository.findAll(pageable);
    }

    public void save(AddBookRequest addBookRequest) {
        Book newBook = new Book();
        newBook.setAuthor(addBookRequest.getAuthor());
        newBook.setTitle(addBookRequest.getTitle());
        newBook.setYear(addBookRequest.getYear());
        newBook.setPublisher(addBookRequest.getPublisher());
        bookRepository.save(newBook);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void update(Long id, UpdateBookRequest request) {
        Book isExistingBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        isExistingBook.setTitle(request.getTitle());
        isExistingBook.setAuthor(request.getAuthor());
        isExistingBook.setPublisher(request.getPublisher());
        isExistingBook.setYear(request.getYear());
        bookRepository.save(isExistingBook);
    }

    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
