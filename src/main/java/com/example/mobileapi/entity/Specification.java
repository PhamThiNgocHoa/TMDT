package com.example.mobileapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "specifications")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @Column(nullable = false)
    String name;  // Tên thông số kỹ thuật (ví dụ: 'CPU', 'RAM', 'Disk')

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;  // Mối quan hệ với bảng categories (Chỉ rõ thông số kỹ thuật thuộc về loại sản phẩm nào)

}
