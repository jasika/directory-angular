package us.kulba.directory.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.kulba.directory.config.TestConfig;
import us.kulba.directory.model.Contact;

import java.util.Calendar;
import java.util.List;

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

    @Test
    public void sayHello() {
        logger.info("Hello Joe");
    }

    @Test
    public void insertContactTest() {
        Calendar calendar = Calendar.getInstance();

        Contact c = new Contact();
        c.setFirstName("James");
        c.setLastName("Kulba");
        c.setDateEntered(calendar.getTime());
//        p.setDateUpdated(calendar.getTime());

        contactRepository.save(c);
        List<Contact> contacts = contactRepository.findAll();

        logger.info("Hello Betty");

        for (Contact person : contacts) {
            logger.info(person.toString());
        }
    }

    public void findPersonTest() {

    }

}
