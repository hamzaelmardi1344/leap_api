package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.DocumentaireVFRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class IdeaService implements IIdeaService {

    @Autowired
    private IdeaRepository IdeaRepository;

    @Autowired
    private DocumentaireVFRepository documentaireVFRepository;

    @Override
    public Collection<Idea> getAllIdeas() {
        Collection<Idea> list = new ArrayList<>();
        IdeaRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Idea getIdeaById(Long IdeaId) {
        Idea Idea = IdeaRepository.findById(IdeaId).get();
        return Idea;
    }

    @Override
    public Idea addIdea(Idea Idea) {
        return IdeaRepository.save(Idea);
    }

    @Override
    public void updateIdea(Idea Idea) {
        IdeaRepository.save(Idea);
    }

    @Override
    public void deleteIdea(Long IdeaId) {
        IdeaRepository.delete(getIdeaById(IdeaId));
    }

    public boolean addDocToIdea(DocumentaireVF DocumentaireVF, Long id) {
        Idea idea = IdeaRepository.findById(id).get();
        System.err.println(idea.getId());
        DocumentaireVF.setIdea(idea);
        System.err.println(DocumentaireVF.getIdea());
        DocumentaireVF DocumentaireVF1 = documentaireVFRepository.save(DocumentaireVF);

        Collection<DocumentaireVF> DocumentaireVFs = idea.getDocumentaireVFS();

        return DocumentaireVFs.add(DocumentaireVF1);
    }

    @Override
    public Collection<DocumentaireVF> getListDocByIdea(Long id) {

        Idea idea = IdeaRepository.findById(id).get();
        return idea.getDocumentaireVFS();
    }

}
