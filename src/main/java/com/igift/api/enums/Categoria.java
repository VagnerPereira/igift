package com.igift.api.enums;

public enum Categoria {
    ROUPA ("Roupa") ,
    FARMACIA("Farmacia");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
