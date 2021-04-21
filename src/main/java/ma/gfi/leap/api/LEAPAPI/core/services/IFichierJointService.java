package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;

import java.util.Collection;

public interface IFichierJointService {

    Collection<FichierJoint> getAllFichierJoints();
    FichierJoint getFichierJointById(Long FichierJointId);
    FichierJoint addFichierJoint(FichierJoint FichierJoint);
    void updateFichierJoint(FichierJoint FichierJoint);
    void deleteFichierJoint(Long FichierJointId);

}
