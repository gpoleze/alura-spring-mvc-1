package br.com.casadocodigo.loja.models;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Preco {

    private BigDecimal valor;
    private TipoPreco tipo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Preco{" +
                "valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }
}
