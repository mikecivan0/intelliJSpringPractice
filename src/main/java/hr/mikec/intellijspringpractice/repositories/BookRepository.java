package hr.mikec.intellijspringpractice.repositories;

import hr.mikec.intellijspringpractice.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
