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
 * Unit Tests for Vendor Service
 */
@ContextConfiguration(locations = "classpath:META-INF/spring/AppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VendorServiceTest {


    @Autowired
    VendorService vendorService;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addVendorTest() {
        //given
        final String vendorName = "Narodowy Bank Polski";
        final String uniqueName = "NBP";
        final String url = "http://www.nbp.pl";

        Vendor vendor = new Vendor();
        vendor.setName(vendorName);
        vendor.setUniqueName(uniqueName);
        vendor.setUrl(url);

        try {
            //when
            Vendor resultVendor = vendorService.addNewVendor(vendor);
            //then
            Assert.assertEquals("message", vendorName, resultVendor.getName());
            Assert.assertEquals("message", uniqueName, resultVendor.getUniqueName());
            Assert.assertEquals("message", url, resultVendor.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VendorService getVendorService() {
        //@todo need to impl.
        return vendorService;
    }

    public void setVendorService(VendorService vendorService) {
        //@todo need to impl.
        this.vendorService = vendorService;
    }


}
