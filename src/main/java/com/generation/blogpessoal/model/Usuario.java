package com.generation.blogpessoal.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O atibuto NOME é obrigatório.")
	private String nome;
	
	@NotNull(message="O atibuto USUÁRIO é obrigatório.")
	@Email(message="O atibuto USUÁRIO vai receber um EMAIL válido.")
	private String usuario;
	
	private String senha;
	
	private String foto;
	
	private List<Postagem> postagem;
}