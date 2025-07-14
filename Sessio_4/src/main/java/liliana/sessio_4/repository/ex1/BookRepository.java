package liliana.sessio_4.repository.ex1;

import liliana.sessio_4.entity.ex1.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
