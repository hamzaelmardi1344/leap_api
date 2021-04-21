package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.FichierJointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FichierJointService implements IFichierJointService {

    @Autowired
    private FichierJointRepository FichierJointRepository;

    @Override
    public Collection<FichierJoint> getAllFichierJoints() {
        Collection<FichierJoint> list = new ArrayList<>();
        FichierJointRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public FichierJoint getFichierJointById(Long FichierJointId) {
        FichierJoint FichierJoint = FichierJointRepository.findById(FichierJointId).get();
        return FichierJoint;
    }

    @Override
    public FichierJoint addFichierJoint(FichierJoint FichierJoint) {
        return FichierJointRepository.save(FichierJoint);
    }

    @Override
    public void updateFichierJoint(FichierJoint FichierJoint) {
        FichierJointRepository.save(FichierJoint);
    }

    @Override
    public void deleteFichierJoint(Long FichierJointId) {
        FichierJointRepository.delete(getFichierJointById(FichierJointId));
    }

}
