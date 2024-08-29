package com.example.Bookstore.Service;

import com.example.Bookstore.Exception.ProductNotFoundException;
import com.example.Bookstore.Exception.UserNotFoundException;
import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.Feedback;
import com.example.Bookstore.Model.FeedbackDTO;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.Repository.FeedbackRepository;
import com.example.Bookstore.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImplementation implements FeedbackService{
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersRepo usersRepo;

    @Override
    public String  addFeedback(Long product_id, FeedbackDTO feedbackDTO) {
        Feedback feedback=new Feedback();
        Long user_id=feedbackDTO.getUser_id();
        Users users=usersRepo.findById(user_id).orElse(null);
        Book book=bookRepository.findById(product_id).orElse(null);
        if(users!=null&&book!=null)
        {
            feedback.setBook(book);
            feedback.setUsers(users);
            feedback.setRating(feedbackDTO.getRating());
            feedback.setComment(feedbackDTO.getComment());
            feedback.setCreated_at(LocalDateTime.now());
            feedbackRepository.save(feedback);
        }
        else
        {
            if(book==null)
                throw new ProductNotFoundException("Book not found!");
            if(users==null)
                throw new UserNotFoundException("User not found!");
        }
        return "Feedback added!";
    }

    @Override
    public List<Feedback> getFeedbackByProductId(Long productId)
    {
        return feedbackRepository.findByBookId(productId);
    }
}
