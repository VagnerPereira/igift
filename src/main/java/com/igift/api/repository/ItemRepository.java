package com.igift.api.repository;

import com.igift.api.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query(value = "Select * from item it inner join loja loj on it.id_loja = loj.id and loj.id = ?1", nativeQuery = true)
    List<Item> retornarItensLoja (Long lojaId);
}
