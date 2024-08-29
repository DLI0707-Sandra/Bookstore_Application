package com.example.Bookstore.Service;

import com.example.Bookstore.Model.Feedback;
import com.example.Bookstore.Model.FeedbackDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface FeedbackService {
     String  addFeedback(Long product_id, FeedbackDTO feedbackDTO);

     List<Feedback> getAllFeedback();

     List<Feedback> getFeedbackByProductId(Long productId);

     Feedback getFeedbackById(Long id);

     String deleteFeedbackById(Long id);
}
