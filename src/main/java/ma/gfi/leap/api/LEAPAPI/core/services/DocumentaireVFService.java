package ma.gfi.leap.api.LEAPAPI.core.services;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.DocumentaireVFRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.FichierJointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class DocumentaireVFService implements IDocumentaireVFService {

    @Autowired
    private DocumentaireVFRepository DocumentaireVFRepository;

    @Autowired
    private FichierJointRepository fichierJointRepository;

    @Override
    public Collection<DocumentaireVF> getAllDocumentaireVFs() {
        Collection<DocumentaireVF> list = new ArrayList<>();
        DocumentaireVFRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public DocumentaireVF getDocumentaireVFById(Long DocumentaireVFId) {
        DocumentaireVF DocumentaireVF = DocumentaireVFRepository.findById(DocumentaireVFId).get();
        return DocumentaireVF;
    }

    @Override
    public DocumentaireVF addDocumentaireVF(DocumentaireVF DocumentaireVF) {


        if(DocumentaireVF.getType().equals("Folder"))
        {
            try {

                Path path = Paths.get("/var/www/docs/"+DocumentaireVF.getChemin()+"/");

                Files.createDirectories(path);

                System.out.println("Directory is created!");


                //Files.createDirectory(path);

            } catch (IOException e) {
                System.err.println("Failed to create directory!" + e.getMessage());
            }
        }

        return DocumentaireVFRepository.save(DocumentaireVF);
    }

    @Override
    public void updateDocumentaireVF(DocumentaireVF DocumentaireVF) {
        DocumentaireVFRepository.save(DocumentaireVF);
    }

    @Override
    public void deleteDocumentaireVF(Long DocumentaireVFId) {
        DocumentaireVFRepository.delete(getDocumentaireVFById(DocumentaireVFId));
    }

    @Override
    public Collection<FichierJoint> getFileByDocumentID(Long id) {

        DocumentaireVF DocumentaireVF = DocumentaireVFRepository.findById(id).get();
        return DocumentaireVF.getFichierJoints();
    }

    @Override
    public Collection<DocumentaireVF> getChildByDocumentParentID(Long id) {
        DocumentaireVF documentaireVF = DocumentaireVFRepository.findById(id).get();
        return documentaireVF.getChildren();
    }

    @Override
    public boolean addDocChildren(DocumentaireVF DocumentaireVF, Long id) {
        DocumentaireVF doc = DocumentaireVFRepository.findById(id).get();
        System.err.println(doc.getId());
        DocumentaireVF.setDocumentaireVF(doc);
        System.err.println(DocumentaireVF.getDocumentaireVF());
        DocumentaireVF DocumentaireVF1 = DocumentaireVFRepository.save(DocumentaireVF);

        Collection<DocumentaireVF> DocumentaireVFs = doc.getChildren();

        return DocumentaireVFs.add(DocumentaireVF1);
    }

    @Override
    public Collection<DocumentaireVF> getDocListByParentId() {
        Collection<DocumentaireVF> documentaires = DocumentaireVFRepository.findAllByIdParent();
        return documentaires;
    }

    @Override
    public Collection<DocumentaireVF> getByNiveau(String niveau) {

        Collection<DocumentaireVF> documentaireVFS = DocumentaireVFRepository.findAllByNiveau(niveau);
        return documentaireVFS.stream().filter(d -> d.getType().equals("Folder")).collect(Collectors.toList());
    }

    @Override
    public Collection<DocumentaireVF> getByNiveauAndIdParent(String niveau, Long id) {

        return DocumentaireVFRepository.findAllByNiveauAndIdParent(niveau,id);
    }

    @Override
    public DocumentaireVF getDocByLabel(String label) {
        return DocumentaireVFRepository.findByLabel(label);
    }

    @Override
    public Collection<DocumentaireVF> getAllDocumentaireVFFiles() {
        Collection<DocumentaireVF> list = new ArrayList<>();
        DocumentaireVFRepository.findAll().forEach(e -> list.add(e));
        return list.stream().filter(d -> d.getType().equals("File")).collect(Collectors.toList());
    }

    @Override
    public boolean addFileToDoc(FichierJoint fichierJoint, Long id) {
        DocumentaireVF doc = DocumentaireVFRepository.findById(id).get();
        System.err.println(doc.getId());
        fichierJoint.setDocumentaireVF(doc);
        System.err.println(fichierJoint.getDocumentaireVF());
        FichierJoint fichierJoint1 = fichierJointRepository.save(fichierJoint);

        Collection<FichierJoint> fichierJoints = doc.getFichierJoints();

        return fichierJoints.add(fichierJoint1);
    }
}
