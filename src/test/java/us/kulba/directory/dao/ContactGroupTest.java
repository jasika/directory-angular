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

import java.util.List;

/**
 * Object used to ..
 *
 * @author James Kulba, Thermo Fisher Scientific, 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ContactGroupTest {
    final Logger logger = LoggerFactory.getLogger(ContactGroupTest.class);

    @Autowired
    ContactRepository contactRepository;

    @Test
    public void findByContactGroupName() {
        logger.info("ContactGroupTest - findByContactGroupName");
        List<Contact> contacts = contactRepository.findByContactGroup("Family");
        for (Contact contact : contacts) {
            logger.info(contact.toString());
        }
    }

}
