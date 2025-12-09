package dev.camargo.criptografia.domain;

import dev.camargo.criptografia.infra.CryptoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document")
    @Convert(converter = CryptoConverter.class)  
  private String userDocument;

    @Column(name = "credit_card_token")
    @Convert(converter = CryptoConverter.class)
    private String creditCardToken;

    @Column(name = "value_amount")
    private Long value;

}
