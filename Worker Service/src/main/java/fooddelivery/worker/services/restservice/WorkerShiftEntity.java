package fooddelivery.worker.services.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class WorkerShiftEntity {


    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long workerInnerId;

    private String workerId;

    private Date shiftDate;

    public Long getWorkerInnerId() {
        return workerInnerId;
    }

    public void setWorkerInnerId(Long workerInnerId) {
        this.workerInnerId = workerInnerId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public Time getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(Time shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public Time getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(Time shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    private Time shiftStartTime;

    private Time shiftEndTime;


}
