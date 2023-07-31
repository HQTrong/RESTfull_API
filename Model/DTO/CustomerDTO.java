package tmdt.tmdt_api.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int id;
    private String fullname;
    private String address;
    private String phone;
    private String username;
}
