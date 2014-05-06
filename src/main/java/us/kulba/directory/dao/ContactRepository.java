package us.kulba.directory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import us.kulba.directory.model.Contact;

import java.util.List;

/**
 * ContactRepository is a Spring Data MongoRepository managing Contacts.
 *
 * @author James Kulba, jkulba@gmail.com, 2013
 */
public interface ContactRepository extends MongoRepository<Contact, String> {

    List<Contact> findByLastNameLike(String lastName);
}
