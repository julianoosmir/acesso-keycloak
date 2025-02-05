package tutorial.exception;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String errorId;
    private String method;
    private String type;
    private String title;
    private String detail;
    private String instance;
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<InvalidParams> invalidParams;

}
