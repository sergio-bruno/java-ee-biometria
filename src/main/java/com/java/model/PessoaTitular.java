/**
 * Classe PessoaTitular.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */
package com.java.model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa_titular")
public class PessoaTitular implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PessoaTitularPK pessoaTitularPK;
    private int nrDigito;
    private Pessoa cdPessoa;

    public PessoaTitular() {
    }

    public PessoaTitular(PessoaTitularPK pessoaTitularPK) {
        this.pessoaTitularPK = pessoaTitularPK;
    }

    public PessoaTitular(PessoaTitularPK pessoaTitularPK, int nrDigito) {
        this.pessoaTitularPK = pessoaTitularPK;
        this.nrDigito = nrDigito;
    }

    public PessoaTitular(int nrMatricula, int cdCorporacao) {
        this.pessoaTitularPK = new PessoaTitularPK(nrMatricula, cdCorporacao);
    }

    public PessoaTitularPK getPessoaTitularPK() {
        return pessoaTitularPK;
    }

    public void setPessoaTitularPK(PessoaTitularPK pessoaTitularPK) {
        this.pessoaTitularPK = pessoaTitularPK;
    }

    @Nonnull
    @Column(name = "NR_DIGITO", nullable = false)
    public int getNrDigito() {
        return nrDigito;
    }
    public void setNrDigito(int nrDigito) {
        this.nrDigito = nrDigito;
    }

    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    @ManyToOne(optional = false)
    public Pessoa getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaTitularPK != null ? pessoaTitularPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaTitular)) {
            return false;
        }
        PessoaTitular other = (PessoaTitular) object;
        if ((this.pessoaTitularPK == null && other.pessoaTitularPK != null) || (this.pessoaTitularPK != null && !this.pessoaTitularPK.equals(other.pessoaTitularPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.model.PessoaTitular[ pessoaTitularPK=" + pessoaTitularPK + " ]";
    }
    
}
