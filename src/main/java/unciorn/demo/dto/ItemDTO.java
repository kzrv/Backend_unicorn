package unciorn.demo.dto;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import unciorn.demo.util.State;

@Data
public class ItemDTO {

    private int id;
    private String content;
    private int count;
    private String state;
}
