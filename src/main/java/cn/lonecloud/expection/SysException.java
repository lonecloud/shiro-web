package cn.lonecloud.expection;

/**
 * 自定义异常类
 * @author lonecloud
 * @Date 2017.4.4
 * @Version 1.0
 */
public class SysException extends RuntimeException {


    private String msg;

    public SysException(){
        super();
    }
    public SysException(String msg){
        super(msg);
        this.msg=msg;
    }
    public SysException(Throwable e){
        super(e);
        this.msg=e.getMessage();
    }
    public SysException(Throwable e,String msg){
        super(e);
        this.msg=msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
