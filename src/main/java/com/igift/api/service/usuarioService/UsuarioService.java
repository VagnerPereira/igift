package com.igift.api.service.usuarioService;

import com.igift.api.Dto.response.UsuarioDto;
import com.igift.api.domain.UserLogin;
import com.igift.api.domain.Usuario;

public interface UsuarioService {

    void salvarUsuario (Usuario usuario);

    UsuarioDto logar (UserLogin UserLogin);

    UsuarioDto retornarUsuario (Long idUsuario);
}
