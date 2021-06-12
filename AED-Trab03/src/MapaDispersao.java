
public class MapaDispersao<K, T> {
	private Lista<K, T> tabela[];
	
	
	public MapaDispersao(int qtd) {
		int l = qtd % 32;
		tabela = new Lista[l];
	}
	
	private int calcularHash(String chave) {
		
		int hash = 0;
		for (int i = 0; i < chave.length(); i++) {
			hash = (31 * hash + chave.charAt(i)) % 32;
		}
		return hash;
	}
	
	private int calcularHash(K chave) {
		
		return chave.hashCode() % 32;
	}
	
	public boolean inserir(K chave, T dado) {
		int hash = calcularHash(chave);
		
		if (buscar(chave) != null) {
			return false;
		}
		
		tabela[hash] = (Lista<K, T>) dado;
		return true;
	}
	
	public T remover(K chave) {
		int hash = calcularHash(chave);
		if(buscar(chave) != null) {
			T valor = (T) tabela[hash];
			tabela[hash] = null;
			return valor;
		}
		return null;
	}
	
	public T buscar(K chave) {
		int hash = calcularHash(chave);
		
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[hash] == tabela[i]) {
				return (T) tabela[i];
			}
		}
		return null;
	}
	
	public int quantosElementos() {
		int qtd = 0;
		
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i] != null) {
				qtd+=1;
			}
		}
		return qtd;
	}
}
