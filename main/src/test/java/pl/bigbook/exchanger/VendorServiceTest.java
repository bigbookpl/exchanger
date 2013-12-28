package pl.bigbook.exchanger;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bigbook.exchanger.services.VendorService;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 28.12.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public class VendorServiceTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void addVendorTest(){
        //given
        Vendor vendor = new Vendor();


        vendor.setName("Walutomat");
        vendor.setUniqueName("WALUTOMAT");
        vendor.setUrl("http://www.walutomat.pl");

        //when
        Vendor resultVendor = null;

        try {
            resultVendor = VendorService.AddNewVendor(vendor);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //then
        Assert.assertEquals("message", "Walutomat", resultVendor.getName());
        Assert.assertEquals("message", "WALUTOMAT", resultVendor.getUniqueName());
        Assert.assertEquals("message", "http://www.walutomat.pl", resultVendor.getUrl());
    }


}
