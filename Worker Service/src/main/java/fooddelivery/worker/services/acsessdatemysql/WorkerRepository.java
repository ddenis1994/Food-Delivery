package fooddelivery.worker.services.acsessdatemysql;

import fooddelivery.worker.services.restservice.WorkerShiftEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<WorkerShiftEntity,Long> {
}
