package ma.youcode.YouQuiz.models.mappers;

public interface Mapper<Entity, Dto> {
    
    Dto mapTo(final Entity a);
    Entity mapFrom(final Dto b);

}
