package pl.bigbook.exchanger;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 28.12.13
 * Time: 23:38
 * To change this template use File | Settings | File Templates.
 */
public class Vendor {
    private String uniqueName;
    private String url;
    private String name;

    public Vendor(Object p0) {
    }

    public Vendor() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
