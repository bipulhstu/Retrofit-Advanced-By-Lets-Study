package com.bipulhstu.retrofitadvancebyletsstudy;

import java.util.List;

public class OurMainDataClass {
    private List<OjbectDataClass> data;

    public OurMainDataClass() {
    }

    public OurMainDataClass(List<OjbectDataClass> data) {
        this.data = data;
    }


    public List<OjbectDataClass> getData() {
        return data;
    }

    public void setData(List<OjbectDataClass> data) {
        this.data = data;
    }
}
