package matera.systems.cursoferias2018.api.domain.request;

public class AtualizarUsuarioRequest {

    private String nome;
    private String login;
    private String email;
    private String senha;
    private String perfil;
    private String urlFoto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlPhoto) {
        this.urlFoto = urlPhoto;
    }

}
