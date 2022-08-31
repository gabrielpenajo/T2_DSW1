package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "Proposta")
public class Proposta extends AbstractEntity<Long> {

    @NotNull(message = "{NotNull.proposta.usuario}")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

    @NotNull(message = "{NotNull.proposta.pacote}")
    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;

    @NotNull(message = "{NotNull.proposta.dataProposta}")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataProposta;

    @NotNull(message = "{NotNull.proposta.valor}")
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
    private BigDecimal valor;

    @NotNull(message = "{NotNull.proposta.statusProposta}")
    @Column(nullable = false)
    private int statusProposta;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public Date getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(Date dataProposta) {
        this.dataProposta = dataProposta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getStatusProposta() {
        return statusProposta;
    }

    public void setStatusProposta(int statusProposta) {
        this.statusProposta = statusProposta;
    }

    @Override
    public String toString() {
        return "Proposta [cliente=" + cliente + ", dataProposta=" + dataProposta + ", pacote=" + pacote
                + ", statusProposta=" + statusProposta + ", valor=" + valor + "]";
    }
    
}
