package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Log;

import java.util.Collection;
import java.util.Date;

public interface ILogService {

    Collection<Log> getAllLogs();
    Log getLogById(Long LogId);
    Log addLog(Log Log);
    void updateLog(Log Log);
    void deleteLog(Long LogId);
    Collection<Log> getByDate(Date dateDebut,Date dateFin);
}
