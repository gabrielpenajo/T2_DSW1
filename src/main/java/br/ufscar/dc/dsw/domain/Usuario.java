package br.ufscar.dc.dsw.domain;

import br.ufscar.dc.dsw.validation.UniqueCPF;
import br.ufscar.dc.dsw.validation.UniqueEmail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

    @NotBlank(message = "{NotBlank.usuario.nome}")
	@Size(min = 3, max = 256)
    @Column(nullable = false, length = 256)
    private String nome;

	@UniqueEmail(message = "Unique.usuario.Email")
	@NotBlank(message = "{NotBlank.usuario.email}")
	@Size(max = 256)
    @Column(nullable = false, length = 256, unique = true)
    private String email;
    
	@NotBlank(message = "{NotBlank.usuario.senha}")
	@Size(min = 3, max = 64)
    @Column(nullable = false, length = 64)
    private String senha;

    @NotBlank(message = "{NotBlank.usuario.papel}")
    @Column(nullable = false, length = 10)
    private String papel;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", id=" + id + ", nome=" + nome + ", papel=" + papel + ", senha=" + senha
				+ "]";
	}
 		
}