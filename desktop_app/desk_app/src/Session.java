import entidade.Usuario;

public class Session {
    private static Usuario currentUser;

    public static Usuario getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Usuario user) {
        currentUser = user;
    }
}

//Essa classe Session é responsavel por armazenar o usuario atual, com 
// metodos que pega e set o usuario atual.