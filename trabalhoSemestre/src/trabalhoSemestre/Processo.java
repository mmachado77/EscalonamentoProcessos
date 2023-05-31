package trabalhoSemestre;

public class Processo {
	int tempo_execucao;
	int tempo_restante;
	int tempo_chegada;
	int tempo_espera = 0;
	int prioridade = -69;
	boolean ordenado = false;
	boolean executado = false;
	boolean iniciado = false;
	
	public Processo (int tempo_execucao, int tempo_chegada) {
		this.tempo_execucao = tempo_execucao;
		this.tempo_restante = tempo_execucao;
		this.tempo_chegada = tempo_chegada;
	}
	
	public boolean getIniciado() {
		return this.iniciado;
	}
	
	public void setIniciado (boolean x) {
		this.iniciado = x;
	}
	
	public boolean getOrdenado(){
		return this.ordenado;
	}
	
	public void setOrdenado(boolean x) {
		this.ordenado = x;
	}
	
	public boolean getExecutado(){
		return this.executado;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	public int getTempo_chegada() {
		return tempo_chegada;
	}
	public int getTempo_execução() {
		return tempo_execucao;
	}
	public int getTempo_restante() {
		return tempo_restante;
	}
	
	public void setTempo_execucao(int tempo_execucao) {
		this.tempo_execucao = tempo_execucao;
		this.tempo_restante = tempo_execucao;
	}
	
	public void setTempo_chegada(int tempo_chegada) {
		this.tempo_chegada = tempo_chegada;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getTempo_espera() {
		return tempo_espera - tempo_chegada;
	}
	
	public void aumentaEspera() {
		this.tempo_espera++;
	}
	
	public void passaTempo() {
		tempo_restante--;
	}
	
	public void ocioso() {
		tempo_espera++;
	}
	
}
