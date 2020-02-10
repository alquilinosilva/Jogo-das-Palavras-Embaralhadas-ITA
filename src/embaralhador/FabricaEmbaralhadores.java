package embaralhador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FabricaEmbaralhadores {
	private static List<Embaralhador> embalharadores = new ArrayList<>();
	
	static {
		embalharadores.add(new PalavraEmbaralhada());
		embalharadores.add(new PalavraInversa());
	}
	
	public static Embaralhador getEmbaralhador() {
		int rPos = ThreadLocalRandom.current().nextInt(0, embalharadores.size());
        
        return embalharadores.get(Math.abs(rPos));
	}
}
