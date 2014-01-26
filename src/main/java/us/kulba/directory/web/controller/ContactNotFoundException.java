package us.kulba.directory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException returned when a contact is not found.
 *
 * @author James Kulba, jkulba@gmail.com, 2014
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String contactId) {
        super(String.format("Contact with id %s not found", contactId));
    }
}
