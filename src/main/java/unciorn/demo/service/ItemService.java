package unciorn.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unciorn.demo.model.Item;
import unciorn.demo.repository.ItemRepository;
import unciorn.demo.util.State;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService  {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getItems(){
        return repository.findAll();
    }
    public List<Item> getActive(){
        return repository.findByState(State.aktivni);
    }
    public List<Item> getCompleted(){
        return repository.findByState(State.ukoncene);
    }
    public Optional<Item> getItem(int id){
        return repository.findById(id);
    }
    public void createItem(Item item){
        repository.save(item);
    }
    public void deleteItem(int id){
        repository.deleteById(id);
    }
    @Transactional
    public void updateItem(Item item, int id){
        Item item1 = repository.findById(id).get();
        item1.setCount(item.getCount());
        item1.setState(item.getState());
        repository.save(item1);
       // repository.setItemInfoById(item.getCount(),item.getState(),id);
    }
}
