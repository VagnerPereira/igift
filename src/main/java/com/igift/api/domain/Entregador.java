package com.igift.api.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Entregador {

    @Id
    private Long id;

    private String nome;

    private String senha;

    @Column(name = "data_nascimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    private String email;
}
