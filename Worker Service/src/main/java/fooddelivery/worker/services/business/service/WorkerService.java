package fooddelivery.worker.services.business.service;


import fooddelivery.worker.services.business.helper.GSonFactory;
import fooddelivery.worker.services.data.entity.WorkerEntity;
import fooddelivery.worker.services.data.reposotory.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;

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

    private WorkerEntity makeWorkerEntityFromJsonString(String worker){
        WorkerEntity workerEntity=  (WorkerEntity) this.gSonFactory.generateWorkerObjectFromJsonString(worker);
        return workerEntity;
    }


    public boolean updateWorker(String workerString) {
        WorkerEntity worker = makeWorkerEntityFromJsonString(workerString);
        updateWorkerInDB(worker);
        WorkerEntity updatedWorker=getWorker(worker.getTAZ());
        return updatedWorker!= null;

    }

    public Iterable<WorkerEntity> getAllWorkers() {
        return workerRepository.findAll();
    }

    public String checkIfWorkerExists(String taz) {
        WorkerEntity workerEntity=getWorker(taz);
        if(workerEntity != null)
            return gSonFactory.generateGsonFromObject(new answer(0,workerEntity));

        return gSonFactory.generateGsonFromObject(new answer(1,false));
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

    public ArrayList<String> test(){
        Field[] fields = WorkerEntity.class.getDeclaredFields();
        ArrayList<String> names= new ArrayList<String>();
        for(Field f : fields){
            Class t = f.getType();
            names.add(f.getName());
        }
        return names;
    }
}
class answer {
    public Integer code;
    public Object data;

    public answer(int i, Object data) {
        this.code=i;
        this.data=data;
    }
}
