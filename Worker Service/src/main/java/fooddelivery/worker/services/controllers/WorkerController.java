package fooddelivery.worker.services.controllers;

import fooddelivery.worker.services.acsessdatemysql.WorkerRepository;
import fooddelivery.worker.services.restservice.WorkerShiftEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @RequestMapping("/updateWorker")
    public String updateWorker(){
        return "got 222 hello world";
    }

    @RequestMapping("/checkIfWorkerExcises")
    public String checkIfWorkerExcises(){
        return "got 222 hello world";
    }

    @RequestMapping("/checkIfWorkerExcises")
    public String checkIfW2orkerExcises(){
        return "got 222 hello world";
    }

}
