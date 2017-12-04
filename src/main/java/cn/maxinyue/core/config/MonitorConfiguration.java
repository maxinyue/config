package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by obama on 2017/11/15.
 */
@XmlType
public class MonitorConfiguration {
    private List<AlertConfiguration> alerts = new ArrayList<>();

    @XmlElement
    public List<AlertConfiguration> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertConfiguration> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return "MonitorConfiguration{" +
                "alerts=" + alerts +
                '}';
    }
}
