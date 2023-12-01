package loc.lesson2.task3.models;



import loc.lesson2.task3.Column;

import java.util.UUID;

@loc.lesson2.task3.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
