import java.io.*;

// Classe que implementa Serializable
class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L; // Para garantir compatibilidade
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo para armazenar o objeto
        String arquivo = "pessoa.txt";

        // Objeto que será serializado
        Pessoa pessoa = new Pessoa("João", 30);

        // Serialização (salvar o objeto em um arquivo)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(pessoa); // Escreve o objeto no arquivo
            System.out.println("Objeto serializado com sucesso: " + pessoa);
        } catch (IOException e) {
            System.err.println("Erro ao serializar o objeto: " + e.getMessage());
        }

        // Desserialização (ler o objeto do arquivo)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            Pessoa pessoaLida = (Pessoa) in.readObject(); // Lê o objeto do arquivo
            System.out.println("Objeto desserializado com sucesso: " + pessoaLida);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar o objeto: " + e.getMessage());
        }
    }
}
