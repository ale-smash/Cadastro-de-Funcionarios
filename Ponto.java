package projeto01;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ponto {
	private String pontoDeEntrada;
	private String pontoDeSaida;
	private int vez = -1;
	
	public Ponto() {
		this.vez = 0;
	}
	
	public String getPontoDeEntrada() {
		return pontoDeEntrada;
	}

	public void setPontoDeEntrada() {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		this.pontoDeEntrada = dtHora.format(data);
		this.vez++;
	}

	public String getPontoDeSaida() {
		return pontoDeSaida;
	}

	public void setPontoDeSaida() {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		this.pontoDeSaida = dtHora.format(data);
		this.vez++;
	}

	public int getVez() {
		return vez;
	}

	public void setVez(int vez) {
		this.vez = vez;
	}
	
}
