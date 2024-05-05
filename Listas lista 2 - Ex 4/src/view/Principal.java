package view;

import controller.ModificacaoCadastroController;

public class Principal {

	public static void main(String[] args) throws Exception {
		ModificacaoCadastroController mcc = new ModificacaoCadastroController();
		mcc.novoCadastro(41, 60, 8000.00);
		mcc.novoCadastro(31, 40, 5000.00);
		mcc.novoCadastro(21, 30, 3000.00);
	}
}