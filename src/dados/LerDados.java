package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerDados {
	FileReader leitor;
	private List<String> dbase;
	
	public List<String> getDBase() {
		try {
			dbase = new ArrayList<>();
			File arquivo = new File("dicionario.txt");
			leitor = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String st = null; 
			while ((st = buffer.readLine()) != null) {
				dbase.add(st);
			}
			buffer.close();
		}catch(IOException e) {
			System.err.println("Erro ao ler o arquivo de palavras");
		}finally {
			try {
				leitor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return dbase;
	}
}
