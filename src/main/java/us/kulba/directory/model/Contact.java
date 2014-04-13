package us.kulba.directory.model;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO for holding Contact info in the Directory.
 *
 * @author James Kulba, jkulba@gmail.com, 2014
 */
@Document(collection = "contacts")
public class Contact {

    @Id
    protected final String id;
    private String firstName;
    private String lastName;
    private String nickname;
    private Date dateEntered;
    private Date dateUpdated;
    private List<Address> addressList;
    private List<Phone> phoneList;

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

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

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

    public List<Phone> getPhoneList() {
        if (this.phoneList == null) {
            this.phoneList = new ArrayList<Phone>();
        }
        return this.phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) { this.phoneList = phoneList; }

    public void addPhone(Phone phone) { getPhoneList().add(phone); }

    public List<Address> getAddressList() {
        if (this.addressList == null) {
            this.addressList = new ArrayList<Address>();
        }
        return this.addressList;
    }

    public void setAddressList(List<Address> addressList) {
        getAddressList().addAll(addressList);
    }

    public void addAddress(Address address) {
        getAddressList().add(address);
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
