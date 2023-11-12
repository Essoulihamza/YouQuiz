package ma.youcode.YouQuiz.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "Media URL is required.")
    private String url;

    @NotNull(message = "Media type is required.")
    private MediaType mediaType;

    @NotNull(message = "Media question is requiered.")
    private QuestionDto question;

}
