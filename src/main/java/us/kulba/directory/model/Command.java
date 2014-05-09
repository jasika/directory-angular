package us.kulba.directory.model;

import java.io.Serializable;

/**
 * Command Wrapper
 *
 * @author James Kulba, Thermo Fisher Scientific, 2014
 */
public class Command {

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

//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("MethodWrapper \n");
//        sb.append("MethodName: " + this.getMethodName());
//        return sb.toString();
//    }
}
