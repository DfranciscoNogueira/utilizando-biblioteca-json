package br.com.teste.model;

public class Pessoa {
    
    private String nome;
    private int idade;
    private String paisNascimento;
    private String genero;
    
    public Pessoa() {
    }
    
    //Aqui fizemos o Override do método toString() para visualizar a impressão com o System.out.println()
    @Override
    public String toString() {
        return "Pessoa [Nome da Pessoa = " + nome + ", Idade da Pessoa = " + idade + ", País de Nascimento = " + paisNascimento + ", Gênero = " + genero + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
