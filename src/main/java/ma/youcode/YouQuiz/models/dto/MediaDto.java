package ma.youcode.YouQuiz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.YouQuiz.models.enums.MediaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto {
    
    private Long id;
    private String url;
    private MediaType mediaType;
    private QuestionDto question;

}
