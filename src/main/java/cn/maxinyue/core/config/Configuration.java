package cn.maxinyue.core.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@XmlType
public class Configuration implements Serializable {

    static Logger logger = LoggerFactory.getLogger(Configuration.class.getSimpleName());

    public final static String configFolder = "./";

    public final static String systemConfigFolder = "TL_HOME";

    public final static String configFileName = "config.yml";

    private static Configuration configuration;

    private static String env = "dev";

    public static <T extends Configuration> T read(InputStream configStream, Class<T> configurationType) throws IOException {
        return getMapper().readValue(configStream, configurationType);
    }

    private Configuration() {
        logger.debug("construct Configuration");
    }

    public static synchronized Configuration getDefaultConfiguration() {
        if (configuration == null) {
            try {
                env = System.getProperty("env");
                if (Strings.isNullOrEmpty(env)) {
                    env = System.getenv("env");
                    if (Strings.isNullOrEmpty(env)) {
                        env = "dev";
                    }
                }
                configuration = readDefaultConfiguration(configFileName.split("\\.")[0] + "." + env + "." + configFileName.split("\\.")[1]);
            } catch (Throwable e) {
                logger.error("getDefaultConfiguration error ", e);
            }
        }
        return configuration;
    }

    private static Configuration readDefaultConfiguration(String configFileName) throws Exception {
        File configFile = null;
        if ((configFile = new File(System.getenv(systemConfigFolder) + File.separator + configFileName)).exists()) {
            logger.debug("read config from system folder");
            return read(new FileInputStream(configFile), Configuration.class);
        }
        if ((configFile = new File(configFolder + configFileName)).exists()) {
            logger.debug("read config from same folder");
            return read(new FileInputStream(configFile.getCanonicalFile()), Configuration.class);
        }
        logger.debug("read config null, return default config");
        return read(Configuration.class.getClassLoader().getResourceAsStream(configFileName), Configuration.class);
    }

    private static Configuration readDefaultConfiguration() throws Exception {
        return readDefaultConfiguration(configFileName);
    }

    public static String dump(Configuration configuration) throws JsonProcessingException {
        return getMapper().writeValueAsString(configuration);
    }

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setAnnotationIntrospector(new AnnotationIntrospectorPair(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()), new JacksonAnnotationIntrospector()));
        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

    private Map<String, DatabaseConfiguration> databases = new HashMap<>();

    private SparkConfiguration spark;

    private Properties hive;

    private LocalConfiguration local;

    private MonitorConfiguration monitor;

    private KafkaConfiguration kafka;

    private KuduConfiguration kudu;

    @XmlElement
    public Map<String, DatabaseConfiguration> getDatabases() {
        return databases;
    }

    public void setDatabases(Map<String, DatabaseConfiguration> databases) {
        this.databases = databases;
    }

    @XmlElement
    public SparkConfiguration getSpark() {
        return spark;
    }

    public void setSpark(SparkConfiguration spark) {
        this.spark = spark;
    }

    @XmlElement
    public Properties getHive() {
        return hive;
    }

    public void setHive(Properties hive) {
        this.hive = hive;
    }

    @XmlElement
    public LocalConfiguration getLocal() {
        return local;
    }

    public void setLocal(LocalConfiguration local) {
        this.local = local;
    }

    @XmlElement
    public KafkaConfiguration getKafka() {
        return kafka;
    }

    public void setKafka(KafkaConfiguration kafka) {
        this.kafka = kafka;
    }

    public static String getEnv() {
        return env;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "databases=" + databases +
                ", spark=" + spark +
                ", hive=" + hive +
                ", local=" + local +
                ", monitor=" + monitor +
                ", kafka=" + kafka +
                ", kudu=" + kudu +
                '}';
    }

    @XmlElement
    public MonitorConfiguration getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorConfiguration monitor) {
        this.monitor = monitor;
    }

    @XmlElement
    public KuduConfiguration getKudu() {
        return kudu;
    }

    public void setKudu(KuduConfiguration kudu) {
        this.kudu = kudu;
    }
}
