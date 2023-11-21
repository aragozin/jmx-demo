package info.ragozin.jmxdemo.consume;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MXBean;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/**
 * Example of MBean consumption code.
 * A consumer side declaration of interface is used in example to avoid dependency on publisher side code.
 *
 * @author Alexey Ragozin (alexey.ragozin@gmail.com)
 */
public class ConsumeSimpleMBean {

    /**
     * Consumer side declaration of {@link MyMXBean} interface.
     */
    @MXBean(value = true)
    public interface MyMXBean {
        public String getValue();
    }

    public static String getValue(MBeanServerConnection conn) throws MalformedObjectNameException {

        ObjectName bname = new ObjectName("test:name=\"My bean\"");
        MyMXBean bean = JMX.newMXBeanProxy(conn, bname, MyMXBean.class);

        return bean.getValue();
    }

}
