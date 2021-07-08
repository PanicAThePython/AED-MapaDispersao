//João Vitor de Oliveira, Natália Sens Weise e Paulo Rubens de Moraes Leme Júnior

public class MapaDispersao<K, T> {
	private ListaEncadeada<K, T>[] tabela;
	
	
	public MapaDispersao(int qtd) {
		int l = gerarTamanhoVetorPorFatorDeCarga(qtd);
		//32 precisa ser tamanho dinâmico
		//fator de carga = 50% - 75%
		//qtd dados armazenados / tamanho do vetor
		//nmr primo
		
		tabela = new ListaEncadeada[l];
	}
	
	private int gerarTamanhoVetorPorFatorDeCarga(int qtdDados) {
		// M = N / f
		
		//tamanho do vetor
		int m = 0;
		int n = qtdDados;
		
		//fator de carga ideal
		float f = 0.50f;
		
		m = (int) (n / f);
		
		while (!ePrimo(m)) {
			m++;
		}
		
		return m;
	}
	
	private static boolean ePrimo(int nmr) {
		boolean primo = true;
		int aux = nmr - 1;
		
		while (aux > 1) {
			if ((nmr % aux) == 0) {
				primo = false;
				aux = 1;
			} 
			else {
				aux = aux -1;
			}
		}
		
		if (nmr < 2) {
			primo = false;
		}
		
		return primo;
	}
	
	private int calcularHash(K chave) {		
		return Math.abs(chave.hashCode()) % tabela.length;
	}
	
	public boolean inserir(K chave, T dado) {
		int hash = calcularHash(chave);

		if (buscar(chave) != null) {
			return false;
		}
		
		if (tabela[hash] == null) {
			tabela[hash] = new ListaEncadeada<K, T>();
		}

		tabela[hash].inserir(chave, dado);
		
		return true;
	}
	
	public T remover(K chave) {
		int hash = calcularHash(chave);
		
		if(buscar(chave) != null) {
			T dado = tabela[hash].buscarNoChave(chave).getInfo();
			
			tabela[hash].retirarChave(chave);
			
			return dado;
		}
		return null;
	}
	
	public T buscar(K chave) {
		int hash = calcularHash(chave);
		
		if (tabela[hash] != null) {
			for (int i = 0; i < tabela[hash].getTamanho(); i++) {
				if (tabela[hash].pegarNo(i).getChave().equals(chave)) {
					return tabela[hash].pegarNo(i).getInfo();
				}
			}
		}
		
		return null;
	}
	
	public int quantosElementos() {
		int qtd = 0;
		
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i] != null) {
				for (int j = 0; j < tabela[i].getTamanho(); j++) {
					qtd++;
				}
			}
		}
		return qtd;
	}
}