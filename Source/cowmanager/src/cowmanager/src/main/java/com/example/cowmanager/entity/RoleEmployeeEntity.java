package com.example.cowmanager.entity;

import com.example.cowmanager.jpa.IdEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "role_employee")
public class RoleEmployeeEntity extends IdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 326622187744618271L;
    /**
     *
     */
    private String description;
    /**
     * @return
     */
    @OneToMany(mappedBy = "quyen")
    private List<EmployeeEntity> danhSachNhanVien;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the danhSachNhanVien
     */
    public List<EmployeeEntity> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    /**
     * @param danhSachNhanVien the danhSachNhanVien to set
     */
    public void setDanhSachNhanVien(List<EmployeeEntity> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

}
