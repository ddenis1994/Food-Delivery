package fooddelivery.worker.services.business.service;


import fooddelivery.worker.services.data.entity.WorkerEntity;
import fooddelivery.worker.services.data.reposotory.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository=workerRepository;
    }
    private final WorkerRepository workerRepository;


    public WorkerEntity getWorker(String taz){
        WorkerEntity worker=this.workerRepository.findWorkerEntityByTAZ(taz);
        return worker;
    }


    public Boolean updateWorker(WorkerEntity updatedWorker) {
        workerRepository.save(updatedWorker);

        return Boolean.TRUE;
    }

    public Iterable<WorkerEntity> getAllWorkers() {
        return workerRepository.findAll();
    }
}
