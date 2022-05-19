package br.com.foursys.fourcamp.fourstore.enums;

public enum MenuEnum {
	VENDA(1),
	ESTOQUE(2),
	SAIR(0);
	
	private final Integer opcao;

	private MenuEnum(Integer opcao) {
		this.opcao = opcao;
	}

	public Integer getOpcao() {
		return opcao;
	}
}
