package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;

import java.util.Collection;
import java.util.Date;

public interface IProjetService {

    Collection<Projet> getAllProjets();
    Projet getProjetById(Long ProjetId);
    Projet addProjet(Projet Projet);
    void updateProjet(Projet Projet);
    void deleteProjet(Long ProjetId);

    Collection<Projet> findByDateAndEtat(Date date, String etat);
    Collection<AttributProgramme> getListAttributProgrammeByProjet(Long id);
    Collection<AttributProjet> getListAttributProjetByProjet(Long id);
    Collection<Projet> findProjByPublicAccess();

    Collection<Action> getListActionByProjet(Long id);
    Collection<Action> getListActionByProjetAndAccess(Long id);
    Collection<Risque> getListRisqueByProjet(Long id);
    Collection<RevisionProjet> getListRevisionByProjet(Long id);

    Collection<DocumentaireVF> getListDocByProjet(Long id);
    boolean addDocToProjet(DocumentaireVF documentaireVF,Long id);

    Collection<FichierJoint> getFichierJointByProjet(Long id);

    Collection<Indicateur> getIndicateurByProjet(Long id);





}
