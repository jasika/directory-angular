package us.kulba.directory.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Phone object.  Types: HOME, MOBILE, WORK
 *
 * @author James Kulba, jkulba@gmail.com, 2014
 */
public class Phone {

    private String phoneType;
    private String phoneNum;
    private boolean preferred;
    private Date dateUpdated;

    public Phone() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        this.setDateUpdated(calendar.getTime());
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
