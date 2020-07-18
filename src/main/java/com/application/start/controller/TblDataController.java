package com.application.start.controller;

import com.application.start.entity.TblData;
import com.application.start.service.TblDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TblDataController {
    @Autowired
    private TblDataService tblDataService;
    @GetMapping("/data")
    @CrossOrigin(value = "http://localhost:4200")
    public List<TblData> getAllRecords(){
        return tblDataService.getAllRecords();
    }
    @GetMapping("/data/{page}/{n}")
    @CrossOrigin(value = "http://localhost:4200")
    public List<TblData> getNRecords(@PathVariable int page,@PathVariable int n){
        return tblDataService.getNRecords(page,n);
    }
    @GetMapping("/data/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    public TblData getRecordById(@PathVariable int id) {
        return tblDataService.getRecordById(id);
    }
    @PutMapping("/data/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    public TblData updateRecordById(@PathVariable int id, @RequestBody TblData tblData) {
        return tblDataService.updateRecordById(id,tblData);
    }
    @PostMapping("/data")
    @CrossOrigin(value = "http://localhost:4200")
    public TblData createRecord(@RequestBody TblData tblData) {
        return tblDataService.createRecord(tblData);
    }
    @DeleteMapping("/data/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    public String deleteRecord(@PathVariable int id) {
        return tblDataService.deleteRecord(id);
    }
    @GetMapping("/data/StartDate/{startDate}/EndDate/{endDate}")
    @CrossOrigin(value = "http://localhost:4200")
    public List<TblData> getRecordsBetween(@PathVariable String startDate,@PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return tblDataService.getRecordsBetween(LocalDate.parse(startDate,formatter),LocalDate.parse(endDate,formatter));
    }
    @GetMapping("/data/sortByCity")
    @CrossOrigin(value = "http://localhost:4200")
    public List<TblData> sortByCity(){
        return tblDataService.sortByCity();
    }
    @GetMapping("/data/sortByCityDes")
    @CrossOrigin(value = "http://localhost:4200")
    public List<TblData> sortByCityDes(){
        return tblDataService.sortByCityDes();
    }
}
