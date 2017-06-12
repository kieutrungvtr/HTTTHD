package com.example.cowmanager.service;

import com.example.cowmanager.entity.EmployeeEntity;
import com.example.cowmanager.entity.RoleEmployeeEntity;
import com.example.cowmanager.model.*;
import com.example.cowmanager.repository.EmployeeRepository;
import com.example.cowmanager.repository.RoleEmployeeRepository;
import com.example.cowmanager.util.CowManagerConstants;
import com.example.cowmanager.util.RandomGenerator;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService extends BaseService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleEmployeeRepository roleRepository;

    @Transactional
    public List<Employee> getAllEmployee() throws CowManagerException {
        List<EmployeeEntity> entities = employeeRepository.findAllOn();
        List<Employee> result = new ArrayList<>();
        for (EmployeeEntity entity : entities) {
            Employee employee = toEmployeeWithoutCowEntity(entity);
            result.add(employee);
        }
        return result;
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Employee addEmployeeProfile(EmployeeRequest request)
            throws CowManagerException {

        String name = request.getTenNv();
        String diaChi = request.getDiaChi();
        String boPhan = request.getBoPhan();
        Integer chucVu = request.getChucDanh();
        String ngaySinh = request.getNgaySinh();
        Integer soDt = request.getSoDt();

        if (TextUtils.isEmpty(name)) {
            throw new CowManagerException("Ten nhan vien khong dc trong");
        }
        if (TextUtils.isEmpty(diaChi)) {
            throw new CowManagerException("Dia chi khong dc trong");
        }
        if (TextUtils.isEmpty(boPhan)) {
            throw new CowManagerException("Bo phan khong dc trong");
        }
        if (chucVu == null) {
            throw new CowManagerException("Chuc vu khong dc trong");
        }
        if (TextUtils.isEmpty(ngaySinh)) {
            throw new CowManagerException("Ngay sinh khong dc trong");
        }
        if (soDt == null) {
            throw new CowManagerException("So dien thoai khong dc trong");
        }
        EmployeeEntity entity = toEmployeeEntity(request);
        EmployeeEntity existedEntity;
        Integer maNv = new Integer(0);
        do {
            maNv = new Integer(RandomGenerator.getIntRand());
            existedEntity = employeeRepository
                    .findOneByColumn("maNv", maNv);
        } while (null != existedEntity);
        // Get role of employee
        RoleEmployeeEntity roleEntity = roleRepository.findOne(chucVu);
        entity.setQuyen(roleEntity);
        entity.setNgaySinh(ngaySinh);
        entity.setBoPhan(boPhan);
        entity.setMaNv(maNv);
        entity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        entity.setTrangThai(CowManagerConstants.EMPLOYEE_STATUS_ON);
        entity = employeeRepository.save(entity);
        if (entity != null) {
            return toEmployee(entity);
        } else {
            throw new CowManagerException("Cannot save to db");
        }
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Employee updateEmployeeProfile(EmployeeRequest request)
            throws CowManagerException {
        if (request.getMaNv() == null) {
            throw new CowManagerException("Ma nhan vien khong ton tai");
        }
        EmployeeEntity existedProfile = employeeRepository
                .findOneByColumn("maNv", request.getMaNv());
        if (existedProfile == null) {
            throw new CowManagerException("Ma nhan vien khong co trong db");
        }
        String name = request.getTenNv();
        String diaChi = request.getDiaChi();
        String boPhan = request.getBoPhan();
        Integer chucVu = request.getChucDanh();
        String ngaySinh = request.getNgaySinh();
        Integer soDt = request.getSoDt();

        if (!TextUtils.isEmpty(name)) {
            existedProfile.setTen(name);
        }
        if (!TextUtils.isEmpty(diaChi)) {
            existedProfile.setDiaChi(diaChi);
        }
        if (!TextUtils.isEmpty(boPhan)) {
            existedProfile.setBoPhan(boPhan);
        }
        if (chucVu != null) {
            RoleEmployeeEntity entity = roleRepository.findOne(chucVu);
            existedProfile.setQuyen(entity);
        }
        if (!TextUtils.isEmpty(ngaySinh)) {
            existedProfile.setNgaySinh(ngaySinh);
        }
        if (soDt != null) {
            existedProfile.setSoDt(soDt);
        }
        existedProfile = employeeRepository.save(existedProfile);

        if (existedProfile != null) {
            return toEmployee(existedProfile);
        } else {
            throw new CowManagerException("Cannot save to db");
        }
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Employee releaseEmployeeProfile(EmployeeRequest request)
            throws CowManagerException {
        if (request.getMaNv() == null) {
            throw new CowManagerException("Ma nhan vien khong ton tai");
        }
        EmployeeEntity existedProfile = employeeRepository
                .findOneByColumn("maNv", request.getMaNv());
        if (existedProfile == null) {
            throw new CowManagerException("Ma nhan vien khong co trong db");
        }
        existedProfile.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        existedProfile.setTrangThai(CowManagerConstants.EMPLOYEE_STATUS_OFF);
        existedProfile = employeeRepository.save(existedProfile);
        if (existedProfile != null) {
            return toEmployee(existedProfile);
        } else {
            throw new CowManagerException("Cannot save to db");
        }
    }

    public Employee getEmployeeProfile(Integer maNv) throws CowManagerException {
        if (maNv == null) {
            throw new CowManagerException("Ma nhan vien khong ton tai");
        }
        EmployeeEntity existedProfile = employeeRepository
                .findOneByColumn("maNv", maNv);
        if (existedProfile == null) {
            throw new CowManagerException("Ma nhan vien khong co trong db");
        } else {
            return toEmployee(existedProfile);
        }

    }

    //-------------------
    //    ROLE EMPLOYEE
    //-------------------

    /**
     * Register role
     * @param roleRequest
     * @return
     * @throws CowManagerException
     */
    @Transactional(rollbackOn = CowManagerException.class)
    public RoleEmployee registerRole(RoleRequest roleRequest) throws CowManagerException {
        RoleEmployeeEntity entity = new RoleEmployeeEntity();
        if(TextUtils.isEmpty(roleRequest.getTenQuyen())) {
            throw new CowManagerException("Ten quyen khong duoc trong");
        }
        entity.setDescription(roleRequest.getTenQuyen());
        entity = roleRepository.save(entity);
        return toRole(entity);
    }

    /**
     * Update role
     * @param roleRequest
     * @return
     * @throws CowManagerException
     */
    @Transactional(rollbackOn = CowManagerException.class)
    public RoleEmployee updateRole(RoleRequest roleRequest) throws CowManagerException {
        RoleEmployeeEntity entity = roleRepository.findOne(roleRequest.getMaQuyen());
        if (entity == null) {
            throw new CowManagerException("Ma quyen khong ton tai");
        }
        if(TextUtils.isEmpty(roleRequest.getTenQuyen())) {
            throw new CowManagerException("Ten quyen khong duoc trong");
        }
        entity.setDescription(roleRequest.getTenQuyen());
        entity = roleRepository.save(entity);
        return toRole(entity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public RoleEmployee deleteRole(RoleRequest roleRequest) throws CowManagerException {
        RoleEmployeeEntity entity = roleRepository.findOne(roleRequest.getMaQuyen());
        if (entity == null) {
            throw new CowManagerException("Ma quyen khong ton tai");
        }
        roleRepository.delete(entity);
        return toRole(entity);
    }

    public List<RoleEmployee> listRole() throws CowManagerException {
        List<RoleEmployeeEntity> entities = roleRepository.findAll();
        return convertToListRole(entities);
    }


}
