package sg.edu.nus.iss.csf35_workshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.csf35_workshop.service.GameService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class GameController {

    private GameService gameSvc;

    public GameController(GameService gameSvc) {
        this.gameSvc = gameSvc;
    }

    @GetMapping(path = "/games")
    public ResponseEntity<String> getGames(
            @RequestParam(defaultValue = "25") int limit, 
            @RequestParam(defaultValue = "0") int offset) {

        return ResponseEntity.ok(
                gameSvc.findAllGames(limit, offset)
                .toString());
    }
}
