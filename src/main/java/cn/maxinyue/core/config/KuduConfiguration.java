package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Properties;

/**
 * Created by obama on 2017/12/12.
 */
@XmlType
public class KuduConfiguration {
    private Properties properties;

    @XmlElement
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "KuduConfiguration{" +
                "properties=" + properties +
                '}';
    }
}
