package model;

public class BibliotecariaModel extends PessoaModel {
    private String email;
    private String senha;
    private boolean coordenador;

    public BibliotecariaModel(String nome, String sobrenome, String cpf, String email, String senha, boolean coordenador) {
        super(nome, sobrenome, cpf);
        this.email = email;
        this.senha = senha;
        this.coordenador = coordenador;
    }
        
    

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public String cargoCoordenador(){
        if(coordenador){
            return "Coordenador";
        }else{
            return "Funcinário";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
            this.senha = senha;       
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }
}
