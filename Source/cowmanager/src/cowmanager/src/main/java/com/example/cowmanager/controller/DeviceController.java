package com.example.cowmanager.controller;

import com.example.cowmanager.model.CowManagerException;
import com.example.cowmanager.model.Device;
import com.example.cowmanager.model.DeviceRequest;
import com.example.cowmanager.model.RespData;
import com.example.cowmanager.service.DeviceService;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = IWebPath.DEVICE_PATH)
public class DeviceController {
    /**
     * {@link DeviceService}.
     */
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RespData<List<Device>> getListDevice() {
        final RespData<List<Device>> resp = new RespData<List<Device>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.getListDevice(null));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/listAvailable", method = RequestMethod.GET)
    public RespData<List<Device>> getListDeviceAvailable() {
        final RespData<List<Device>> resp = new RespData<List<Device>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.getListDeviceAvailable());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/listByCageId", method = RequestMethod.GET)
    public RespData<List<Device>> getListDeviceByCage(
            @RequestParam(name = "maChuong", required = false) Integer cageId) {
        final RespData<List<Device>> resp = new RespData<List<Device>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.getListDeviceByCage(cageId));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespData<Device> addDevice(@RequestBody DeviceRequest request) {
        final RespData<Device> resp = new RespData<Device>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.addDevice(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RespData<Device> updateEmployee(@RequestBody DeviceRequest request) {
        final RespData<Device> resp = new RespData<Device>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.updateDevice(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public RespData<Device> releaseEmployee(@RequestBody DeviceRequest request) {
        final RespData<Device> resp = new RespData<Device>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(deviceService.removeDevice(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

}
