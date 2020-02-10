package mecanica;

public class FabricaMecanicaDoJogo {
	private MecanicaDoJogo mecanica;

	public MecanicaDoJogo getMecanica() {
		return mecanica;
	}

	public void setMecanica(int opt) {
		switch(opt) {
		case 1: 
			mecanica = new ModoMorteSubita();
			 break;
		case 2:
			mecanica = new ModoAventura();
			break;
		}
	}
	
}
