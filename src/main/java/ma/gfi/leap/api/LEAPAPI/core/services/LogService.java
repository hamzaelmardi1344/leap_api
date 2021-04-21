package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Log;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class LogService implements ILogService {

    @Autowired
    private LogRepository LogRepository;

    @Override
    public Collection<Log> getAllLogs() {
        Collection<Log> list = new ArrayList<>();
        LogRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Log getLogById(Long LogId) {
        Log Log = LogRepository.findById(LogId).get();
        return Log;
    }

    @Override
    public Log addLog(Log Log) {
        return LogRepository.save(Log);
    }

    @Override
    public void updateLog(Log Log) {
        LogRepository.save(Log);
    }

    @Override
    public void deleteLog(Long LogId) {
        LogRepository.delete(getLogById(LogId));
    }

    @Override
    public Collection<Log> getByDate(Date dateDebut, Date dateFin) {
        return LogRepository.findAllByDate(dateDebut,dateFin);
    }
}
