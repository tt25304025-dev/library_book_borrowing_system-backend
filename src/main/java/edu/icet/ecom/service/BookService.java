package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.BookDto;
import edu.icet.ecom.model.entity.BookEntity;
import edu.icet.ecom.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<BookDto> getAllDetails(){
        List<BookEntity> AllData=bookRepository.findAll();
        List<BookDto> AllBooks=new ArrayList<>();
        for(BookEntity book:AllData) {
            AllBooks.add(new BookDto(
                    book.getId(),
                    book.getTitle(),
                    book.getPublisher(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getIsbn(),
                    book.getAvailableCopies()
            ));
        }

        return AllBooks;
    }

    public void add(BookDto bookdto){
        BookEntity bookEntity=new BookEntity(
                bookdto.getId(),
                bookdto.getTitle(),
                bookdto.getAuthor(),
                bookdto.getPublisher(),
                bookdto.getIsbn(),
                bookdto.getCategory(),
                bookdto.getAvailableCopies());
        bookRepository.save(bookEntity);
    }

    public Optional<BookEntity> searchBookById(String id) {
        Optional<BookEntity> byID = bookRepository.findById(Long.parseLong(id));
        System.out.println(byID);
        return byID;
    }
}
