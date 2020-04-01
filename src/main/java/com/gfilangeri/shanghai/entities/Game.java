package com.gfilangeri.shanghai.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Game {
    public Game() {
        this.open = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean open;
}
