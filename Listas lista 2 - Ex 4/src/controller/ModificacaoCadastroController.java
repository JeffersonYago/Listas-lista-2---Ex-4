package controller;
import model.Lista;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Cliente;
import java.io.FileWriter;

public class ModificacaoCadastroController {
	public ModificacaoCadastroController() {
		super();
	}
	
	private void novoArquivo(Lista<Cliente> listacliente, String nomeArquivo) throws Exception{
		File arquivo = new File("C:\\TEMP", nomeArquivo);
		BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
		int cont = 0;
		StringBuffer buffer = new StringBuffer();
		while(cont < listacliente.size()) {
			String Rec = listacliente.get(cont).toString();
			String[] clientesplit = Rec.split(";");
			long cpf = Long.parseLong(clientesplit[0]);
			String nome = clientesplit[1];
			int idade = Integer.parseInt(clientesplit[2]);
			double limiteCredit = Double.parseDouble(clientesplit[3].replaceAll(",","."));
			String adicionacliente = cpf+";"+nome+";"+idade+";"+limiteCredit+"\n";
			buffer.append(adicionacliente);
			escritor.write(buffer.toString());
			cont++;
		}escritor.close();
		}
		public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito)throws Exception{
			Lista <Cliente> cli = new Lista<>();
			File arquivo = new File("C:\\TEMP", "cadastro.csv");
			if(arquivo.exists() && arquivo.isFile()) {
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer  = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
						String[] split = linha.split(";");
						long cpf = Long.parseLong(split[0]);
						String nome = split[1];
						int idade = Integer.parseInt(split[2]);
						double limiteCredit = Double.parseDouble(split[3].replaceAll(",","."));
						Cliente holder = new Cliente();
						holder.setCpf(cpf);
						holder.setNome(nome);
						holder.setIdade(idade);
						holder.setLimitecredito(limiteCredit);
						if(idade >= idadeMin && idade <= idadeMax && limiteCredit > limiteCredito) {
							if(cli.isEmpty()) {
								cli.addFirst(holder);
							}else {
								cli.addLast(holder);
							}
							String nomearquivo = "idade"+idade+"limite"+limiteCredit+".csv";
							novoArquivo(cli, nomearquivo);
						}
						linha = buffer.readLine();
						}
				 buffer.close();
				 leitor.close();
				 fluxo.close();
	}else {
		throw new IOException("Arquivo Inválido");
	}
				}
		}