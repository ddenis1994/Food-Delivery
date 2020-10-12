package fooddelivery.worker.services.data.reposotory;

import fooddelivery.worker.services.data.entity.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity,Long> {

    WorkerEntity findWorkerEntityByTAZ(String taz);

}
