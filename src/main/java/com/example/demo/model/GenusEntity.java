package com.example.demo.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Genus")
public class GenusEntity {

    @Id
    private final String name;

    public String getName() {
        return name;
    }

    public GenusEntity(String name) {
        this.name = name;
    }
}
