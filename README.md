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

## Chave Primária

A chave primária é um conceito fundamental em bancos de dados relacionais. Ela é usada para identificar exclusivamente cada registro em uma tabela e permite que os dados sejam organizados e acessados de forma eficiente. A chave primária pode ser composta por um ou mais campos em uma tabela e é definida como um conjunto de restrições que garantem que os valores desses campos sejam únicos e não nulos. As chaves primárias são importantes porque permitem que as consultas sejam realizadas de forma eficiente em grandes conjuntos de dados e são frequentemente usadas para estabelecer relacionamentos entre tabelas.

Em JPA, a anotação **@GeneratedValue** é usada para especificar como o valor de uma coluna de chave primária é gerado. A estratégia de geração é definida pela anotação **@GeneratedValue** em conjunto com a anotação **@Id** nas entidades JPA.

Existem quatro estratégias de geração de valor de chave primária disponíveis na especificação JPA:

**GenerationType.IDENTITY**: essa estratégia assume que a coluna de chave primária é uma chave autoincrementável gerenciada pelo banco de dados. Ou seja, o valor da chave primária é gerado automaticamente pelo banco de dados. O JPA espera que o banco de dados informe o valor gerado após a inserção do registro.

**GenerationType.SEQUENCE**: essa estratégia assume que a coluna de chave primária é gerenciada por uma sequência de banco de dados. O JPA solicita um novo valor da sequência do banco de dados e usa esse valor como a chave primária para a nova entidade.

**GenerationType.TABLE**: essa estratégia utiliza uma tabela de valores de sequência no banco de dados para gerar o valor da chave primária. O JPA mantém uma tabela especial que armazena um valor de sequência para cada entidade. Quando uma nova entidade é persistida, o valor da chave primária é gerado a partir da tabela de valores de sequência.

**GenerationType.AUTO**: essa estratégia de geração é a mais flexível, permitindo que o provedor JPA escolha a estratégia de geração mais adequada com base no banco de dados e no contexto em que a entidade está sendo persistida. Por padrão, o provedor JPA escolhe a estratégia GenerationType.IDENTITY ou GenerationType.SEQUENCE dependendo do banco de dados utilizado.


## Relacionamentos

JPA (Java Persistence API) é uma API que fornece uma interface comum para trabalhar com dados persistentes em aplicações Java. Ao utilizar o JPA, é possível definir diferentes tipos de relacionamento entre as entidades do modelo de dados, permitindo que os dados sejam armazenados e consultados de forma mais eficiente e organizada.

Existem vários tipos de relacionamentos que podem ser definidos entre entidades no JPA. Alguns dos mais comuns são:

Relacionamento **Um-para-Um**:
Neste tipo de relacionamento, cada instância de uma entidade está relacionada a apenas uma instância de outra entidade. Para definir esse tipo de relacionamento no JPA, é necessário usar a anotação @OneToOne.

Relacionamento **Um-para-Muitos**:
Neste tipo de relacionamento, cada instância de uma entidade está relacionada a várias instâncias de outra entidade. Para definir esse tipo de relacionamento no JPA, é necessário usar a anotação @OneToMany.

Relacionamento **Muitos-para-Um**:
Neste tipo de relacionamento, várias instâncias de uma entidade estão relacionadas a uma única instância de outra entidade. Para definir esse tipo de relacionamento no JPA, é necessário usar a anotação @ManyToOne.

Relacionamento **Muitos-para-Muitos**:
Neste tipo de relacionamento, várias instâncias de uma entidade estão relacionadas a várias instâncias de outra entidade. Para definir esse tipo de relacionamento no JPA, é necessário usar a anotação @ManyToMany.

## Cascata

Em JPA, cascata é um recurso que permite especificar que operações realizadas em uma entidade também sejam aplicadas automaticamente em outras entidades associadas a ela. Isso significa que, por exemplo, se uma entidade A está associada a uma entidade B e a cascata está configurada para a operação de persistência, quando a entidade A for persistida, a entidade B também será persistida automaticamente.

Existem quatro tipos de cascata em JPA:

**CascadeType.ALL**: aplica todas as operações de cascata, incluindo persistência, atualização, remoção e atualização em cascata.

**CascadeType.PERSIST**: aplica a operação de persistência em cascata.

**CascadeType.MERGE**: aplica a operação de atualização em cascata.

**CascadeType.REMOVE**: aplica a operação de remoção em cascata.

## Relacionamento Bidirecional

A anotação mappedBy é usada em associações bidirecionais entre entidades no JPA e serve para especificar o nome do atributo na entidade relacionada que é responsável por manter a associação.

Quando se define um relacionamento bidirecional entre duas entidades, é necessário que uma das entidades seja a proprietária da relação (ou seja, ela é responsável por manter a chave estrangeira que faz referência à outra entidade). A outra entidade é considerada a entidade associada e não possui a chave estrangeira.

Ao usar a anotação mappedBy, você está informando ao JPA que a entidade proprietária não é a atual, mas sim a entidade relacionada que possui o atributo especificado como parâmetro. Essa informação é usada pelo JPA para configurar corretamente a associação bidirecional entre as entidades.

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

