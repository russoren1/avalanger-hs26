package ch.zhaw.avalanger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountry(String country);
    List<Avalange> findByState(String state);
    List<Avalange> findByCountryAndState(String country, String state);
    
    
}
