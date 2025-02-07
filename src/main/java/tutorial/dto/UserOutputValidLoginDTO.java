package tutorial.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOutputValidLoginDTO {


    private String accessToken;

    private long expiresIn;

    private String refreshToken;

    private long refreshExpiresIn;


}