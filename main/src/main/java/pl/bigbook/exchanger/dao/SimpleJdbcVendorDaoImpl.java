package pl.bigbook.exchanger.dao;

        import org.intellij.lang.annotations.Language;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.dao.DataAccessException;
        import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
        import org.springframework.stereotype.Repository;
        import pl.bigbook.exchanger.Vendor;

        import javax.sql.DataSource;
        import java.util.HashMap;
        import java.util.Map;


@Repository
public class SimpleJdbcVendorDaoImpl extends SimpleJdbcDaoSupport implements VendorDao {

    @Language("GenericSQL")
    private static final String SQL_INSERT_VENDOR = "INSERT INTO vendor(uniquename, url, name) VALUES(:uniqueName,:url,:name)";

    /**
     * It is required for inject datasource
     *
     * @param dataSource
     */
    @Autowired
    public SimpleJdbcVendorDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public Vendor addVendor(Vendor vendor) throws DataAccessException {
        Map<String, String> namedQueryParams = new HashMap<String, String>();

        namedQueryParams.put("uniqueName", vendor.getUniqueName());
        namedQueryParams.put("url", vendor.getUrl());
        namedQueryParams.put("name", vendor.getName());
        getSimpleJdbcTemplate().update(SQL_INSERT_VENDOR, namedQueryParams);
        return vendor;
    }
}
