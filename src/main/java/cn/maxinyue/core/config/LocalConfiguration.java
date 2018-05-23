package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.*;

/**
 * Created by obama on 2017/4/27.
 */
@XmlType
public class LocalConfiguration {

    private Map<String, String> targetMap = new LinkedHashMap<>();

    private Map<String, String> statDateMap = new LinkedHashMap<>();

    private Map<String, List<String>> migrateTables = new HashMap<>();

    private Map<String, TimeoutQuestConfiguration> timeouts = new LinkedHashMap<>();

    private Properties custom;

    @XmlElement
    public Map<String, String> getTargetMap() {
        return targetMap;
    }

    @XmlElement
    public Map<String, String> getStatDateMap() {
        return statDateMap;
    }

    @XmlElement
    public Map<String, List<String>> getMigrateTables() {
        return migrateTables;
    }

    public void setTargetMap(Map<String, String> targetMap) {
        this.targetMap = targetMap;
    }

    public void setStatDateMap(Map<String, String> statDateMap) {
        this.statDateMap = statDateMap;
    }

    @XmlElement
    public Map<String, TimeoutQuestConfiguration> getTimeouts() {
        return timeouts;
    }

    public void setMigrateTables(Map<String, List<String>> migrateTables) {
        this.migrateTables = migrateTables;
    }

    public String getTargetTableByClassName(String name) {
        return targetMap.get(name);
    }

    public String getStatDateMapByClassName(String name) {
        return statDateMap.get(name);
    }

    public String getTargetTableByClass(Class clazz) {
        return getTargetTableByClassName(clazz.getName());
    }

    public String getStatDateMapByClass(Class clazz) {
        return getStatDateMapByClassName(clazz.getName());
    }

    public void setTimeouts(Map<String, TimeoutQuestConfiguration> timeouts) {
        this.timeouts = timeouts;
    }

    public TimeoutQuestConfiguration getTimeoutQuestConfiguration(String name) {
        TimeoutQuestConfiguration t = timeouts.get(name);
        if (t == null) {
            t = new TimeoutQuestConfiguration();
        }
        return t;
    }

    @XmlElement
    public Properties getCustom() {
        return custom;
    }

    public void setCustom(Properties custom) {
        this.custom = custom;
    }

    @Override
    public String toString() {
        return "LocalConfiguration{" +
                "targetMap=" + targetMap +
                ", statDateMap=" + statDateMap +
                ", migrateTables=" + migrateTables +
                ", timeouts=" + timeouts +
                ", custom=" + custom +
                '}';
    }
}
