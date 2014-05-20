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
import us.kulba.directory.web.converter.ContactJsonConverter;

import java.util.ArrayList;
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
    public @ResponseBody List<Contact> list(@RequestParam(value = "groupId", required = true) String groupId) {
        logger.debug("Hit ContactController.allContacts()");
//        return contactRepository.findAll();

        List<Contact> contacts = new ArrayList<Contact>();

        if ( groupId.equals("all") ) {
            contacts = contactRepository.findAll();

        } else {
            contacts = contactRepository.findByContactGroup(groupId);
        }
        return contacts;
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
//    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Void> save(@RequestBody Contact contact) {
//        logger.debug("Hit ContactController save Contact");
//        contactRepository.save(contact);
//        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
//        return responseEntity;
//    }

    /**
     * Controller end-point used to delete contact with passed id.
     *
     */
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> execute(@RequestBody String json) {

        ResponseEntity<String> responseEntity = null;

        try {
            String command = ContactJsonConverter.convertToString(json, "commandName");
//            String command = "Contact.SAVE";
            Contact contact = ContactJsonConverter.convertToContact(json);

            if (command.equals("Contact.SAVE")) {
                logger.debug("Hit ContactController SAVE Contact");
                contactRepository.save(contact);
                responseEntity = new ResponseEntity<String>("Contact created", HttpStatus.CREATED);

            }
            else if (command.equals("Contact.DELETE")) {
                logger.debug("Hit ContactController DELETE Contact");
                contactRepository.delete(contact);
                responseEntity = new ResponseEntity<String>("Contact deleted", HttpStatus.OK);

            }
            else {
                responseEntity = new ResponseEntity<String>("Unknown Contact transaction type.", HttpStatus.BAD_REQUEST);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }




}
