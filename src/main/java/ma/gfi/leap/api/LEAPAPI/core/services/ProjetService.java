package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.DocumentaireVFRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ProjetService implements IProjetService {

    @Autowired
    private ProjetRepository ProjetRepository;

    @Autowired
    private DocumentaireVFRepository documentaireVFRepository;

    @Override
    public Collection<Projet> getAllProjets() {
        Collection<Projet> list = new ArrayList<>();
        ProjetRepository.findAll(Sort.by(Sort.Direction.DESC,"id")).forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Projet getProjetById(Long ProjetId) {
        Projet Projet = ProjetRepository.findById(ProjetId).get();
        return Projet;
    }

    @Override
    public Projet addProjet(Projet Projet) {
        return ProjetRepository.save(Projet);
    }

    @Override
    public void updateProjet(Projet Projet) {
        ProjetRepository.save(Projet);
    }

    @Override
    public void deleteProjet(Long ProjetId) {
        ProjetRepository.delete(getProjetById(ProjetId));
    }

    @Override
    public Collection<Projet> findByDateAndEtat(Date date, String etat) {
        return ProjetRepository.findAllByDateFinAndEtat(date,etat);
    }

    @Override
    public Collection<AttributProgramme> getListAttributProgrammeByProjet(Long id) {

        Projet projet = ProjetRepository.findById(id).get() ;
        return projet.getAttributProgrammes();
    }

    @Override
    public Collection<AttributProjet> getListAttributProjetByProjet(Long id) {
        Projet projet = ProjetRepository.findById(id).get();
        return projet.getAttributProjets().stream().sorted(Comparator.comparing((a) -> a.getAttribut().getId())).collect(Collectors.toList());
        //return projet.getAttributProjets();
    }

    @Override
    public Collection<Action> getListActionByProjet(Long id) {
        Projet projet = ProjetRepository.findById(id).get() ;
        return projet.getActionProjets();
    }

    @Override
    public Collection<Action> getListActionByProjetAndAccess(Long id) {
        Projet projet = ProjetRepository.findById(id).get() ;
        return projet.getActionProjets().stream().filter(a -> !a.getActionPrive()).collect(Collectors.toList());
    }

    @Override
    public Collection<Risque> getListRisqueByProjet(Long id) {
        Projet projet = ProjetRepository.findById(id).get() ;
        return projet.getRisques();
    }

    @Override
    public Collection<RevisionProjet> getListRevisionByProjet(Long id) {
        Projet projet = ProjetRepository.findById(id).get() ;
        return projet.getRevisionProjets();
    }

    @Override
    public Collection<Projet> findProjByPublicAccess() {

        Collection<Projet> projets = ProjetRepository.findAll();

        return projets.stream().filter( p -> !p.getProjetPrive()).collect(Collectors.toList());
    }



    @Override
    public Collection<DocumentaireVF> getListDocByProjet(Long id) {

        Projet projet = ProjetRepository.findById(id).get();
        return projet.getDocumentaireVFS();
    }

    public boolean addDocToProjet(DocumentaireVF DocumentaireVF, Long id) {
        Projet projet = ProjetRepository.findById(id).get();
        System.err.println(projet.getId());
        DocumentaireVF.setProjet(projet);
        System.err.println(DocumentaireVF.getProjet());
        DocumentaireVF DocumentaireVF1 = documentaireVFRepository.save(DocumentaireVF);

        Collection<DocumentaireVF> DocumentaireVFs = projet.getDocumentaireVFS();

        return DocumentaireVFs.add(DocumentaireVF1);
    }



    @Override
    public Collection<FichierJoint> getFichierJointByProjet(Long id) {

        Projet projet = ProjetRepository.findById(id).get();
        return projet.getFichierJoints();
    }

    @Override
    public Collection<Indicateur> getIndicateurByProjet(Long id) {
        Projet projet = ProjetRepository.findById(id).get();
        return projet.getIndicateurs();
    }


}
