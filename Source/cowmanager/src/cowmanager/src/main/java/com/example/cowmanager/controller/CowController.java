package com.example.cowmanager.controller;

import com.example.cowmanager.model.*;
import com.example.cowmanager.service.CowService;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = IWebPath.COW_PATH)
public class CowController {

    /**
     * {@link CowService}.
     */
    @Autowired
    private CowService cowService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RespData<List<Cow>> getListCow() {
        final RespData<List<Cow>> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getListCow());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/listByMaNv", method = RequestMethod.POST)
    public RespData<List<Cow>> getListCowByMaNv(@RequestBody CowRequest req) {
        final RespData<List<Cow>> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getListCow(req));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespData<Cow> addCow(@RequestBody CowRequest request) {
        final RespData<Cow> resp = new RespData<Cow>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.addCowProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RespData<Cow> updateEmployee(@RequestBody CowRequest request) {
        final RespData<Cow> resp = new RespData<Cow>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.updateCowProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public RespData<Cow> releaseEmployee(@RequestBody CowRequest request) {
        final RespData<Cow> resp = new RespData<Cow>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.removeCowProfile(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getMilk", method = RequestMethod.POST)
    @ResponseBody
    public RespData<MilkGetting> getMilk(@RequestBody CowRequest request) {
        final RespData<MilkGetting> resp = new RespData<MilkGetting>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getMilk(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/checkHealth", method = RequestMethod.POST)
    public RespData<CowLog> checkHealth(@RequestBody CowRequest request) {
        final RespData<CowLog> resp = new RespData<CowLog>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.checkHealth(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getListCowByHealth", method = RequestMethod.POST)
    public RespData<List<CowLog>> getListCowByHealth(@RequestBody CowRequest request) {
        final RespData<List<CowLog>> resp = new RespData<List<CowLog>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getListCowByHealth(request));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/reportMilkToday", method = RequestMethod.GET)
    public RespData<List<MilkGetting>> getReportMilkToday() {
        final RespData<List<MilkGetting>> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getListMilkGettingToday());
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/reportMilkTimeRange", method = RequestMethod.GET)
    public RespData<List<MilkGetting>> getReportMilkToday(
            @RequestParam(name = "startDate", required = false) Long startDate,
            @RequestParam(name = "endDate", required = false) Long endDate) {
        final RespData<List<MilkGetting>> resp = new RespData<List<MilkGetting>>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            Timestamp startTime = null;
            Timestamp endTime = null;
            // Convert date to timestamp (seconds to miliseconds)
            if (startDate != null) {
                startTime = new Timestamp(startDate * 1000);
            }
            if (endDate != null) {
                endTime = new Timestamp(endDate * 1000);
            }
            resp.setData(cowService.getListMilkTimeRange(startTime, endTime));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/checkHealthAllCow", method = RequestMethod.POST)
    public RespData<Integer> getListCowByHealth() {
        final RespData<Integer> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            cowService.checkHealthAllCow();
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }

    @RequestMapping(value = "/getMilkAllCow", method = RequestMethod.POST)
    public RespData<List<MilkGetting>> getMilkAllCow(CowRequest request) {
        final RespData<List<MilkGetting>> resp = new RespData<>();
        resp.setResult(CowManagerConstants.COW_MANAGER_SUCCESS);
        try {
            resp.setData(cowService.getMilkAllCow(request.getMaNhanVien()));
        } catch (CowManagerException ex) {
            resp.setResult(CowManagerConstants.COW_MANAGER_FAIL);
            resp.setMessage(ex.getMessage());
        }
        return resp;
    }
}
