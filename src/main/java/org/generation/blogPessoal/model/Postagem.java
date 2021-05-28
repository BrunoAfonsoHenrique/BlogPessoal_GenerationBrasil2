package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;


/* Para que a classe seja interpretada no banco de dados como uma entidade temos que inserir anotações*/
/* Anotações são parametros que colocamos em cima das classe/propriedades para definir comportamentos */
@Entity 
@Table(name = "Postagem")	/*A entidade vai virar uma tabela no BD com o nome Postagem */
public class Postagem {
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; /*Esse atributo vai virar no BD uma Primary Key*/
	
	@NotNull
	@Size(min = 5, max = 100) 
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 500) 
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date Date = new java.sql.Date(System.currentTimeMillis()); /* Assim que passar algum dado por essa classe, vai capturar
	extamente a data, hora, segundo, milesimo que esse dado passou pela classe */
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	

	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
