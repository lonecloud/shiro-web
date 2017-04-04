package cn.lonecloud.expection;

/**
 * Created by lonecloud on 17/4/4.
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
