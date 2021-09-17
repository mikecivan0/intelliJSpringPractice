package hr.mikec.intellijspringpractice.bootstrap;

import hr.mikec.intellijspringpractice.model.Author;
import hr.mikec.intellijspringpractice.model.Book;
import hr.mikec.intellijspringpractice.model.Publisher;
import hr.mikec.intellijspringpractice.repositories.AuthorRepository;
import hr.mikec.intellijspringpractice.repositories.BookRepository;
import hr.mikec.intellijspringpractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String[] args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher(
                "pub name",
                "pub address",
                "some city",
                "some state",
                "78945");

        ddd.setPublisher(publisher);
        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Set<Book> books = new HashSet<>();
        books.add(ddd);
        eric.setBooks(books);
        authorRepository.save(eric);

        Set<Author> authors = new HashSet<>();
        authors.add(eric);
        ddd.setAuthors(authors);
        bookRepository.save(ddd);

        publisher.setBooks(books);
        publisherRepository.save(publisher);

        System.out.println("books: " + bookRepository.count());
        System.out.println("authors: " + authorRepository.count());
        System.out.println("publisher: " + publisherRepository.count());
        System.out.println("publisher books num: " + publisher.getBooks().size());

    }
}
