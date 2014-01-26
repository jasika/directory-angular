package us.kulba.directory.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import us.kulba.directory.dao.ContactRepository;
import us.kulba.directory.model.Contact;

import java.util.List;

/**
 * Spring Controller for Contacts crud activities.
 *
 * @author James Kulba, jkulba@gmail.com, 2014
 */
@RequestMapping("contacts")
@Controller
public class ContactController {
    final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository contactRepository;


    /**
     * Controller end-point used to fetch all contacts.
     *
     * @return list of contacts
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Contact> allContacts() {
        logger.debug("Hit ContactController.allContacts()");
        return contactRepository.findAll();
    }

    /**
     * Controller end-point used to fetch contact record using contactId.
     *
     * @param contactId
     * @return contact
     */
    @RequestMapping(value = "/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact findContact(@PathVariable("contactId") String contactId) {
        logger.debug("Hit ContactController.findContact()");
        Contact contact = contactRepository.findOne(contactId);
        if (contact == null) {
            throw new ContactNotFoundException(contactId);
        }
        return contact;
    }

    /**
     * Controller end-point used to save new or update existing contacts.
     *
     * @param contact in JSON form.
     * @return
     */
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> saveContact(@RequestBody Contact contact) {
        logger.debug("Hit ContactController.saveContact()");
        contactRepository.save(contact);
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
        return responseEntity;
    }


}
