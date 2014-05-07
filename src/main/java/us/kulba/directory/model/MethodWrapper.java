package us.kulba.directory.model;

/**
 * Wrapper
 *
 * @author James Kulba, Thermo Fisher Scientific, 2014
 */
public class MethodWrapper {

    private String methodName;
    private Object payload;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
