package pl.bigbook.exchanger.dao;

import org.springframework.dao.DataAccessException;
import pl.bigbook.exchanger.Vendor;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 30.12.13
 * Time: 01:23
 * To change this template use File | Settings | File Templates.
 */
public interface VendorDao {

    public Vendor addVendor(Vendor vendor) throws DataAccessException;
}
