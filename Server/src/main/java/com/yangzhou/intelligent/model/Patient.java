package com.yangzhou.intelligent.model;

public class Patient {
    private Integer pid;

    private String pname;

    private String pgender;

    private Integer page;

    private Double pheight;

    private Double pweight;

    private String dname;

    private Integer ifDel;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender == null ? null : pgender.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Double getPheight() {
        return pheight;
    }

    public void setPheight(Double pheight) {
        this.pheight = pheight;
    }

    public Double getPweight() {
        return pweight;
    }

    public void setPweight(Double pweight) {
        this.pweight = pweight;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public Integer getIfDel() {
        return ifDel;
    }

    public void setIfDel(Integer ifDel) {
        this.ifDel = ifDel;
    }
}