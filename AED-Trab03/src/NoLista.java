//João Vitor de Oliveira, Natália Sens Weise e Paulo Rubens de Moraes Leme Júnior

public class NoLista<K ,T> {
	private K chave;
	private T info;
	private NoLista<K, T> proximo;

	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public NoLista<K, T> getProximo() {
		return proximo;
	}
	
	public void setProximo(NoLista<K, T> proximo) {
		this.proximo = proximo;
	}
	
	public void setChave(K ch) {
		this.chave = ch;
	}
	
	public K getChave() {
		return this.chave;
	}

}
