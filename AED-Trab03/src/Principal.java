//João Vitor de Oliveira, Natália Sens Weise e Paulo Rubens de Moraes Leme Júnior

public class Principal {
	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		v.setPlaca("AAA-0123");
		v.setModelo("Hyundai Creta");
		v.setAno(2017);
		v.setProprietario("João da Silva");
		

		MapaDispersao<String,Veiculo>mp = new MapaDispersao(2000);
		System.out.println(mp.inserir(v.getPlaca(), v));
	}
	
}
