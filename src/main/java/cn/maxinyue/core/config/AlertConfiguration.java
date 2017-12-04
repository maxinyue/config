package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by obama on 2017/11/15.
 */
@XmlType
public class AlertConfiguration {

    private String name;

    private List<String> emails = new ArrayList<>();

    private String phoneNumber;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @XmlElement
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AlertConfiguration{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
