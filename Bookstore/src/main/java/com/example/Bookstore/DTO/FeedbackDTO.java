package com.example.Bookstore.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackDTO {

    @NotNull
    private Long user_id;
    @NotNull
    @Min(value = 1,message = "Rating should be greater than or equal to one")
    @Max(value = 5,message = "Maximum value of rating is 5!")
    private int rating;
    private String comment;
}
