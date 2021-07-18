package com.example.demo.service;

import com.example.demo.Main;
import com.example.demo.model.GenusEntity;
import com.example.demo.repository.GenusRepository;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

@RestController
@RequestMapping(value = "/genus", produces = {"application/json"}, method = RequestMethod.POST)
public class GenusController {

    private final GenusRepository genusRepository;

    public GenusController(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    @GetMapping(value = {"", "/"})
    public List<String> getGenus() {
        try (Session session = Main.driver.session()) {
            List<String> genusList = new ArrayList<>();
            session.readTransaction(tx -> {
                Result result1 = tx.run("MATCH (g:Genus) RETURN g.name");
                while (result1.hasNext())
                {
                    genusList.add(result1.next().get(0).asString());
                }
                System.out.println(genusList);
                return null;
            });
            return genusList;
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<GenusEntity> get(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(new GenusEntity(name));
    }

    @GetMapping("/add/{name}")
    public static String addGenus(@PathVariable("name") String name)
    {
        try (Session session = Main.driver.session())
        {
            session.writeTransaction(tx1 -> tx1.run("CREATE (g:Genus {name: $name})", parameters("name", name)));
        }
        return name;
    }
}
