package com.java.managedbeans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CaptureEvent;

import com.java.service.NegocioException;
import com.java.service.TrazBiometria;

@Named("biometriaBean")
@RequestScoped
public class RegistraBiometriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dedoSelecionado;
	private String digitalColetada;
	private String nmPessoa;
	private String filename;
	
	@Inject
	private TrazBiometria dadosBiometria;
	
	public void forcaErroNegocioSemLog4j() {
		throw new NegocioException("Biometria não pode ser salva, pois ainda não foi implementada.");
	}

	public void forcaErroNegocioComLog4j() {
		throw new RuntimeException("Biometria não pode ser salva, pois ainda não foi implementada.");
	}

	public void atualizar() {
		this.digitalColetada = dadosBiometria.retornaBiometria(this.dedoSelecionado);
		System.out.println("Digital coletada: " + this.digitalColetada);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Informação", "Digital cadastrada para o dedo: "+this.dedoSelecionado));		
	}

	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);
		return String.valueOf(i);
	}
	
	public void oncapture(CaptureEvent captureEvent) {
		filename = getRandomImageName();
		byte[] data = captureEvent.getData();

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String newFileName = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo"
				+ File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		} catch (IOException e) {
			throw new FacesException("Error in writing captured image.", e);
		}
	}
	
	public String getDedoSelecionado() {
		return dedoSelecionado;
	}

	public void setDedoSelecionado(String dedoSelecionado) {
		this.dedoSelecionado = dedoSelecionado;
	}

	public String getDigitalColetada() {
		return digitalColetada;
	}

	public void setDigitalColetada(String digitalColetada) {
		this.digitalColetada = digitalColetada;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getFilename() {
		return filename;
	}
	
}