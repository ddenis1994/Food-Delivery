package fooddelivery.worker.services.business.service;


import fooddelivery.worker.services.business.helper.GSonFactory;
import fooddelivery.worker.services.data.entity.WorkerEntity;
import fooddelivery.worker.services.data.reposotory.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    public WorkerService(WorkerRepository workerRepository,GSonFactory gSonFactory){

        this.workerRepository=workerRepository;
        this.gSonFactory=gSonFactory;
    }

    private final WorkerRepository workerRepository;

    private final GSonFactory gSonFactory;


    public WorkerEntity getWorker(String taz){

        return this.workerRepository.findWorkerEntityByTAZ(taz);
    }

    private void updateWorkerInDB(WorkerEntity workerEntity){
        workerRepository.save(workerEntity);
    }

    private String generateJsonObjectFromWorkerEntity(WorkerEntity workerEntity){
        return this.gSonFactory.generateGsonFromObject(workerEntity);
    }

    private String makeWorkerEntityFromJsonString(String worker){
        WorkerEntity workerEntity=  (WorkerEntity) this.gSonFactory.generateWorkerObjectFromJsonString(worker);
        updateWorkerInDB(workerEntity);
        return workerEntity.getTAZ();
    }


    public String updateWorker(String worker) {
        String taz = makeWorkerEntityFromJsonString(worker);
        WorkerEntity updatedWorker=getWorker(taz);
        return generateJsonObjectFromWorkerEntity(updatedWorker);
    }

    public Iterable<WorkerEntity> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Boolean checkIfWorkerExists(String taz) {
        WorkerEntity workerEntity=getWorker(taz);
        return workerEntity != null;
    }

    public Boolean checkIfWorkerIsActive(String taz) {
        WorkerEntity workerEntity=getWorker(taz);
        return workerEntity.getWorkingRightNow();
    }


    private String getWorkerWithNullTazOrEmptyTaz(){
        return this.gSonFactory.generateGsonFromObject(getAllWorkers());
    }
    private String getWorkerWithTaz(String taz){
        return this.gSonFactory.generateGsonFromObject(getWorker(taz));
    }

    public String getWorkerString(String taz) {
        if (taz==null || taz.isEmpty())
            return getWorkerWithNullTazOrEmptyTaz();
        else return getWorkerWithTaz(taz);
    }
}
