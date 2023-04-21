package unciorn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import unciorn.demo.dto.ItemDTO;
import unciorn.demo.model.Item;
import unciorn.demo.service.ItemService;
import unciorn.demo.util.State;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

    private final ItemService service;

    @Autowired
    public Controller(ItemService service) {
        this.service = service;
    }

    @GetMapping("/shoppingList")
    public List<Item> getItems(@RequestParam(value="state",required = false)String param){
        if(param==null) return service.getItems().stream().sorted().toList();
        if(param.equals("active")) return service.getActive().stream().sorted().toList();
        else if(param.equals("completed")) return service.getCompleted().stream().sorted().toList();
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid param value: " + param);
    }
    @GetMapping("/shoppingItem/{id}")
    public Item getItem(@PathVariable(value="id")Integer id){
        Optional<Item> o = service.getItem(id);
        if(o.isPresent()){
            return o.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item with that id is not exist");
    }
    @PostMapping("/shoppingItem")
    // @PutMapping("/shoppingItem/{id}")
    public ResponseEntity<String> createItem(@RequestBody ItemDTO item){
        State state = item.getState().equals("active")? State.aktivni : State.completed;
        Item item1 = new Item(item.getId(),item.getContent(), item.getCount(), state);
        service.createItem(item1);
        System.out.println("Check work " + item.getId());
        return ResponseEntity.ok("{}");
    }
    @DeleteMapping("shoppingItem/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable(value="id")int id){
        service.deleteItem(id);
        return ResponseEntity.ok("{}");
    }
    @PutMapping("shoppingItem/{id}")
    public ResponseEntity<String> updateItem(@RequestBody ItemDTO item,@PathVariable(value="id")int id){
        State state = item.getState().equals("active")? State.aktivni : State.completed;
        Item item1 = new Item(item.getId(),item.getContent(), item.getCount(), state);
        service.updateItem(item1,id);
        return ResponseEntity.ok("{}");
    }
}
