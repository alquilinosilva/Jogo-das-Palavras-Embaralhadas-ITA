package embaralhador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalavraEmbaralhada implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		List<Character> chars = new ArrayList<>();
		for (char ch : palavra.toCharArray()) { 
			chars.add(ch); 
		}
		Collections.shuffle(chars);
		String string = chars.toString() 
                .substring(1, 3 * chars.size() - 1) 
                .replaceAll(", ", ""); 
		return string;
	}

}
