package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BancoDePalavras {
	private LerDados dbase = new LerDados();
	private List<String> dicionario = new ArrayList<>();
	
	public BancoDePalavras() {
			dicionario = dbase.getDBase();
	}
	
	public String getPalavraAleatoria(){
		int rPos = ThreadLocalRandom.current().nextInt(0, dicionario.size());        
        return  dicionario.get(rPos);
	}
	
	public int getSize() {
		return dicionario.size();
	}
	
	public void remove(String palavra) {
		dicionario.remove(palavra);
	}
}
