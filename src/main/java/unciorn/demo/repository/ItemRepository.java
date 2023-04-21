package unciorn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unciorn.demo.model.Item;
import unciorn.demo.util.State;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByState(State state);

//    @Modifying
//    @Query("update Item set count=?1, state = ?2 where id = ?3")
//    void setItemInfoById(int count,State state,int id);
}
