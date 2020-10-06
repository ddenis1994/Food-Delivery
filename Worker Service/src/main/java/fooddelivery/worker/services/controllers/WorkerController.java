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

    @RequestMapping("/")
    public String WorkerClockIn(){
        return "got 222 hello world";
    }

    @RequestMapping(path="/all")
    public @ResponseBody
    Iterable<WorkerShiftEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return workerRepository.findAll();
    }

}
