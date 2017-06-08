package com.example.cowmanager.model;

import java.io.Serializable;


public class RoleRequest implements Serializable {

    private Integer maQuyen;

    private String tenQuyen;

    public Integer getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(Integer maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}
