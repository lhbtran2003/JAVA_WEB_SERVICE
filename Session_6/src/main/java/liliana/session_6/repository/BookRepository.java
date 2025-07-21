package liliana.session_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import liliana.session_6.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
