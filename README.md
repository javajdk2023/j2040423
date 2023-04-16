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
