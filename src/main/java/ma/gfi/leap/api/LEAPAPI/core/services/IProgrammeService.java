package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;

import java.util.Collection;

public interface IProgrammeService {

    Collection<Programme> getAllProgrammes();
    Programme getProgrammeById(Long ProgrammeId);
    Programme addProgramme(Programme Programme);
    void updateProgramme(Programme Programme);
    void deleteProgramme(Long ProgrammeId);
    
    Collection<Attribut> getListAttributeByProgramme(Long id);
    Collection<AttributProgramme> getListAttributeProgrammeByProgramme(Long id);
    Collection<Projet> getListProjetByProgramme(Long id);
    Collection<Risque> getListRisqueByProgramme(Long id);
    Collection<Action> getListActionByProgramme(Long id);
    Collection<Programme> findProgByPublicAccess();
    Collection<DocumentaireVF> getListDocByProgramme(Long id);
    boolean addDocToProgramme(DocumentaireVF documentaireVF,Long id);

    Collection<FichierJoint> getFichierJointByProgramme(Long id);



}
