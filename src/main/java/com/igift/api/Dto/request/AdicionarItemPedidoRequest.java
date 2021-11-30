package com.igift.api.Dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdicionarItemPedidoRequest {
    private Long idPedido;
    private Long idItem;
}
