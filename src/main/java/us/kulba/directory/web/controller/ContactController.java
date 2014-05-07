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
import us.kulba.directory.model.MethodWrapper;

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
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Contact> list() {
        logger.debug("Hit ContactController.allContacts()");
        return contactRepository.findAll();
    }

    /**
     * Controller end-point used to fetch contact record using contactId.
     *
     * @param id
     * @return contact
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Contact find(@PathVariable("id") String id) {
        logger.debug("Hit ContactController.findContact()");
        Contact contact = contactRepository.findOne(id);
        if (contact == null) {
            throw new ContactNotFoundException(id);
        }
        return contact;
    }

    /**
     * Controller end-point used to save new or update existing contacts.
     *
     * @param contact in JSON form.
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> save(@RequestBody Contact contact) {
        logger.debug("Hit ContactController save Contact");
        contactRepository.save(contact);
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
        return responseEntity;
    }

    /**
     * Controller end-point used to delete contact with passed id.
     *
     */
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@RequestBody MethodWrapper methodWrapper) {
        logger.debug("Hit ContactController delete Contact");
        Contact contact = (Contact)methodWrapper.getPayload();
        contactRepository.delete(contact);
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return responseEntity;
    }


}
