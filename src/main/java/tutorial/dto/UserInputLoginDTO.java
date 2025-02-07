package tutorial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputLoginDTO implements HasMaskedField {

    @NotNull(message = "{Person.cpf.required}")
    @CPF(message = "{Person.cpf.invalid}")
    private String cpf;

    @NotBlank(message = "{Person.password.required}")
    private String password;


    public String getCpf() {
        return removeMask(cpf);
    }


}
