package fooddelivery.worker.services.controllers;


import fooddelivery.worker.services.business.helper.GSonFactory;
import fooddelivery.worker.services.business.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkerController {



    final WorkerService workerService;
    final GSonFactory gSonFactory;

    @Autowired
    public WorkerController(WorkerService workerService,GSonFactory gSonFactory){
        this.workerService=workerService;
        this.gSonFactory=gSonFactory;
    }


    @PostMapping("/updateWorker")
    public String updateWorker(
            @RequestParam(value="data")String data){
        return this.workerService.updateWorker(data);
    }


    @RequestMapping("/checkIfWorkerExcises")
    public boolean checkIfWorkerExcises(@RequestParam(value="taz")String taz){
        return this.workerService.checkIfWorkerExists(taz);
    }

    @RequestMapping("/")
    public String defaults(){
        return "hi this is worker module";
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
