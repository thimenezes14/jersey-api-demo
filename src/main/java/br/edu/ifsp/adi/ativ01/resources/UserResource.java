package br.edu.ifsp.adi.ativ01.resources;

import java.util.List;
import java.util.UUID;
import br.edu.ifsp.adi.ativ01.dao.UserDAO;
import br.edu.ifsp.adi.ativ01.entities.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {
	
	// Recupera todos os usuários
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		try {
			return new UserDAO().findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Recupera usuário por ID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") UUID id) {
		try {
			return new UserDAO().findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Encontra usuário por nome (pesquisa por caracteres)
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserByName(@QueryParam("term") String term) {
		try {
			return new UserDAO().findUserByName(term);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Cria novo usuário
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public User saveUser(User u) {
		try {
			new UserDAO().createUser(u);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Atualiza informações do usuário
	@PATCH
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("id") UUID id, User u) {
		try {
			User updatedUser = new UserDAO().updateUser(id, u);
			return updatedUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Remove usuário por ID.
	@DELETE
	@Path("/remove/{id}")
	public void removeUserById(@PathParam("id") UUID id) {
		try {
			new UserDAO().deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
