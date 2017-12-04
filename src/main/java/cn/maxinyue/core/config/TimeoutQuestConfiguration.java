package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.concurrent.TimeUnit;

/**
 * Created by obama on 2017/11/13.
 */
@XmlType
public class TimeoutQuestConfiguration {

    private long timeout;

    private TimeUnit timeUnit = TimeUnit.MINUTES;

    @Override
    public String toString() {
        return "TimeoutQuestConfiguration{" +
                "timeout=" + timeout +
                ", timeUnit=" + timeUnit +
                '}';
    }

    @XmlElement
    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    @XmlElement
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

}
