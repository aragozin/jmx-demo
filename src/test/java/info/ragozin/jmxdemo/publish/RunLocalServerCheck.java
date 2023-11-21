package info.ragozin.jmxdemo.publish;

import java.lang.management.ManagementFactory;

import org.junit.Test;

public class RunLocalServerCheck {

    @Test
    public void launchLocalServer() throws Exception {

        // Register demo beans
        PublishSimpleMBean.publishMbean();

        JmxServer server = new JmxServer(ManagementFactory.getPlatformMBeanServer());

        server.setBindHost("127.0.0.1");
        server.setPort(4567); // port number used by demo

        server.start();

        System.out.println("JMX endpoint has started: " + server.getJmxUri());
        while(true) {
            Thread.sleep(100000);
        }
    }
}
