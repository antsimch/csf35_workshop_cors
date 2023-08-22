package sg.edu.nus.iss.csf35_workshop.service;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.csf35_workshop.repository.GameRepository;

@Service
public class GameService {
    
    private GameRepository gameRepo;

    public GameService(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    public JsonObject findAllGames(int limit, int offset) {
        
        List<Document> docs = gameRepo.findAllGames(limit, offset);

        JsonArrayBuilder arr = Json.createArrayBuilder();

        docs.stream().forEach(
                doc -> arr.add(Json.createObjectBuilder()
                    .add("game_id", doc.getInteger("gid"))
                    .add("name", doc.getString("name"))));

        docs.stream().forEach(
                doc -> {
                    System.out.println(doc.getInteger("gid"));
                    System.out.println(doc.getString("name"));
                });

        return Json.createObjectBuilder()
                .add("games", arr)
                .add("offset", offset)
                .add("limit", limit)
                .add("total", docs.size())
                .add("timestamp", new Date().getTime())
                .build();
    }
}
