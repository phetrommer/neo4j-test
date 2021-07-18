package com.example.demo.model;

import com.example.demo.model.GenusEntity;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("Plant")
public class PlantEntity {

    public String getName() {
        return name;
    }

    @Id
    private final String name;
    @Property("distribution")
    private final String distribution;
    @Relationship(type = "PART_OF", direction = Relationship.Direction.INCOMING)
    private Set<GenusEntity> genus = new HashSet<>();

    public PlantEntity(String name, String distribution)
    {
        this.name = name;
        this.distribution = distribution;
    }

}