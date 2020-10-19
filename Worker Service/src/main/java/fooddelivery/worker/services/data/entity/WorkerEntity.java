package fooddelivery.worker.services.data.entity;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "WORKER")
public class WorkerEntity
{
    public WorkerEntity(String name, String tel, String email, String TAZ, Integer position, Float salary) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.TAZ = TAZ;
        this.position = position;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private long innerID;

    @Column(name = "NAME")
    private String name;




    @Column(name = "TEL")
    private String tel;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "WORKER_START_DATE")
    private Date workerStartDate;

    public long getInnerID() {
        return innerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getWorkerStartDate() {
        return workerStartDate;
    }

    public void setWorkerStartDate(Date workerStartDate) {
        this.workerStartDate = workerStartDate;
    }

    public Date getWorkerEndDate() {
        return workerEndDate;
    }

    public void setWorkerEndDate(Date workerEndDate) {
        this.workerEndDate = workerEndDate;
    }

    public String getTAZ() {
        return TAZ;
    }

    public void setTAZ(String TAZ) {
        this.TAZ = TAZ;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Boolean getWorkingRightNow() {
        return WorkingRightNow;
    }

    public void setWorkingRightNow(Boolean workingRightNow) {
        WorkingRightNow = workingRightNow;
    }

    @Column(name = "WORKER_END_DATA")
    private Date workerEndDate;

    @Column(name = "TAZ")
    private String TAZ;

    @Column(name = "POSITION")
    private Integer position;

    @Column(name = "SALARY")
    private Float salary;

    @Column(name = "WORKING_RIGHT_NOW")
    private Boolean WorkingRightNow;

    public WorkerEntity() {

    }
}
