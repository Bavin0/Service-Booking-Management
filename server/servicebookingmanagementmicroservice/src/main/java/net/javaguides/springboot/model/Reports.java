package net.javaguides.springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "service_req_id")
    private String serviceReqId;

    @Column(name = "report_date")
    private String reportDate;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "action_taken")
    private String actionTaken;

    @Column(name = "diagnosis_details")
    private String diagnosisDetails;
    @Column(name = "is_paid")
    private String isPaid;
    @Column(name = "visit_fees")
    private String visitFees;
    @Column(name = "repair_details")
    private String repairDetails;



    public Reports() {

    }

    public Reports(String serviceReqId, String reportDate, String serviceType, String actionTaken, String diagnosisDetails,String isPaid, String visitFees, String repairDetails) {
        super();
        this.serviceReqId = serviceReqId;
        this.reportDate = reportDate;
        this.serviceType = serviceType;
        this.actionTaken = actionTaken;
        this.diagnosisDetails = diagnosisDetails;
        this.isPaid = isPaid;
        this.visitFees = visitFees;
        this.repairDetails = repairDetails;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getServiceReqId() {
        return serviceReqId;
    }
    public void setServiceReqId(String serviceReqId) {
        this.serviceReqId = serviceReqId;
    }
    public String getReportDate() {
        return reportDate;
    }
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getActionTaken() {
        return actionTaken;
    }
    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }
    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }
    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }
    public String getIsPaid() {
        return isPaid;
    }
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
    public String getVisitFees() {
        return visitFees;
    }
    public void setVisitFees(String visitFees) {
        this.visitFees = visitFees;
    }
    public String getRepairDetails() {
        return repairDetails;
    }
    public void setRepairDetails(String repairDetails) {
        this.repairDetails = repairDetails;
    }
}
