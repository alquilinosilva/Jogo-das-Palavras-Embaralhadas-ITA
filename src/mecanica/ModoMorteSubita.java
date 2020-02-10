package mecanica;

import dados.BancoDePalavras;
import embaralhador.Embaralhador;
import embaralhador.FabricaEmbaralhadores;

public class ModoMorteSubita implements MecanicaDoJogo{
	private BancoDePalavras dicionario = new BancoDePalavras();
	Embaralhador embaralhador;
	
	private boolean isGanhaVida = false;
	private boolean isMudarPalavra = false;
	private int vidas = 0;
	private int erros = 0;
	private int acertos = 0;
	private int pontos = 0;
	private int tentativas = 0;	
	private int totPalavras = 0;
	private String palavra;
	
	public ModoMorteSubita() {
		this.vidas = 1;
		this.tentativas = 1;
	}
	
	@Override
	public String getModo() {
		return "NOME =[Modo Morte Subita]";
	}

	@Override
	public String getDescricao() {
		return "DESCRICAO =[tente acertar o maior numero de palavras com apenas 1 vida!]";
	}
	
	@Override
	public String getInstrucao() {
		return "INSTRUCAO =[as palavras sao embaralhadas aleatoriamente,"
				+ "\nvoce possui apenas 1 vida(s),"
				+ "\na cada 1 acerto(s) voce ganha 10 ponto(s),"
				+ "\nvoce possui 1 tentativa(s) por palavra,"
				+ "\n1 tentativa(s) gera 1 erro(s),"
				+ "\na cada 1 erro(s) voê perde 1 vida(s), "
				+ "\no jogo termina quando voce acerta todas as palavras,"
				+ "\nou perde todas as vidas]";
	}

	@Override
	public boolean isTerminou() {
		boolean terminou = false;
		if((vidas == 0) || (dicionario.getSize() == 0)) {
			terminou = true;
		}
		return terminou;
	}

	@Override
	public String getEmbaralhada() {
		embaralhador = FabricaEmbaralhadores.getEmbaralhador();
		this.tentativas = 1;
		this.palavra = dicionario.getPalavraAleatoria();
		if(palavra != null) {
			totPalavras++;
		}
		return embaralhador.embaralhar(palavra);
	}
	
	@Override
	public boolean isAcertou(String resposta) {
		boolean acertou = false;
		
		if(palavra.equalsIgnoreCase(resposta)) {
			dicionario.remove(resposta);
			acertou = true;
		}
		
		pontuar(acertou);
		return acertou;
	}

	@Override
	public void pontuar(boolean acertou) {
		if(acertou == true) {
			acertos++;
			pontos+= 10;
			
			if((isGanhaVida == true) && (acertos % 5 == 0)) {
				contabilizaVida(true);
			}
		}else {
			tentativas--;
			erros++;
			if(tentativas == 0) {
				contabilizaVida(false);
			}			
		}
		
		isTerminou();
	}
	
	@Override
	public int getTentativas() {
		return this.tentativas;
	}
	
	@Override
	public String getHead() {
		return "Painel [vidas="+ vidas + " | tentativas="+ tentativas + " | erros="+ erros +" | acertos="+ acertos + " | pontos="+ pontos +" | palavras=" + totPalavras +"]"; 
	}
	
	@Override
	public String getResultado() {
		String resultado = "Fim de Jogo - ";
	
		if(vidas == 0) {
			resultado += "Voce Perdeu!";
		}
		if(dicionario.getSize() == 0) {
			resultado += "Voce Venceu!";
		}
		
		return resultado;
	}
	
	public void contabilizaVida(boolean param) {
		if(param == true) {
			vidas++;
		}else {
			vidas--;
			if(vidas > 0) {
				tentativas = 1;
				if(isMudarPalavra == true) {
					 getEmbaralhada();
				}
			}
		}
	}
}
