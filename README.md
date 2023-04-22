# j2040423
Repositório da turma de Java 2

# DAO
O padrão DAO (Data Access Object) é um padrão de design de software que separa a lógica de acesso aos dados da lógica de negócios em um aplicativo. O objetivo do padrão DAO é fornecer uma camada de abstração entre o código de negócios e a lógica de acesso aos dados, para que as mudanças em um não afetem o outro.

O DAO é comumente usado em aplicativos orientados a objetos que se comunicam com um banco de dados relacional. Em vez de escrever código SQL diretamente em seu aplicativo, você escreve uma classe DAO que encapsula a lógica de acesso aos dados. Essa classe geralmente contém métodos que permitem que você crie, leia, atualize e exclua registros do banco de dados, além de outras operações comuns.

O padrão DAO oferece vários benefícios. Em primeiro lugar, separar a lógica de acesso aos dados da lógica de negócios pode tornar o código mais fácil de entender e manter. Em segundo lugar, ao encapsular a lógica de acesso aos dados em uma classe separada, você pode facilmente mudar a fonte de dados subjacente sem afetar a lógica de negócios. Por exemplo, se você decidir mudar de um banco de dados relacional para um banco de dados NoSQL, pode simplesmente atualizar a implementação do DAO, sem precisar alterar o código de negócios.

# Implementação

Exemplo simples de DAO em Java para acessar e manipular uma tabela "Usuários" em um banco de dados relacional usando JDBC.

Primeiro, aqui está a interface DAO que define as operações de acesso aos dados:

```java
public interface UsuarioDAO {
    public Usuario buscarPorId(int id) throws SQLException;
    public List<Usuario> buscarTodos() throws SQLException;
    public void inserir(Usuario usuario) throws SQLException;
    public void atualizar(Usuario usuario) throws SQLException;
    public void excluir(int id) throws SQLException;
}
```

Aqui está a implementação do DAO usando JDBC:
```java
public class UsuarioDAOImpl implements UsuarioDAO {
    private Connection conn;

    public UsuarioDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public Usuario buscarPorId(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        return usuario;
    }

    public List<Usuario> buscarTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        return usuarios;
    }

    public void inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO usuarios (nome, email) VALUES (?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE usuarios SET nome = ?, email = ? WHERE id = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void excluir(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }
}
```

Nesta implementação, o DAO UsuarioDAOImpl é responsável por se comunicar com o banco de dados. Ele usa JDBC para executar as operações de acesso aos dados. Observe que a implementação do DAO usa PreparedStatements para evitar problemas de segurança, como **ataques de injeção de SQL** (pesquise sobre).


# Utilização

```java
// Crie uma instância do DAO e uma conexão com o banco de dados
UsuarioDAO usuarioDAO = new UsuarioDAOImpl(conn);

// Crie um novo objeto Usuario com os dados a serem inseridos
Usuario usuario = new Usuario();
usuario.setNome("João da Silva");
usuario.setEmail("joao.silva@email.com");

// Insira o novo usuário no banco de dados
usuarioDAO.inserir(usuario);
```
