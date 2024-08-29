package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    //@Query("SELECT f FROM feedback f WHERE f.product.id = :productId")
    List<Feedback> findByBookId(Long productId);
}
