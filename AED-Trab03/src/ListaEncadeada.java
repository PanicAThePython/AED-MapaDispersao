//João Vitor de Oliveira, Natália Sens Weise e Paulo Rubens de Moraes Leme Júnior

public class ListaEncadeada<K, T> implements Lista<K, T> {
	private NoLista<K, T> primeiro;
	private NoLista<K, T> ultimo;
	private int qtdeElementos;

	@Override
	public void inserir(K chave, T valor) {
		NoLista<K, T> novo = new NoLista<>();
		novo.setInfo(valor);
		novo.setChave(chave);
		qtdeElementos++;
		// para inserção no final (a lista fica de acordo com a ordem de inserção)
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		/*
		 * para inserção no início (a lista fica ao contrário)
		 * novo.setProximo(this.primeiro); this.primeiro = novo;
		 */
	}

	public String toString() {
		String toString = "[";
		NoLista<K, T> p = this.primeiro;
		while (p != null) {
			toString += p.getInfo() + ", ";
			p = p.getProximo();
		}
		toString += "]";
		return toString;
	}

	@Override
	public int buscar(T valor) {
		NoLista<K, T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getInfo() == valor) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}
	
	public NoLista<K, T> buscarNo(T valor) {
		NoLista<K, T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getInfo() == valor) {
				return this.pegarNo(posicao);
			}
			posicao++;
			p = p.getProximo();
		}
		return null;
	}
	
	public NoLista<K, T> buscarNoChave(K chave) {
		NoLista<K, T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getChave() == chave) {
				return this.pegarNo(posicao);
			}
			posicao++;
			p = p.getProximo();
		}
		return null;
	}


	@Override
	public void retirar(T valor) {
		NoLista<K, T> anterior = null;
		NoLista<K, T> p = this.primeiro;

		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			if (anterior == null) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			this.qtdeElementos--;
		}
	}
	
	public void retirarChave(K chave) {
		NoLista<K, T> anterior = null;
		NoLista<K, T> p = this.primeiro;

		while (p != null && p.getChave() != chave) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			if (anterior == null) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			this.qtdeElementos--;
		}
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null); // (ultimo == null) ou (qtdeElementos == 0)
	}

	@Override
	public Lista copiar() {
		ListaEncadeada<K, T> nova = new ListaEncadeada<>();
		NoLista<K, T> p = this.primeiro;
		while (p != null) {
			nova.inserir(p.getChave(), p.getInfo());
			p = p.getProximo();
		}
		return nova;
	}

	@Override
	public Lista<K, T> dividir() {
		ListaEncadeada<K, T> nova = new ListaEncadeada<>();
		int qtde = this.getTamanho() / 2;
		NoLista<K, T> nl = this.primeiro;
		NoLista<K, T> anterior=null;
		int index = 0;
		while (index < qtde) {
			anterior = nl;
			nl = nl.getProximo();
			index++;
		}

		// atualizando a nova lista
		nova.primeiro = nl;
		nova.ultimo = this.ultimo;
		nova.qtdeElementos = this.qtdeElementos - qtde;
		
		// atualizando a lista atual
		this.ultimo = anterior;
		ultimo.setProximo(null);
		this.qtdeElementos = qtde;
		
		return nova;
	}

	@Override
	public int getTamanho() {
		return this.qtdeElementos;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao >= this.qtdeElementos) { // posição inválida
			throw new ArrayIndexOutOfBoundsException("Posição inválida " + posicao);
		}
		NoLista<K, T> p = this.primeiro;
		int contPosicao = 0;
		while (p != null) {
			if (contPosicao == posicao) {
				return p.getInfo();
			}
			contPosicao++;
			p = p.getProximo();
		}
		// pela lógica nunca deve chegar aqui
		return null;
	}
	
	public NoLista<K, T> pegarNo(int posicao) {
		if (posicao >= this.qtdeElementos) { // posição inválida
			throw new ArrayIndexOutOfBoundsException("Posição inválida " + posicao);
		}
		NoLista<K, T> p = this.primeiro;
		int contPosicao = 0;
		while (p != null) {
			if (contPosicao == posicao) {
				return p;
			}
			contPosicao++;
			p = p.getProximo();
		}
		// pela lógica nunca deve chegar aqui
		return null;
	}
}
