/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Dell 7450
 */
public class DoanhThu implements Serializable {

    String name;
    float tien;
    Date ngay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }


    public DoanhThu(String name,Date day){
        this.name = name;
        this.ngay = day;
    }
    public DoanhThu(){

    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o instanceof DoanhThu){
            if(((DoanhThu)o).getName().equals(this.getName()) &&
                    ((DoanhThu)o).getNgay().equals(this.getNgay()) &&
            ((DoanhThu) o).getTien() == this.getTien()){
                return true;
            }
        }
        return false;
    }
}
