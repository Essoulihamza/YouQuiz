package ma.youcode.YouQuiz.services;

import java.util.List;

public interface Service<Dto, Identifier> {
    
    Dto save(Dto dto);
    List<Dto> getAll();
    Dto update(Identifier identifier, Dto dto);
    void delete(Identifier identifier);
    Dto find(Identifier identifier);
    Dto partialUpdate(Identifier identifier, Dto dto);
    boolean isExist(Identifier identifier);
    void deleteAll();

}
