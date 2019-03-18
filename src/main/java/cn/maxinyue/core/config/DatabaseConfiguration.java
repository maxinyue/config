package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by obama on 15/7/10.
 */
@XmlType
public class DatabaseConfiguration {

    private Type type;

    private String driver;

    private String url;

    private String password;

    private String user;

    private Map<String, String> properties = new HashMap<>();

    @XmlElement
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @XmlElement
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlElement
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @XmlElement
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DatabaseConfiguration{" +
                "type=" + type +
                ", driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                ", user='" + user + '\'' +
                ", properties=" + properties +
                '}';
    }

    public static enum Type {
        MYSQL, HIVE, HBASE, ORACLE, H2, POSTGRESQL;
    }
}
