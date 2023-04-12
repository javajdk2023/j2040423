# j2040423
Repositório da turma de Java 2

# API JDBC

A API JDBC (Java Database Connectivity) é uma especificação padrão da linguagem Java para conexão com bancos de dados relacionais. Essa API permite que os desenvolvedores de software escrevam aplicativos Java que interagem com uma ampla variedade de bancos de dados, incluindo Oracle, MySQL, Microsoft SQL Server, PostgreSQL, entre outros.

## Connection

A classe **Connection** é uma das principais classes fornecidas pela API JDBC (Java Database Connectivity) e é usada para estabelecer uma conexão entre um aplicativo Java e um banco de dados relacional. É uma classe abstrata que fornece uma interface para estabelecer, manter e encerrar conexões com o banco de dados.

Para estabelecer uma conexão com um banco de dados, a classe Connection fornece métodos como o **getConnection()**, que recebe como argumentos o URL do banco de dados, o nome de usuário e a senha. Após a conexão ser estabelecida, é possível usar métodos como **prepareStatement**. 

Exemplo da abertura de conexão para o PostgreSQL:


```java
String url = "jdbc:postgresql://localhost:5432/postgres";
Properties props = new Properties();
props.setProperty("user", "fuctura");
props.setProperty("password", "123");

Connection conexao = DriverManager.getConnection(url, props);
```

### prepareStatement

O método **prepareStatement** é um recurso importante da API JDBC (Java Database Connectivity) para executar consultas parametrizadas em um banco de dados. Essa técnica é uma forma de construir consultas SQL dinamicamente, permitindo que valores de parâmetros sejam fornecidos durante a execução da consulta.

Ao usar o método **prepareStatement**, o desenvolvedor fornece uma instrução SQL com um ou mais pontos de interrogação (?) em vez de valores específicos. Esses pontos de interrogação representam valores que serão fornecidos durante a execução da consulta. Em seguida, o método **prepareStatement** retorna um objeto **PreparedStatement**, que é usado para definir os valores dos parâmetros e executar a consulta.

Exemplo de como preparar uma comando SQL:


```java
String sql = "INSERT INTO aluno VALUES (?, ?, ?)";
PreparedStatement pstm = conexao.prepareStatement(sql);
```

### PreparedStatement

A interface **PreparedStatement** é uma das principais interfaces fornecidas pela API JDBC (Java Database Connectivity) para executar consultas parametrizadas em um banco de dados relacional. Para definir os valores dos parâmetros, a interface **PreparedStatement** fornece métodos como setInt, setString, setDouble e setBoolean, que permitem definir valores para cada ponto de interrogação da instrução SQL. Depois que todos os parâmetros são definidos, a consulta pode ser executada usando o método executeQuery ou executeUpdate. 


Exemplo de como utilizar um comando sql preparado e atribuir valores :


```java
String sql = "INSERT INTO aluno VALUES (?, ?, ?)"; //cada interrogação possui um índice

PreparedStatement pstm = conexao.prepareStatement(sql);

pstm.setString(1, aluno.getNome()); //preenchendo a primeira interrogação
pstm.setInt(2, aluno.getIdade()); //preenchendo a segunda interrogação
pstm.setString(3, aluno.getEmail()); //preenchendo a terceira interrogação

pstm.execute();
```
