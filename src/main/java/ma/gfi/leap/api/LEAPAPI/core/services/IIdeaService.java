package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;

import java.util.Collection;

public interface IIdeaService {

    Collection<Idea> getAllIdeas();
    Idea getIdeaById(Long IdeaId);
    Idea addIdea(Idea Idea);
    void updateIdea(Idea Idea);
    void deleteIdea(Long IdeaId);
    boolean addDocToIdea(DocumentaireVF documentaireVF,Long id);
    Collection<DocumentaireVF> getListDocByIdea(Long id);

}
