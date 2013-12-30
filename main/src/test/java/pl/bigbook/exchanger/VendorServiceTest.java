package pl.bigbook.exchanger;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import pl.bigbook.exchanger.services.VendorService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 28.12.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public class VendorServiceTest implements ApplicationContextAware {


    private ApplicationContext appCtx;

    @Inject
    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addVendorTest() {
        //given
        Vendor vendor = new Vendor();

        vendor.setName("Walutomat");
        vendor.setUniqueName("WALUTOMAT");
        vendor.setUrl("http://www.walutomat.pl");

        //when
        Vendor resultVendor = null;

        try {
            resultVendor = vendorService.addNewVendor(vendor);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //then
        Assert.assertEquals("message", "Walutomat", resultVendor.getName());
        Assert.assertEquals("message", "WALUTOMAT", resultVendor.getUniqueName());
        Assert.assertEquals("message", "http://www.walutomat.pl", resultVendor.getUrl());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }
}
