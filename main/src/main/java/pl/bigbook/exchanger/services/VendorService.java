package pl.bigbook.exchanger.services;

import pl.bigbook.exchanger.Vendor;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 30.12.13
 * Time: 00:37
 * To change this template use File | Settings | File Templates.
 */

public interface VendorService {


    public Vendor addNewVendor(Vendor vendor) throws Exception;

    public Vendor getVendorById(int id);
}
