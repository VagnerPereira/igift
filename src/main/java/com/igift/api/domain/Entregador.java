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
@SequenceGenerator(name = "seq_entregador", sequenceName = "seq_entregador", allocationSize = 1)
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entregador")
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
