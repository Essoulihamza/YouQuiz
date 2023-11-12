package ma.youcode.YouQuiz.services;

import java.util.List;

public interface Service<Dto, Identifier> {
    
    Dto save(final Dto dto);
    List<Dto> getAll();
    Dto update(final Identifier identifier, final Dto dto);
    void delete(final Identifier identifier);
    Dto find(final Identifier identifier);
    Dto partialUpdate(final Identifier identifier, final Dto dto);
    boolean isExist(final Identifier identifier);
    void deleteAll();

}
