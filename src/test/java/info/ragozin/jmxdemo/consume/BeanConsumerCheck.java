package info.ragozin.jmxdemo.consume;

import java.lang.management.ManagementFactory;

import org.junit.Test;

import info.ragozin.jmxdemo.publish.PublishSimpleMBean;

public class BeanConsumerCheck {

    @Test
    public void checkSimpleBeanConsumption() throws Exception {

        PublishSimpleMBean.publishMbean();

        String value = ConsumeSimpleMBean.getValue(ManagementFactory.getPlatformMBeanServer());

        System.out.println("MBean value: " + value);
    }

}
