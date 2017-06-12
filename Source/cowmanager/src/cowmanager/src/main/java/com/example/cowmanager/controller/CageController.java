package com.example.cowmanager.controller;

import com.example.cowmanager.model.*;
import com.example.cowmanager.service.CageService;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = IWebPath.CAGE_PATH)
public class CageController {

    /**
     * {@link CageService}.
     */
    @Autowired
    private CageService cageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RespData<List<Cage>> getListCage() {
        final RespData<List<Cage>> resp = new RespData<List<Cage>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.getAllCase());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getCause().getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespData<Cage> addCage(@RequestBody CageRequest request) {
        final RespData<Cage> resp = new RespData<Cage>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.createCage(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RespData<Cage> updateCage(@RequestBody CageRequest request) {
        final RespData<Cage> resp = new RespData<Cage>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.updateCage(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public RespData<Cage> releaseCage(@RequestBody CageRequest request) {
        final RespData<Cage> resp = new RespData<Cage>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.releaseCage(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public RespData<Cage> getCage(@RequestParam(name = "maChuong") Integer maChuong) {
        final RespData<Cage> resp = new RespData<Cage>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.getById(maChuong));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getCalendarCleaningToday", method = RequestMethod.GET)
    public RespData<List<CageLog>> getCleaningToday() {
        final RespData<List<CageLog>> resp = new RespData<List<CageLog>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cageService.calendarCleaningToday());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
}
