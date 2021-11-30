package com.igift.api.service.usuarioService;

import com.igift.api.Dto.response.UsuarioDto;
import com.igift.api.domain.UserLogin;
import com.igift.api.domain.Usuario;
import com.igift.api.mapper.UsuarioMapper;
import com.igift.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public void salvarUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public UsuarioDto logar(UserLogin userLogin) {
        return UsuarioMapper.toDomainFromDto(repository.logar(userLogin.getLogin(), userLogin.getSenha()));
    }

    @Override
    public UsuarioDto retornarUsuario(Long idUsuario) {
        return UsuarioMapper.toDomainFromDto(repository.retornarUsuario(idUsuario));
    }
}
