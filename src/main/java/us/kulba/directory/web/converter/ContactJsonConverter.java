package us.kulba.directory.web.converter;

import us.kulba.directory.model.Contact;

public class ContactJsonConverter extends BaseJsonConverter {

    public static Contact convertToContact(String json) {
        return (Contact) convert(json, Contact.class, new String[]{"data"});
    }


}
