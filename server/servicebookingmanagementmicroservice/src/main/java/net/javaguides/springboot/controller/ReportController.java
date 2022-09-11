package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Reports;
import net.javaguides.springboot.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Services;
import net.javaguides.springboot.repository.ServiceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reports")
    public List<Reports> getReports(){
        return reportRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/reports")
    public Reports addReport(@RequestBody Reports reports) {
        return reportRepository.save(reports);
    }

    // update employee rest api

    @PutMapping("/reports/{id}")
    public ResponseEntity<Reports> updateReport(@PathVariable Long id, @RequestBody Reports reportDetails){
        Reports reports = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        reports.setServiceReqId(reportDetails.getServiceReqId());
        reports.setReportDate(reportDetails.getReportDate());
        reports.setServiceType(reportDetails.getServiceType());
        reports.setActionTaken(reportDetails.getActionTaken());
        reports.setDiagnosisDetails(reportDetails.getDiagnosisDetails());
        reports.setIsPaid(reportDetails.getIsPaid());
        reports.setVisitFees(reportDetails.getVisitFees());
        reports.setRepairDetails(reportDetails.getRepairDetails());

        Reports updatedReport= reportRepository.save(reports);
        return ResponseEntity.ok(updatedReport);
    }


    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReport(@PathVariable Long id){
        Reports reports = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        reportRepository.delete(reports);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
