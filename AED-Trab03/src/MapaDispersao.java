
public class MapaDispersao<K, T> {
	private Lista<K, T> tabela;
	
	
	public MapaDispersao(int qtd) {
		
	}
	
	private int calcularHash(K chave) {
		
		int n = chave.hashCode()-1;
		int h = 0;
		
		for (int i = 0; i < n; i++) {
			K caractere = chave[i];
			
		}
		
	}
	
	public boolean inserir(K chave, T dado) {
		
	}
	
	public T remover(K chave) {
		
	}
	
	public T buscar(K chave) {
		
	}
	
	public int quantosElementos() {
		
	}
}
