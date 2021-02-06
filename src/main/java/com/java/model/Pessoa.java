/**
 * Classe Pessoa.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package com.java.model;

import java.io.Serializable;
import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cdPessoa;
    private String nmPessoa;
    
    @Id
    @GeneratedValue
    @Column(name="CD_PESSOA")
    public Long getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Long cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @Nonnull
    //@NotBlank
    //@Size(max = 300)
    @Column(name="NM_PESSOA", length = 300, nullable = false )
    public String getNmPessoa() {
        return nmPessoa;
    }
    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdPessoa == null) ? 0 : cdPessoa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cdPessoa == null) {
            if (other.cdPessoa != null)
                return false;
        } else if (!cdPessoa.equals(other.cdPessoa))
            return false;
        return true;
    }

}
