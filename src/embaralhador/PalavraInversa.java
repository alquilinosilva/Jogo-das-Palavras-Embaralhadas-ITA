package embaralhador;

public class PalavraInversa implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}
}