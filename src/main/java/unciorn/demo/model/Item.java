package unciorn.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import unciorn.demo.util.State;

@Data
@Entity
@Table(name="Item")
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int count;
    @Enumerated
    private State state;

    public Item() {
    }

    public Item(int id, String content, int count, State state) {
        this.id = id;
        this.content = content;
        this.count = count;
        this.state = state;
    }
}
