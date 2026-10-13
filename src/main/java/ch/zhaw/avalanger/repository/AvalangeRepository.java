package ch.zhaw.avalanger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeStageAggregation;

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountry(String country);
    List<Avalange> findByState(String state);
    List<Avalange> findByCountryAndState(String country, String state);
    
    @Aggregation(pipeline = {
        "{'$group': {'_id': '$state', 'avalange_count': {'$count': {}}}}",
        "{'$project': {'state': '$_id', 'avalange_count': 1, '_id': 0}}"
    })
    List<AvalangeStageAggregation> getStateAggregations();


    
}
