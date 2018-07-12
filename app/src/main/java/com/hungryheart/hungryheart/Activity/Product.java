package com.hungryheart.hungryheart.Activity;

public class Product {

    private int fid;
    private String fName;
    private int fImage;
    private  int catId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getfImage() {
        return fImage;
    }

    public void setfImage(int fImage) {
        this.fImage = fImage;
    }
}
