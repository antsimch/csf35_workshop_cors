package sg.edu.nus.iss.csf35_workshop.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    
    private static final String C_NAME = "boardgame";

    private MongoTemplate template;

    public GameRepository(MongoTemplate template) {
        this.template = template;
    }

    public List<Document> findAllGames(int limit, int offset) {
        
        Query query = Query.query(
                new Criteria())
            .limit(limit)
            .skip(offset);
            
        return template.find(
                query, 
                Document.class, 
                C_NAME);
    }
}
