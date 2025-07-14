package liliana.sessio_4.controller.ex1;

import liliana.sessio_4.dto.ex1.AddBookRequest;
import liliana.sessio_4.dto.ex1.UpdateBookRequest;
import liliana.sessio_4.entity.ex1.Book;
import liliana.sessio_4.service.ex1.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new AddBookRequest());
        return "ex1/add-book";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") AddBookRequest book) {
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping
    public String list(@RequestParam(required = false, defaultValue = "0") int page, Model model) {
        model.addAttribute("books", bookService.findAll(page));
        return "ex1/list-book";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isEmpty()) {
            return "redirect:/404";
        }
        model.addAttribute("bookId", id);
        model.addAttribute("bookUpdate", book.get());
        return "ex1/edit-book";
    }
    @PostMapping("/edit/{id}")
    public String editBook( @ModelAttribute("book") UpdateBookRequest book, @PathVariable("id") Long id, Model model) {
        bookService.update(id, book);
        return "redirect:/books";
    }
    @PostMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
