package hr.mikec.intellijspringpractice.repositories;

import hr.mikec.intellijspringpractice.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
