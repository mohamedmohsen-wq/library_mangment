package com.example.library.component;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import ch.qos.logback.classic.Logger;
@Component
public class componentBooks {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(componentBooks.class);

    public void logBooksAction(String action, Long BooksId) {
        logger.info("Action: {} for Books ID: {}", action, BooksId);
    }

    public void validateBooksData(String title, String author) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Books title cannot be empty.");
        }

        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Books author cannot be empty.");
        }
    }

}
