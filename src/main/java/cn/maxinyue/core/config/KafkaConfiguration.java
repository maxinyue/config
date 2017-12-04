package cn.maxinyue.core.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Properties;

/**
 * Created by obama on 15/5/19.
 */
@XmlType
public class KafkaConfiguration {

    private Properties consumer;

    private Properties broker;

    private Properties producer;

    @XmlElement
    public Properties getConsumer() {
        return consumer;
    }

    public void setConsumer(Properties consumer) {
        this.consumer = consumer;
    }

    @XmlElement
    public Properties getBroker() {
        return broker;
    }

    public void setBroker(Properties broker) {
        this.broker = broker;
    }

    @XmlElement
    public Properties getProducer() {
        return producer;
    }

    public void setProducer(Properties producer) {
        this.producer = producer;
    }
}
