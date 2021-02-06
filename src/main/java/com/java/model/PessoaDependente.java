/**
 * Classe PessoaDependente.java
 * Classe principal de entidades e mapeamento objeto relacional
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */
package com.java.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "pessoa_dependente")
public class PessoaDependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    protected PessoaDependentePK pessoaDependentePK;

    @JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa cdPessoa;

    public PessoaDependente() {
    }

    public PessoaDependente(PessoaDependentePK pessoaDependentePK) {
        this.pessoaDependentePK = pessoaDependentePK;
    }

    public PessoaDependente(int nrMatricula, int nrSequencial, int cdCorporacao) {
        this.pessoaDependentePK = new PessoaDependentePK(nrMatricula, nrSequencial, cdCorporacao);
    }

    public PessoaDependentePK getPessoaDependentePK() {
        return pessoaDependentePK;
    }

    public void setPessoaDependentePK(PessoaDependentePK pessoaDependentePK) {
        this.pessoaDependentePK = pessoaDependentePK;
    }

    public Pessoa getCdPessoa() {
        return cdPessoa;
    }
    public void setCdPessoa(Pessoa cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaDependentePK != null ? pessoaDependentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaDependente)) {
            return false;
        }
        PessoaDependente other = (PessoaDependente) object;
        if ((this.pessoaDependentePK == null && other.pessoaDependentePK != null) || (this.pessoaDependentePK != null && !this.pessoaDependentePK.equals(other.pessoaDependentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.model.PessoaDependente[ pessoaDependentePK=" + pessoaDependentePK + " ]";
    }
    
}
