# Aula4

# ResultSet

O ResultSet é composto por linhas e colunas que contêm os dados que foram selecionados pela consulta. Cada linha representa um registro encontrado na tabela, enquanto as colunas correspondem aos campos que foram selecionados na consulta.

## Cursor

ResultSet possui métodos para mover o cursor para a próxima linha, para a linha anterior, para a primeira linha, para a última linha, ou para uma linha específica. O método mais comum é o "next()", que move o cursor para a próxima linha no conjunto de resultados. Esse método retorna "true" se houver outra linha disponível, ou "false" caso contrário.

É importante lembrar que o cursor só pode percorrer o conjunto de resultados em uma única direção. Portanto, não é possível voltar para uma linha anterior após ter chamado o método "next()" para avançar para a próxima linha.

![image](https://user-images.githubusercontent.com/130251409/232260387-cbc5cf5b-9fa8-4dc7-a4bd-211d663cb0f7.png)

**O índice da tabela começa pelo 1**

## Percorrer um ResultSet

Loop while é executado enquanto o método "next()" do ResultSet retornar "true", ou seja, enquanto houver linhas disponíveis. A cada iteração do loop, os valores de cada coluna da linha atual são lidos usando os métodos correspondentes do ResultSet (no exemplo, "getInt()", "getString()" e "getDouble()").

É importante notar que os métodos "getXXX()" do ResultSet devem ser chamados com o nome correto da coluna, que pode ser o nome da coluna ou o índice da coluna (começando em 1). Se o nome ou o índice estiverem incorretos, será lançada uma exceção SQLException.

```java
// executar
ResultSet resultadoDaConsulta = pstm.executeQuery();

ArrayList<Aluno> lista = new ArrayList<>();

while (resultadoDaConsulta.next()) {
  String nome = resultadoDaConsulta.getString("nome");
  int idade = resultadoDaConsulta.getInt("idade");
  String email = resultadoDaConsulta.getString("email");

  System.out.println("email: " + email);
  System.out.println("idade: " + idade);
  System.out.println("nome " + nome);
}
```

### Fechar Conexão

Além disso, é importante fechar o ResultSet e o Statement após o uso, para liberar recursos do sistema. O cursor mantém uma conexão aberta com o banco de dados enquanto estiver navegando pelo conjunto de resultados. Portanto, é recomendado fechar o ResultSet e o Statement assim que não forem mais necessários, para liberar recursos do sistema.

```java
resultadoDaConsulta.close();
```


# Aula 6

## Dependências

```xml
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-core</artifactId>
	<version>5.6.5.Final</version>
</dependency>

<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>42.6.0</version>
</dependency>

<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-entitymanager</artifactId>
	<version>5.6.5.Final</version>
</dependency>
```

		
## persistence.xml



/resources/META-INF

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
	version="2.2">
	<!-- unidade de persistencia -->
	<persistence-unit name="FUCTURA-PU">
		<properties>
			<!-- Propriedades JDBC -->
			<property name="javax.persistence.jdbc.driver"
				value="org.postgresql.Driver" />
			<property name="javax.persistence.jdbc.url"
				value="jdbc:postgresql://localhost:5432/fuctura" />
			<property name="javax.persistence.jdbc.user" value="fuctura" />
			<property name="javax.persistence.jdbc.password" value="123" />
			<!-- Configurações específicas do Hibernate -->
			<property name="hibernate.dialect"
				value="org.hibernate.dialect.PostgreSQLDialect" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
		</properties>
	</persistence-unit>
</persistence>
```

# Aula 7


O hibernate.hbm2ddl.auto é uma propriedade do Hibernate que especifica a ação que deve ser tomada em relação ao banco de dados ao iniciar o aplicativo. Existem várias opções disponíveis para essa propriedade, cada uma com um comportamento diferente. Abaixo estão as opções mais comuns:

**validate**: Essa opção é usada para validar o esquema do banco de dados com as entidades mapeadas pelo Hibernate. Não faz alterações no banco de dados.

**update**: Essa opção atualiza o esquema do banco de dados de acordo com as entidades mapeadas pelo Hibernate. Isso significa que o Hibernate adicionará novas tabelas e colunas, mas não removerá tabelas ou colunas antigas.

**create**: Essa opção cria o esquema do banco de dados com base nas entidades mapeadas pelo Hibernate. Isso significa que o Hibernate criará todas as tabelas e colunas necessárias, mas se houver tabelas ou colunas existentes com os mesmos nomes, elas serão descartadas.

**create-drop**: Essa opção cria o esquema do banco de dados com base nas entidades mapeadas pelo Hibernate e, quando a aplicação é encerrada, ele remove todas as tabelas e colunas do banco de dados. É útil para desenvolvimento e testes, mas nunca deve ser usado em produção.

**none**: Essa opção não faz nada em relação ao esquema do banco de dados e assume que o esquema já existe e está correto.

# Aula 8 

## Leitura de dados utilizando BufferedReader

Como alternativa ao Scanner você pode utilizar a classe **BufferedReader** para fazer a leitura dos dados digitado no teclado como
**string** e fazer o parser para o tipo de dados desejado (int, double, etc) com o Wrapper específico.

```java
public class AplicacaoLeituraDeDados {
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Digite um ou mais palavras :");
		
		String texto = reader.readLine();
	
		System.out.println("Texto digitado: " + texto);
	
		System.out.println("Digite um número inteiro: ");
	
		texto = reader.readLine();
	
		int textoComoInteiro = Integer.parseInt(texto);
	
		System.out.println("O número digitado foi: " + textoComoInteiro);
	
		System.out.println("Digite um número real: ");
	
		texto = reader.readLine();
	
		double textoComoReal = Double.parseDouble(texto);
	
		System.out.println("O número digitado foi: " + textoComoReal);
		
		System.out.println("Digite um boleano (true ou false): ");
	
		texto = reader.readLine();
	
		boolean textoComoBoleano = Boolean.parseBoolean(texto);
	
		System.out.println("O boleano digitado foi: " + textoComoBoleano);
	}
}
```