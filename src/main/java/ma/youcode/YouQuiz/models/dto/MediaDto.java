package ma.youcode.YouQuiz.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.YouQuiz.models.enums.MediaType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto {
    
    private Long id;

    @NotEmpty(message = "Media URL is required.")
    private String url;

    @NotNull(message = "Media type is required.")
    private MediaType type;

    private QuestionDto question;

}
