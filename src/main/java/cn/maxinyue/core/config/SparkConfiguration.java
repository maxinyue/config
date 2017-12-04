package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by obama on 2017/3/28.
 */
@XmlType
public class SparkConfiguration {

    private long rddSize;

    private String master;

    private Map<String, String> configs = new HashMap<>();

    @XmlElement
    public long getRddSize() {
        return rddSize;
    }

    public void setRddSize(long rddSize) {
        this.rddSize = rddSize;
    }

    @XmlElement
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "SparkConfiguration{" +
                "rddSize=" + rddSize +
                ", master='" + master + '\'' +
                ", configs=" + configs +
                '}';
    }

    @XmlElement
    public Map<String, String> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, String> configs) {
        this.configs = configs;
    }

}
