package projeto01;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ponto {
	private String pontoDeEntrada;
	private String pontoDeSaida;
	
	public String getPontoDeEntrada() {
		return pontoDeEntrada;
	}

	public void setPontoDeEntrada(String pontoDeEntrada) {
		this.pontoDeEntrada = pontoDeEntrada;
	}

	public String getPontoDeSaida() {
		return pontoDeSaida;
	}

	public void setPontoDeSaida(String pontoDeSaida) {
		this.pontoDeSaida = pontoDeSaida;
	}

	void registra(int vez) {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat hora = DateFormat.getTimeInstance();
		if(vez==1){
			setPontoDeEntrada(hora.format(data));
		}
		if(vez==2) {
			setPontoDeSaida(hora.format(data));
		}
	}
	
}
