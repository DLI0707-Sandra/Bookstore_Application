package com.example.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="feedback")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "feedback_id")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedback_id;

    @NotNull
    @ManyToOne
    @JoinColumn (name="user_id")
    private Users users;

    @NotNull
    @ManyToOne
    @JoinColumn (name="product_id")
    private Book book;

    @NotNull
    @Min(value = 1,message = "Rating should be greater than or equal to one")
    @Max(value = 5,message = "Maximum value of rating is 5!")
    @Column(name="rating")
    private int rating;

    @Column(name="comment")
    private String comment;

    @Column(name = "created_at")
    private LocalDateTime created_at;

}
