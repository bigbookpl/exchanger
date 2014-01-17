package pl.bigbook.exchanger.services;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bigbook.exchanger.Vendor;
import pl.bigbook.exchanger.services.VendorService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 28.12.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = "classpath:META-INF/spring/AppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VendorServiceTest {


    @Autowired
    VendorService vendorService;


    @Before
    public void setUp() throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/AppContext.xml");
//        vendorService = context.getBean(VendorService.class);
    }

    @Test
    public void addVendorTest() {
        //given
        Vendor vendor = new Vendor();
        vendor.setName("Walutomat");
        vendor.setUniqueName("WALUTOMAT");
        vendor.setUrl("http://www.walutomat.pl");

        //when
        try {
            Vendor resultVendor = vendorService.addNewVendor(vendor);
            //then
            Assert.assertEquals("message", "Walutomat", resultVendor.getName());
            Assert.assertEquals("message", "WALUTOMAT", resultVendor.getUniqueName());
            Assert.assertEquals("message", "http://www.walutomat.pl", resultVendor.getUrl());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public VendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }


}
