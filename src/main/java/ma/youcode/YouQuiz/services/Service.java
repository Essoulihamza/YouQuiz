package ma.youcode.YouQuiz.services;

import java.util.List;

public interface Service<Dto, Identifier> {
    
    Dto create(Dto dto);
    List<Dto> read();
    Dto update(Dto dto);
    Boolean delete(Identifier identifier);
    
    Dto find(Identifier identifier);
}
