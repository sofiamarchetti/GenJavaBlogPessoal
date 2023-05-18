package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_postagens")
public class Postagem {

	@Id // indica que este atributo será uma chave primária na minha tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indica que terá um auto-increment
	private Long id;
	
	@NotBlank(message = "Este atributo é de preenchimento obrigatório")
	@Size(min = 5, max=100,message="Este atributo tem que ter no mínimo 5 caracteres e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "Este atributo é de preenchimento obrigatório")
	@Size(min = 10, max=1000,message="Este atributo tem que ter no mínimo 10 caracteres e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}	
}