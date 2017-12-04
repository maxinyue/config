package config;

import cn.maxinyue.core.config.Configuration;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigurationTest {

    @Test
    public void should_config() {
        Configuration c = Configuration.getDefaultConfiguration();
        System.out.println(c);
        assertThat(c.getEnv(), Is.is("dev"));
    }


    @Test
    public void should_config_env() {
        System.setProperty("env", "test");
        Configuration c = Configuration.getDefaultConfiguration();
        System.out.println(c);
        assertThat(c.getEnv(), Is.is("test"));
    }

    @Test
    public void should_config_all() {
        System.setProperty("env", "test");
        Configuration c = Configuration.getDefaultConfiguration();
        System.out.println(c);
        System.out.println(c.getLocal().getTimeoutQuestConfiguration("ods_baby_situation_for_preg"));
        System.out.println(c.getLocal().getTimeoutQuestConfiguration("hehe"));
    }

    @Test
    public void should_config_monitor() {
        System.setProperty("env", "test");
        Configuration c = Configuration.getDefaultConfiguration();
        System.out.println(c.getMonitor());
    }

    @Test
    public void should_config_product() {
        System.setProperty("env", "product");
        Configuration c = Configuration.getDefaultConfiguration();
        System.out.println(c.getLocal());
    }
}
