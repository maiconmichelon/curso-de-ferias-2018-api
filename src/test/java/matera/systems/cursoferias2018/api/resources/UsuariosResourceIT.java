package matera.systems.cursoferias2018.api.resources;

import matera.systems.cursoferias2018.api.domain.request.AtualizarUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.request.UsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class UsuariosResourceIT {

    static final String USUARIOS_URL = "http://localhost:8080/usuarios";
    static final String CONTENT_TYPE_HEADER = "Content-Type";
    static final String LOCATION_HEADER = "location";
    static final int NO_CONTENT_HTTP_STATUS_CODE = 204;
    static final int CREATED_HTTP_STATUS_CODE = 201;
    static final int OK_HTTP_STATUS_CODE = 200;
    static final String UUID_REGEX = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    static final String LOCATION_PATTERN = USUARIOS_URL + "/" + UUID_REGEX;

    @Test
    public void criarUsuario() {
        UsuarioRequest createRequest = new UsuarioRequest();
        createRequest.setNome("John Doe");
        createRequest.setLogin("john.doe");
        createRequest.setEmail("john.doe@email.com");
        createRequest.setPerfil("ADMINISTRADOR");
        createRequest.setUrlPhoto("http://pictures.pic/johndoe");

        Response response =
            RestAssured
                .given()
                    .body(createRequest)
                    .header(CONTENT_TYPE_HEADER, "application/json")
                .when()
                    .post(USUARIOS_URL)
                    .thenReturn();

        Assert.assertEquals(CREATED_HTTP_STATUS_CODE, response.getStatusCode());

        String location = response.getHeader(LOCATION_HEADER);
        Assert.assertTrue(location.matches("/usuarios/" + UUID_REGEX));
    }

    @Test
    public void buscaTodoUsuarios() {

        Response response =
            RestAssured
                .given()
                    .header("Accept", "application/json")
                    .get(USUARIOS_URL)
                .thenReturn();

        UsuarioResponse[] usuarios = response.getBody().as(UsuarioResponse[].class);

        Assert.assertEquals(3,usuarios.length);
        Assert.assertEquals(OK_HTTP_STATUS_CODE, response.getStatusCode());
    }

    @Test
    public void buscarUsuarioPorId() {
        String idUsuario = "bc51c8bb-bad3-47e4-af0c-7f467148f23d";
		Response response =
            RestAssured
                .given()
                    .header("Accept", "application/json")
                    .get(USUARIOS_URL + "/" + idUsuario)
                .thenReturn();

        UsuarioResponse usuario = response.getBody().as(UsuarioResponse.class);
        Assert.assertEquals(UUID.fromString(idUsuario), usuario.getUuid());
        Assert.assertEquals("Paulo Almeida", usuario.getNome());
        Assert.assertEquals("rochapaulo", usuario.getLogin());
        Assert.assertEquals("paulo.almeida@matera.com", usuario.getEmail());
        Assert.assertEquals("ADMINISTRADOR", usuario.getPerfil());
        Assert.assertEquals("https://s.gravatar.com/avatar/27b57f4f9580f95c4cbe78bb6d3ec893?s=80", usuario.getUrlPhoto());
        Assert.assertEquals(OK_HTTP_STATUS_CODE, response.getStatusCode());
    }

    @Test
    public void atualizaUsuario() {

        AtualizarUsuarioRequest atualizarUsuarioRequest = new AtualizarUsuarioRequest();
        atualizarUsuarioRequest.setNome("Nome Atualizado");

        Response response =
                RestAssured
                    .given()
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body(atualizarUsuarioRequest)
                        .put(USUARIOS_URL + "/369d8a35-e1df-4afc-9e0e-146b44f27d6d")
                    .thenReturn();

        Assert.assertEquals(OK_HTTP_STATUS_CODE, response.getStatusCode());
    }

    @Test
    public void deleteUsuario() {

        Response response =
                RestAssured
                    .given()
                        .header("Accept", "application/json")
                        .delete(USUARIOS_URL + "/369d8a35-e1df-4afc-9e0e-146b44f27d6d")
                    .thenReturn();

        Assert.assertEquals(NO_CONTENT_HTTP_STATUS_CODE, response.getStatusCode());
    }
    
}
