package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Log;
import ma.gfi.leap.api.LEAPAPI.core.services.ILogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class LogController {

    @Autowired
    private ILogService LogService;



    //Fetches Log by id
    @GetMapping(value= "/log/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Log> getLogById(@PathVariable("id") Long id) {
        Log ob = new Log();
        BeanUtils.copyProperties(LogService.getLogById(id), ob);
        return new ResponseEntity<Log>(ob, HttpStatus.OK);
    }



    //Fetches all Logs
    @GetMapping(value= "/log/listLog", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Log>> getAllLogs() {
        Collection<Log> LogList = LogService.getAllLogs();

        return new ResponseEntity<>(LogList, HttpStatus.OK);
    }

    //Creates a new Log
    @PostMapping(value= "/log/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Log addLog(@RequestBody Log Log, UriComponentsBuilder builder) {
        Log Log1 = LogService.addLog(Log);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Log/{id}").buildAndExpand(Log1.getId()).toUri());
        return Log1;
    }


  /*  //Updates evenmement
    @PutMapping("/Log/edit/{id}")
    public ResponseEntity<Log> updateLog(@PathVariable(value = "id") Long LogId,
                                                 @Valid @RequestBody Log LogDetails) throws Exception{
        Log Log = LogService.getLogById(LogId);

        Log.setValeur(LogDetails.getValeur());


        final Log updatedLog = LogService.addLog(Log);
        return ResponseEntity.ok(updatedLog);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/log/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteLog(@PathVariable("id") Long id) {
        LogService.deleteLog(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }







    @GetMapping(value = "/log/getByDate/{dateDebut}/{dateFin}")
    public ResponseEntity<Collection<Log>> getListLogByDateDebutAndDateFin(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,@PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin )
    {
        Collection<Log> logs = LogService.getByDate(dateDebut,dateFin);
        return  new ResponseEntity<Collection<Log>>(logs,HttpStatus.OK);
    }

}
