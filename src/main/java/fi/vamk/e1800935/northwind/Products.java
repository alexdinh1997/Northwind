package fi.vamk.e1800935.northwind;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "fi.vamk.e1800935.northwind.Products")
@Table(name = "products")
public class Products {

  @Column(name = "\"supplier_ids\"", nullable = true)
  private String supplierIds;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"product_code\"", nullable = true)
  private String productCode;
  @Column(name = "\"product_name\"", nullable = true)
  private String productName;
  @Column(name = "\"description\"", nullable = true)
  private String description;
  @Column(name = "\"standard_cost\"", nullable = true)
  private java.math.BigDecimal standardCost;
  @Column(name = "\"list_price\"", nullable = false)
  private java.math.BigDecimal listPrice;
  @Column(name = "\"reorder_level\"", nullable = true)
  private Integer reorderLevel;
  @Column(name = "\"target_level\"", nullable = true)
  private Integer targetLevel;
  @Column(name = "\"quantity_per_unit\"", nullable = true)
  private String quantityPerUnit;
  @Column(name = "\"discontinued\"", nullable = false)
  private boolean discontinued;
  @Column(name = "\"minimum_reorder_quantity\"", nullable = true)
  private Integer minimumReorderQuantity;
  @Column(name = "\"category\"", nullable = true)
  private String category;
  @Column(name = "\"attachments\"", nullable = true)
  private String attachments;
}