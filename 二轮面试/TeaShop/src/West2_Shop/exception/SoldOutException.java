package West2_Shop.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SoldOutException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * 重载构造函数
     */
    public SoldOutException() {
        super();
    }
    public SoldOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SoldOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoldOutException(String message) {
        super(message);
    }

    public SoldOutException(Throwable cause) {
        super(cause);
    }

    /**
     * 重写父类的方法
     */
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return super.getMessage();
    }
    @Override
    public String getLocalizedMessage() {
        // TODO Auto-generated method stub
        return super.getLocalizedMessage();
    }
    @Override	public synchronized Throwable getCause() {
        // TODO Auto-generated method stub
        return super.getCause();
    }
    @Override
    public synchronized Throwable initCause(Throwable cause) {
        // TODO Auto-generated method stub
        return super.initCause(cause);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    @Override
    public void printStackTrace() {
        // TODO Auto-generated method stub
        super.printStackTrace();
    }
    @Override
    public void printStackTrace(PrintStream s) {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }
    @Override
    public void printStackTrace(PrintWriter s) {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        // TODO Auto-generated method stub
        return super.fillInStackTrace();
    }
    @Override
    public StackTraceElement[] getStackTrace() {
        // TODO Auto-generated method stub
        return super.getStackTrace();
    }
    @Override	public void setStackTrace(StackTraceElement[] stackTrace) {
        // TODO Auto-generated method stub
        super.setStackTrace(stackTrace);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
    @Override	protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

}
