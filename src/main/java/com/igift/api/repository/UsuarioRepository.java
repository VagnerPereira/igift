package com.igift.api.repository;

import com.igift.api.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "Select * from usuario usu where usu.id = ?1", nativeQuery = true)
    Usuario retornarUsuario (Long idUsuario);

    @Query(value = "Select * from usuario usu where usu.email = ?1 and usu.senha = ?2", nativeQuery = true)
    Usuario logar (String email, String senha);

}
