//Jo�o Vitor de Oliveira, Nat�lia Sens Weise e Paulo Rubens de Moraes Leme J�nior

public class Principal {
	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		v.setPlaca("AAA-0123");
		v.setModelo("Hyundai Creta");
		v.setAno(2017);
		v.setProprietario("Jo�o da Silva");
		

		MapaDispersao<String,Veiculo>mp = new MapaDispersao(2000);
		System.out.println(mp.inserir(v.getPlaca(), v));
	}
	
}
