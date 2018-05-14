package com.xinktech.api.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlInfo {
    private String filename;
    private String xmin;
    private String xmax;
    private String ymin;
    private String ymax;
    private String calm;
    private String confused;
    private String sad;
    private String angry;
    private String happy;
    private String fear;
    private String disgust;

    public String getXmin() {
        return xmin;
    }

    public void setXmin(String xmin) {
        this.xmin = xmin;
    }

    public String getXmax() {
        return xmax;
    }

    public void setXmax(String xmax) {
        this.xmax = xmax;
    }

    public String getYmin() {
        return ymin;
    }

    public void setYmin(String ymin) {
        this.ymin = ymin;
    }

    public String getYmax() {
        return ymax;
    }

    public void setYmax(String ymax) {
        this.ymax = ymax;
    }

    public String getCalm() {
        return calm;
    }

    public void setCalm(String calm) {
        this.calm = calm;
    }

    public String getConfused() {
        return confused;
    }

    public void setConfused(String confused) {
        this.confused = confused;
    }

    public String getSad() {
        return sad;
    }

    public void setSad(String sad) {
        this.sad = sad;
    }

    public String getAngry() {
        return angry;
    }

    public void setAngry(String angry) {
        this.angry = angry;
    }

    public String getHappy() {
        return happy;
    }

    public void setHappy(String happy) {
        this.happy = happy;
    }

    public String getFear() {
        return fear;
    }

    public void setFear(String fear) {
        this.fear = fear;
    }

    public String getDisgust() {
        return disgust;
    }

    public void setDisgust(String disgust) {
        this.disgust = disgust;
    }
    public Map getXmlInfo(){
        Map map =new HashMap();
        map.put("filename",this.getFilename());
        map.put("xmin",this.getXmin());
        map.put("xmax",this.getXmax());
        map.put("ymin",this.getYmin());
        map.put("ymax",this.getYmax());
        map.put("calm",this.getCalm());
        map.put("confused",this.getConfused());
        map.put("sad",this.getSad());
        map.put("angry",this.getAngry());
        map.put("happy",this.getHappy());
        map.put("fear",this.getFear());
        map.put("disgust",this.getDisgust());
        return map;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
