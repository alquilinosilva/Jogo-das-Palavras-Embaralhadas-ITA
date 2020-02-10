import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import embaralhador.Embaralhador;
import embaralhador.PalavraEmbaralhada;
import embaralhador.PalavraInversa;

class embaralhadores {
	String string = "alquilino";

	
	@Test
	void testePalavraInversa() {
		Embaralhador invertida = new PalavraInversa();
		String palavra = invertida.embaralhar(string);
		assertEquals("oniliuqla", palavra);
	}

	@Test
	void testePalavraEmbaralhada() {
		Embaralhador embaralhada = new PalavraEmbaralhada();
		String palavra = embaralhada.embaralhar(string);
		assertFalse(palavra.compareTo(string) == 0);
	}
}
