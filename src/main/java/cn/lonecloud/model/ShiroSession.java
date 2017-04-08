package cn.lonecloud.model;

import java.io.Serializable;

/**
 * Created by lonecloud on 17/4/8.
 */
public class ShiroSession implements Serializable {

    private String id;

    private String sessionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
