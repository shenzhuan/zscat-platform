//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zscat.common.result;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private static final long serialVersionUID = 8694461719746019858L;
    private int retcode;
    private String retdesc = "";

    public ResultInfo() {
    }

    public ResultInfo(int retcode, String retdesc) {
        this.retcode = retcode;
        this.retdesc = retdesc;
    }

    public int getRetcode() {
        return this.retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getRetdesc() {
        return this.retdesc;
    }

    public void setRetdesc(String retdesc) {
        this.retdesc = retdesc;
    }
}
