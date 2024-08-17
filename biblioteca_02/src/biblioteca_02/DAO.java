package biblioteca_02;

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
	
	public static void excluir(String chave) {
		try {

			List<Object> dados = new ArrayList<Object>();
			File file = new File("../Dados_02/"+chave);
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na exclusão\n" + e.toString());
		}
	}
	
	public static Object ler(String chave) {
		try {
			FileInputStream file = new FileInputStream("../Dados_02/" + chave);
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

	public static void gravar(String chave, Object o) {
		// TODO Auto-generated method stub
		try {

			String dir = "../Dados_02";
			
			diretorio(dir);		

			FileOutputStream file = new FileOutputStream(dir + "/" + chave);
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(o);
			stream.flush();
			stream.close();
			System.out.println("Armazenado com sucesso");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha na gravação\n" + e.toString());
		}
	}
	public static void diretorio(String dir) {
		File dirFileBase = new File(dir);
		if (!dirFileBase.exists())
			if(dirFileBase.mkdir()) 
				System.out.println("Diretório criado: " + dir);
	}
	public static List<Object> lerTudo() {

		try {

			List<Object> dados = new ArrayList<Object>();
			File[] files = new File("../Dados_02/").listFiles();

			for (File file : files) {
				if (file.isFile()) {
					Object o = ler(file.getName());
					dados.add(o);
				}
			}
			return dados;
		} catch (Exception e) {
			// TODO: handle exception
			return new ArrayList<Object>();
		}

	}
}
