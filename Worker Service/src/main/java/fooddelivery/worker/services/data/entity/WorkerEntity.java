package fooddelivery.worker.services.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
