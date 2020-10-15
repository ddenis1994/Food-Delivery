package fooddelivery.worker.services.controllers;


import fooddelivery.worker.services.business.helper.GSonFactory;
import fooddelivery.worker.services.business.service.WorkerService;
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
    public boolean updateWorker(
            @RequestParam(value="data")String data){

         this.workerService.updateWorker(data);
         return true;
    }


    @RequestMapping("/checkIfWorkerExcises")
    public boolean checkIfWorkerExcises(@RequestParam(value="taz")String taz){
        return this.workerService.checkIfWorkerExists(taz);
    }

    @RequestMapping("/")
    public String defaults(){
        return "hi this is worker module\n" +
                "my api is : \n" +
                "for updating/create worker /updateWorker with param data:json \n" +
                "for check if worker is active /checkIfWorkerIsActive with param taz:string\n" +
                "for check if worker Excises /checkIfWorkerExcises with param taz:string\n" +
                "for getting worker /getWorker with param taz:string (not require}\n";
    }

    @RequestMapping("/checkIfWorkerIsActive")
    public Boolean checkIfWorkerIsActive(@RequestParam(value="taz")String taz){
         return this.workerService.checkIfWorkerIsActive(taz);
    }

    @GetMapping("/getWorker")
    public @ResponseBody String getWorker(
            @RequestParam(value="taz", required = false)String taz
            ){
        return this.workerService.getWorkerString(taz);

    }

}
