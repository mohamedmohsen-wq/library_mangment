package com.example.library.component;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import ch.qos.logback.classic.Logger;

@Component
public class componnentPatron {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(componnentPatron.class);

    public void logPatronAction(String action, Long PatronId) {
        logger.info("Action: {} for Patron ID: {}", action, PatronId);
    }

    public void validateBooksData(String name, String contactInfo) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Patron name cannot be empty.");
        }

        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new IllegalArgumentException("Patron contactInfo cannot be empty.");
        }
    }

}
