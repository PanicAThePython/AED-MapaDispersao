//João Vitor de Oliveira, Natália Sens Weise e Paulo Rubens de Moraes Leme Júnior

public interface Lista<K, T> {

	void inserir(K chave, T valor);

	int buscar(T valor);

	void retirar(T valor);

	String toString();

	boolean estaVazia();

	Lista<K, T> copiar();

	Lista<K, T> dividir();

	int getTamanho();

	T pegar(int posicao);



}