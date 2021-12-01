package com.igift.api.controller;

import com.igift.api.Dto.response.UsuarioDto;
import com.igift.api.domain.UserLogin;
import com.igift.api.domain.Usuario;
import com.igift.api.service.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarUsuario (@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
    }

    @PostMapping("/logar")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto logarUsuario (@RequestBody UserLogin login) {
        return  usuarioService.logar(login);
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto retornarUsuario (@PathVariable String idUsuario) {
        return usuarioService.retornarUsuario(Long.parseLong(idUsuario));
    }

}
