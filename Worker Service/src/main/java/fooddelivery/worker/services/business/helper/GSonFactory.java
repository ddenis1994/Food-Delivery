package fooddelivery.worker.services.business.helper;

import com.google.gson.Gson;
import fooddelivery.worker.services.data.entity.WorkerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GSonFactory {

    final private Gson json;
    @Autowired()
    public GSonFactory(){
        this.json=new Gson();
    }

    public Object generateWorkerObjectFromJsonString(String data){
        return this.json.fromJson(data, WorkerEntity.class);
    }

    public String generateGsonFromObject(Object target){
        return this.json.toJson(target);
    }


}
