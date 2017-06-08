package com.example.cowmanager.controller;

import com.example.cowmanager.model.CowManagerException;
import com.example.cowmanager.model.RespData;
import com.example.cowmanager.model.RoleEmployee;
import com.example.cowmanager.model.RoleRequest;
import com.example.cowmanager.service.EmployeeService;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DebugController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    @ResponseBody
    public RespData<RoleEmployee> addRoleEmployee(@RequestBody RoleRequest roleRequest) {
        final RespData<RoleEmployee> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.registerRole(roleRequest));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public RespData<RoleEmployee> updateRoleEmployee(@RequestBody RoleRequest roleRequest) {
        final RespData<RoleEmployee> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.updateRole(roleRequest));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/role/release", method = RequestMethod.POST)
    @ResponseBody
    public RespData<RoleEmployee> deleteRoleEmployee(@RequestBody RoleRequest roleRequest) {
        final RespData<RoleEmployee> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.deleteRole(roleRequest));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    @ResponseBody
    public RespData<List<RoleEmployee>> listRoleEmployee() {
        final RespData<List<RoleEmployee>> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.listRole());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

}
