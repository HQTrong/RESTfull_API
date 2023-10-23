package tmdt.tmdt_api.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO {
    private int id;
    private String username;
    private String pass;
    private String email;
    private String role;

}
