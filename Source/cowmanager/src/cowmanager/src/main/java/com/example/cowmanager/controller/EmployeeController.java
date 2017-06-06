package com.example.cowmanager.controller;

import com.example.cowmanager.model.CowManagerException;
import com.example.cowmanager.model.Employee;
import com.example.cowmanager.model.EmployeeRequest;
import com.example.cowmanager.model.RespData;
import com.example.cowmanager.service.EmployeeService;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = IWebPath.EMPLOYEE_PATH)
public class EmployeeController {
    /**
     * {@link EmployeeService}.
     */
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public RespData<List<Employee>> getListEmployee() {
        final RespData<List<Employee>> resp = new RespData<List<Employee>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.getAllEmployee());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public RespData<Employee> addEmployee(@RequestBody EmployeeRequest request) {
        final RespData<Employee> resp = new RespData<Employee>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.addEmployeeProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public RespData<Employee> addEmployee(@RequestParam(name = "maNv") Integer maNv) {
        final RespData<Employee> resp = new RespData<Employee>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.getEmployeeProfile(maNv));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RespData<Employee> updateEmployee(@RequestBody EmployeeRequest request) {
        final RespData<Employee> resp = new RespData<Employee>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.updateEmployeeProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    @ResponseBody
    public RespData<Employee> releaseEmployee(@RequestBody EmployeeRequest request) {
        final RespData<Employee> resp = new RespData<Employee>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(employeeService.releaseEmployeeProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

}
