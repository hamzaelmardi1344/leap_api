package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;

import java.util.Collection;

public interface IDocumentaireVFService {

    Collection<DocumentaireVF> getAllDocumentaireVFs();
    DocumentaireVF getDocumentaireVFById(Long DocumentaireVFId);
    DocumentaireVF addDocumentaireVF(DocumentaireVF DocumentaireVF);
    void updateDocumentaireVF(DocumentaireVF DocumentaireVF);
    void deleteDocumentaireVF(Long DocumentaireVFId);
    Collection<FichierJoint> getFileByDocumentID(Long id);
    Collection<DocumentaireVF> getChildByDocumentParentID(Long id);
    boolean addDocChildren(DocumentaireVF DocumentaireVF, Long id);
    Collection<DocumentaireVF> getDocListByParentId();
    Collection<DocumentaireVF> getByNiveau(String niveau);
    Collection<DocumentaireVF> getByNiveauAndIdParent(String niveau,Long id);
    DocumentaireVF getDocByLabel(String label);
    Collection<DocumentaireVF> getAllDocumentaireVFFiles();
    boolean addFileToDoc(FichierJoint fichierJoint,Long id);



}
