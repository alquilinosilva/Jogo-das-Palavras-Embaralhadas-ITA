package mecanica;

public interface MecanicaDoJogo {
		public String getModo();

	    public String getDescricao();
	    
	    public String getInstrucao();

	    public boolean isTerminou();
	    
	    public String getEmbaralhada();

	    public boolean isAcertou(String resposta);

	    public void pontuar(boolean acertou);
	    
	    public int getTentativas();
	    
	    public String getHead();
	    
	    public String getResultado();
}
