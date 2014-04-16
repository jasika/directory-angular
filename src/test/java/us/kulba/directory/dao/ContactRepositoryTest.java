package us.kulba.directory.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.kulba.directory.config.TestConfig;
import us.kulba.directory.model.Address;
import us.kulba.directory.model.Contact;
import us.kulba.directory.model.Phone;

import java.util.*;

/**
 * Junit test for Contact testing.
 *
 * @author James Kulba, jjkulba@yahoo.com, 2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ContactRepositoryTest {
    final Logger logger = LoggerFactory.getLogger(ContactRepositoryTest.class);

    @Autowired
    ContactRepository contactRepository;

//    @Before
//    public void setup() {
//        logger.info("ContactRepositoryTest - deleteAll Contacts");
//        contactRepository.deleteAll();
//    }

    /**
     * Local method to save a new contact.
     * @return us.kulba.directory.model.Contact
     */
    private Contact save() {
        logger.info("Saving new Contact");
        Contact c = new Contact();
        c.setFirstName("James");
        c.setLastName("Kulba");
        c.setNickname("Jim");

        Phone phone = new Phone();
        phone.setPreferred(true);
        phone.setPhoneType("MOBILE");
        phone.setPhoneNum("333-444-5555");

        c.addPhone(phone);

        phone = new Phone();
        phone.setPreferred(false);
        phone.setPhoneType("HOME");
        phone.setPhoneNum("321-990-5555");

        c.addPhone(phone);

        Address address = new Address();
        address.setAddressLine1("123 Main");
        address.setAddressLine2("BLANK");
        address.setAddressCity("Los Angeles");
        address.setAddressState("CA");
        address.setZipCode("81950");
        address.setPreferred(false);
        address.setAddressType("WORK");

        c.addAddress(address);

        address = new Address();
        address.setAddressLine1("27 Sonata");
        address.setAddressLine2("BLANK");
        address.setAddressCity("Irvine");
        address.setAddressState("CA");
        address.setZipCode("92813");
        address.setPreferred(true);
        address.setAddressType("HOME");

        c.addAddress(address);

        contactRepository.save(c);

        return c;
    }

    @Test
    public void saveNewContactTest() {
        logger.info("ContactRepositoryTest - saveNewContact");

        Contact c = this.save();
        logger.info("Here's the first Contact id: " + c.getId());
        logger.info(c.toString());
    }

//    @Test
    public void findByLastNameLike() {
        logger.info("ContactRepositoryTest - findByLastNameLike");
        List<Contact> contacts = contactRepository.findByLastNameLike("ulb");

        for (Contact contact : contacts) {
            logger.info(contact.toString());
        }

    }

//    @Test
//    public void findAndUpdateContactTest() {
//        logger.info("ContactRepositoryTest - findAndUpdateContactTest");
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
//        Contact c = this.save();
//        List<Contact> contacts = contactRepository.findByLastName("Kulba");
//
//        for (Contact contact : contacts) {
//            contact.setDateUpdated(calendar.getTime());
//            logger.info("Here's the updated Contact");
//            contactRepository.save(contact);
//            logger.info(contact.toString());
//        }
//    }

//    @Test
    public void findByContactIdTest() {

        Contact c = contactRepository.findOne("52ec7f01da06307d6be054e5");
        logger.info("ContactRepositoryTest - findByContactIdTest");
        logger.info(c.toString());
    }

//    @Test
    public void removeContactTest() {
        Contact c = contactRepository.findOne("52ec7f01da06307d6be054e5");
        contactRepository.delete(c);
        logger.info("Contact deleted");
    }

}
