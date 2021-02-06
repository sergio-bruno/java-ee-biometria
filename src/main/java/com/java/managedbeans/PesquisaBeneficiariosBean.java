package com.java.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaBeneficiariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> beneficiariosFiltrados;
	
	public PesquisaBeneficiariosBean() {
		beneficiariosFiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			beneficiariosFiltrados.add(i);
		}
	}

	public List<Integer> getBeneficiariosFiltrados() {
		return beneficiariosFiltrados;
	}
	
}