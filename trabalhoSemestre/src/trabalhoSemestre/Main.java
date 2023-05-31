package trabalhoSemestre;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class Main {
	static ArrayList<Processo> Processos = new ArrayList<Processo>();
	static Scanner Teclado = new Scanner(System.in);
	static Random Gerador = new Random();
	static int tempo = 1;

	public static void main(String[] args) {
		menu();

	}
	
	static void menu(){
		int input = -69;
		
		while (input != 0) {
			System.out.println("Escolha uma opção:\n"
					+ "1 - Criar processo\n"
					+ "2 - Popular com 03 processos aleatórios\n"
					+ "3 - Escolher Ordenamento\n"
					+ "4 - Listar Processos\n"
					+ "0 - Sair.");
			input = Teclado.nextInt();
			
			if(input==1) {
				criarProcesso();
			}else if(input==2) {
				popular();
			}else if(input==3) {
				menuOrdenamento();
			}else if(input==4){
				listaProcessos();
			
			}else{
				System.out.println("Opção Inválida.");
			}
		}
	}
	
	static void menuOrdenamento() {
		int input = -69;
		while (input != 0) {
			System.out.println("Escolha uma opção:\n"
					+ "1 - FCFS\n"
					+ "2 - SJF Preemptivo\n"
					+ "3 - SJF Não Preemptivo\n"
					+ "4 - Prioridade Preemptivo\n"
					+ "5 - Prioridade Não Preemptivo\n"
					+ "6 - Round Robin"
					+ "0 - Sair.");
			input = Teclado.nextInt();
			
			if(input==1) {
				FCFS();
			}else if(input==2) {

			}else if(input==3) {
				
			}else if(input==4){
				
			}else{
				System.out.println("Opção Inválida.");
			}
		}
	}
	
	static void FCFS() {
			ArrayList<Integer> ordemChegada = new ArrayList<>();
			ArrayList<Processo> processosTemp = new ArrayList<>();
				for (int i=0; i<Processos.size(); i++) {
					int tempoChegada;
					tempoChegada = Processos.get(i).getTempo_chegada();
					ordemChegada.add(tempoChegada);
				}	
			Collections.sort(ordemChegada);
			
				for (int i=0; i<ordemChegada.size(); i++) {
					for (int j=0; j<Processos.size(); j++) {
						if(ordemChegada.get(i)==Processos.get(j).getTempo_chegada() && Processos.get(j).getOrdenado()==false) {
							Processos.get(j).setOrdenado(true);
							processosTemp.add(Processos.get(j));
						}
					}
				}
								
			Processos = processosTemp;
				for (int i=0; i<Processos.size(); i++) {
					Processos.get(i).setPrioridade(i + 1);
				}
				
				for (int i=0; i<Processos.size(); i++) {
					Processos.get(i).setIniciado(true);
					System.out.println("teste");
					System.out.println("Processo " + i + " - Tempo de Execução: " + Processos.get(i).getTempo_execução() + ", Tempo Restante: " + Processos.get(i).getTempo_restante() + ", Tempo de Chegada: " + Processos.get(i).getTempo_chegada() + ", Prioridade: " + Processos.get(i).getPrioridade() + ".");
					for(int j=Processos.get(i).tempo_restante; j>0; j--) {
						if (Processos.get(i).getTempo_restante()>0 && Processos.get(i).tempo_chegada>=tempo) {
							Processos.get(i).passaTempo();
						}
						System.out.println("Tempo: " + tempo + " - Processo " + i + " - Tempo de Execução: " + Processos.get(i).getTempo_execução() + ", Tempo Restante: " + Processos.get(i).getTempo_restante() + ", Tempo de Chegada: " + Processos.get(i).getTempo_chegada() + ", Prioridade: " + Processos.get(i).getPrioridade() + ", Tempo de Espera: " + Processos.get(i).getTempo_espera());
						tempo++;
							for (int a=0; a<Processos.size(); a++) {
								if(Processos.get(a).getIniciado()!=true) {
									Processos.get(a).aumentaEspera();
								}
							}
					}
				}
		
	}
	
	static void criarProcesso(){
		int tExecucao, tChegada;
		System.out.println("Qual o tempo de execução do Processo?");
		tExecucao = Teclado.nextInt();
		System.out.println("Qual o tempo de chegada do Processo?");
		tChegada = Teclado.nextInt();
		Processo x = new Processo(tExecucao,tChegada);
		Processos.add(x);
		System.out.println("Processo adicionado com sucesso.");
	}
	
	static void popular(){
		int a = intRandom(11) + 1;
		int b = intRandom(7) + 1;
		int c = intRandom(11) + 1;
		int d = intRandom(7) + 1;
		int e = intRandom(11) + 1;
		int f = intRandom(7) + 1;
		Processo x = new Processo(a,b);
		Processos.add(x);
		System.out.println("Processo adicionado com sucesso.");
		System.out.println("Tempo de Execução: " + a + ", Tempo de Chegada: " + b);
		Processo y = new Processo(c,d);
		Processos.add(y);
		System.out.println("Processo adicionado com sucesso.");
		System.out.println("Tempo de Execução: " + c + ", Tempo de Chegada: " + d);
		Processo z = new Processo(e,f);
		Processos.add(z);
		System.out.println("Processo adicionado com sucesso.");
		System.out.println("Tempo de Execução: " + e + ", Tempo de Chegada: " + f);
	}
	
	static void listaProcessos() {
		for(int i = 0; i<Processos.size(); i++) {
			System.out.println("Processo " + i + " - Tempo de Execução: " + Processos.get(i).getTempo_execução() + ", Tempo Restante: " + Processos.get(i).getTempo_restante() + ", Tempo de Chegada: " + Processos.get(i).getTempo_chegada() + ", Prioridade: Não Definida.");
		}
	}
	
	static int intRandom(int z) {
		int x = 0;
		x = Gerador.nextInt(z) - 1;
			if (x < 0) {
			    x = x * -1;
			}
		return x;
	}
	
	

}
