package fooddelivery.worker.services.controllers;


import com.google.gson.Gson;
import fooddelivery.worker.services.business.service.WorkerService;
import fooddelivery.worker.services.data.entity.WorkerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkerController {



    final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService){
        this.workerService=workerService;
    }


    @PostMapping("/updateWorker")
    public String updateWorker(
            @RequestParam(value="taz", required = false)String taz,
            @RequestParam(value="name", required = false)String name,
            @RequestParam(value="tel", required = false)String tel,
            @RequestParam(value="email", required = false)String email,
            @RequestParam(value="position", required = false)Integer position,
            @RequestParam(value="salary", required = false)Float salary){
        WorkerEntity updatedWorker=new WorkerEntity(
               name,
                tel,
                email,
                taz,
                position,
                salary

        );
        workerService.updateWorker(updatedWorker);
        Gson gson=new Gson();


        return gson.toJson( this.workerService.getWorker(taz));

    }

    @RequestMapping("/checkIfWorkerExcises")
    public String checkIfWorkerExcises(){
        return "got 222 hello world";
    }

    @RequestMapping("/")
    public String defult(){
        return "got 222 hello world";
    }

    @RequestMapping("/checkIfWorkerIsActive")
    public String checkIfWorkerIsActive(){
        return "got 222 hello world";
    }

    @GetMapping("/getWorker")
    public @ResponseBody String getWorker(
            @RequestParam(value="taz", required = false)String taz
            ){
        Gson gson = new Gson();
        if (taz==null || taz.isEmpty()) return gson.toJson(this.workerService.getAllWorkers());
        else return gson.toJson( this.workerService.getWorker(taz));
    }

}
