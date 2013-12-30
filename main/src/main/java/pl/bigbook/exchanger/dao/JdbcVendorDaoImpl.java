package pl.bigbook.exchanger.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Service;
import pl.bigbook.exchanger.Vendor;

import java.util.HashMap;
import java.util.Map;

@Service
public class JdbcVendorDaoImpl extends SimpleJdbcDaoSupport implements VendorDao {

    private static final String SQL_INSERT_VENDOR = "INSERT INTO vendor(uniquename,url,name) VALUES(:uniqueName,:url,:name)";

    @Override
    public Vendor addVendor(Vendor vendor) {
        Map<String, String> namedQueryParams = new HashMap<String, String>();
        namedQueryParams.put("uniqueName", vendor.getUniqueName());
        namedQueryParams.put("url", vendor.getUrl());
        namedQueryParams.put("name", vendor.getName());
        getSimpleJdbcTemplate().update(SQL_INSERT_VENDOR, namedQueryParams);
        return vendor;
    }
}
