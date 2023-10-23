package tmdt.tmdt_api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sanpham")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tensp")
    private String tenSanPham;
    @Column(name = "giasp")
    private int giaSanPham;
    @Column(name = "anh")
    private String anh;
    @Column(name = "mota")
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private CategoryType categoryType;
    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<Order> orders;

}


