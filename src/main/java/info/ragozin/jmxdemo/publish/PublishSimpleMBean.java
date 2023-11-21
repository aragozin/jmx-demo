package info.ragozin.jmxdemo.publish;

import java.lang.management.ManagementFactory;

import javax.management.MXBean;
import javax.management.ObjectName;

/**
 * Minimalistic code snippet for MBean publishing.
 *
 * @author Alexey Ragozin (alexey.ragozin@gmail.com)
 */
public class PublishSimpleMBean {

    /**
     * Minimalistic MBean interface with single attribute.
     */
    @MXBean(value = true)
    public interface MyMXBean {
        public String getValue();
    }

    /**
     * Trivial MBean implementation.
     */
    public static class MyMXBeanImpl implements MyMXBean {
        @Override
        public String getValue() {
            return "Hello world!";
        }
    }

    /**
     * This method will create an instance of {@link MyMXBeanImpl} and publish it.
     * Exception will be throws if {@link ObjectName} is already present in registry.
     */
    public static void publishMbean() throws Exception {
        ObjectName bname = new ObjectName("test:name=\"My bean\"");
        MyMXBean bean = new MyMXBeanImpl();
        ManagementFactory.getPlatformMBeanServer().registerMBean(bean, bname);
    }
}
