package Biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public interface DAO {
	public void gravar();

	public void excluir();

	public void atualizar();

	public Object ler();

	public static void excluir(String chave, String tipo) {
		try {
			File file = new File("../Dados_03/" + tipo + "/" + chave);
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na exclusão\n" + e.toString());
		}
	}

	public static Object ler(String chave, String tipo) {
		try {
			FileInputStream file = new FileInputStream("../Dados_03/" + tipo + "/" + chave);
			ObjectInputStream stream = new ObjectInputStream(file);
			Object o = stream.readObject();
			stream.close();
			return o;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na leitura\n" + e.toString());
			return null;
		}
	}
	
	public static void diretorio(String dir) {
		File dirFileBase = new File(dir);
		if (!dirFileBase.exists())
			if(dirFileBase.mkdir()) 
				System.out.println("Diretório criado: " + dir);
	}

	public static void gravar(String chave, Object o) {
		// TODO Auto-generated method stub
		try {
			String dir = "../Dados_03";
			String dirFile = dir + "/" + o.getClass().getSimpleName();
			
			diretorio(dir);
			diretorio(dirFile);				

			FileOutputStream file = new FileOutputStream(dirFile + "/" + chave);
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(o);
			stream.flush();
			stream.close();
			System.out.println("Armazenado com sucesso: " + o.getClass().getSimpleName());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha na gravação\n" + e.toString());
		}
	}

	public static List<Object> lerTudo(String tipo) {
		try {
			List<Object> dados = new ArrayList<Object>();
			File[] files = new File("../Dados_03/" + tipo).listFiles();

			for (File file : files) {
				if (file.isFile()) {
					Object o = ler(file.getName(), tipo);
					dados.add(o);
				}
			}
			return dados;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não cadastrado!");
			return new ArrayList<Object>();
		}
	}
	public static int quatidade(String tipo) {
		File[] files = new File("../Dados_03/" + tipo).listFiles();
		return files.length;
	}
}
