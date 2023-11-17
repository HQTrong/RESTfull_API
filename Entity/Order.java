package tmdt.tmdt_api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donhang")
public class Order {
    @Id
    @Column(name = "id_donhang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "thanhtien")
    private int thanhTien;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "id_donhang"),
            inverseJoinColumns = @JoinColumn(name = "id_sanpham"))
    @JsonManagedReference
    private List<Product> products;

}

