//package com.example.Bookstore.Model;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.sql.Timestamp;
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="feedback")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//public class Feedback {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long feedback_id;
//
//    @NotNull
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name="user_id")
//    private Long userId;
//
//    @NotNull
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name="product_id")
//    private Long product_id;
//
//    @NotNull
//    @Column(name="rating")
//    private int rating;
//
//    @Column(name="comment")
//    private String comment;
//
//    @Column(name = "created_at")
//    private Timestamp created_at;
//
//    public void setProductId(Long productId) {
//        this.product_id = productId;
//    }
//    public Long getProductId() {
//        return product_id;
//    }
//}
