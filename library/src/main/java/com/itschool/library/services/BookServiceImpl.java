package com.itschool.library.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.library.models.dtos.BookDTO;
import com.itschool.library.models.dtos.RequestBookDTO;
import com.itschool.library.models.dtos.ResponseBookDTO;
import com.itschool.library.models.entities.Book;
import com.itschool.library.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    private final ObjectMapper objectMapper;

    private final BookRepository bookRepository;

    public BookServiceImpl(ObjectMapper objectMapper, BookRepository bookRepository) {
        this.objectMapper = objectMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseBookDTO createBook(RequestBookDTO bookDTO) {
        Book bookEntity = objectMapper.convertValue(bookDTO, Book.class);
        Book bookEntityResponse = bookRepository.save(bookEntity);
        log.info("Book with id {} was saved", bookEntityResponse.getId());

        return objectMapper.convertValue(bookEntityResponse, ResponseBookDTO.class);
    }
}
