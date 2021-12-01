package com.igift.api.repository;

import com.igift.api.domain.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {
}
