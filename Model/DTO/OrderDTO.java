package tmdt.tmdt_api.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private int idDonHang;
    private int thanhTien;
    private int idCustomer;
    private List<ProductDTO> product;
}
