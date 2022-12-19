package com.JavaWebApplication.Beans;

public class PrenotaBean {

	private String nomePaziente;
	private String dataPrenotazione;
	private String genere;
	private String tipologiaVisita;
	private String codicePrenotazione;
	
	public PrenotaBean() {
		super();
	}

	public PrenotaBean(String nomePaziente, String dataPrenotazione, String genere, String tipologiaVisita,
			String codicePrenotazione) {
		super();
		this.nomePaziente = nomePaziente;
		this.dataPrenotazione = dataPrenotazione;
		this.genere = genere;
		this.tipologiaVisita = tipologiaVisita;
		this.codicePrenotazione = codicePrenotazione;
	}

	public String getNomePaziente() {
		return nomePaziente;
	}

	public void setNomePaziente(String nomePaziente) {
		this.nomePaziente = nomePaziente;
	}

	public String getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getTipologiaVisita() {
		return tipologiaVisita;
	}

	public void setTipologiaVisita(String tipologiaVisita) {
		this.tipologiaVisita = tipologiaVisita;
	}

	public String getCodicePrenotazione() {
		return codicePrenotazione;
	}

	public void setCodicePrenotazione(String codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}
	
	
	
}
