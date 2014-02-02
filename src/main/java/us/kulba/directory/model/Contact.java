package us.kulba.directory.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO for holding Contact info in the Directory.
 *
 * @author James Kulba, jkulba@gmail.com, 2013
 */
@Document(collection = "contacts")
public class Contact {

    @Id
    protected final String id;
    private String firstName;
    private String lastName;
    private Date dateEntered;
    private Date dateUpdated;

    public Contact() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        this.setDateEntered(calendar.getTime());
        this.id = new ObjectId().toString();
    }

    public String getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    private void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getFullName() {
        String fullName[] = {firstName, lastName};
        return StringUtils.join(fullName, " ");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}
