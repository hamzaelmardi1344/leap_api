package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.DocumentaireVFRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ProgrammeService implements IProgrammeService {

    @Autowired
    private ProgrammeRepository ProgrammeRepository;

    @Autowired
    private DocumentaireVFRepository documentaireVFRepository;

    @Override
    public Collection<Programme> getAllProgrammes() {
        Collection<Programme> list = new ArrayList<>();
        ProgrammeRepository.findAll(Sort.by(Sort.Direction.DESC,"id")).forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Programme getProgrammeById(Long ProgrammeId) {
        Programme Programme = ProgrammeRepository.findById(ProgrammeId).get();
        return Programme;
    }

    @Override
    public Programme addProgramme(Programme Programme) {
        return ProgrammeRepository.save(Programme);
    }

    @Override
    public void updateProgramme(Programme Programme) {
        ProgrammeRepository.save(Programme);
    }

    @Override
    public void deleteProgramme(Long ProgrammeId) {
        ProgrammeRepository.delete(getProgrammeById(ProgrammeId));
    }

    @Override
    public Collection<Attribut> getListAttributeByProgramme(Long id) {

        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getAttributs();
    }

    @Override
    public Collection<AttributProgramme> getListAttributeProgrammeByProgramme(Long id) {
        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getAttributProgrammes().stream().sorted(Comparator.comparing((a) -> a.getAttribut().getId())).collect(Collectors.toList());
    }

    @Override
    public Collection<Projet> getListProjetByProgramme(Long id) {
        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getProjets();
    }

    @Override
    public Collection<Risque> getListRisqueByProgramme(Long id) {
        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getRisques();
    }

    @Override
    public Collection<Action> getListActionByProgramme(Long id) {

        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getActions();
    }

    @Override
    public Collection<DocumentaireVF> getListDocByProgramme(Long id) {

        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getDocumentaireVFS();
    }

    public boolean addDocToProgramme(DocumentaireVF DocumentaireVF, Long id) {
        Programme programme = ProgrammeRepository.findById(id).get();
        System.err.println(programme.getId());
        DocumentaireVF.setProgramme(programme);
        System.err.println(DocumentaireVF.getProgramme());
        DocumentaireVF DocumentaireVF1 = documentaireVFRepository.save(DocumentaireVF);

        Collection<DocumentaireVF> DocumentaireVFs = programme.getDocumentaireVFS();

        return DocumentaireVFs.add(DocumentaireVF1);
    }

    @Override
    public Collection<Programme> findProgByPublicAccess() {

        Collection<Programme> programmes = ProgrammeRepository.findAll();

        return programmes.stream().filter( p -> !p.getProgrammePrive()).collect(Collectors.toList());
    }

    @Override
    public Collection<FichierJoint> getFichierJointByProgramme(Long id) {

        Programme programme = ProgrammeRepository.findById(id).get();
        return programme.getFichierJoints();
    }


}
