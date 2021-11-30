package com.igift.api.service.entregadorService;

import com.igift.api.Dto.response.EntregadorDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.Entregador;
import com.igift.api.domain.UserLogin;

import java.util.List;

public interface EntregadorService {

    void salvarEntregador (Entregador entregador);

    List<PedidoResponseDto> listarPedidosEntregador (Long idEntregador);

    EntregadorDto retornarEntregador (Long idEntregador);

    EntregadorDto logar (UserLogin userLogin);

    List<EntregadorDto> listarEntregadores ();

}
