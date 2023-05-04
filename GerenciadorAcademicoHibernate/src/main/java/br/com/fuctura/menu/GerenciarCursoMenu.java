package br.com.fuctura.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.fuctura.dao.CursoDAO;
import br.com.fuctura.entidade.Curso;

public class GerenciarCursoMenu {
	
	private EntityManagerFactory factory;
	private CursoDAO dao;
	
	public GerenciarCursoMenu(EntityManagerFactory factory) {
		this.factory = factory;
		this.dao = new CursoDAO(this.factory.createEntityManager());
	}
	
	public void exibirMenu() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
        boolean continuar = true;
        int opcao;
        
        while (continuar) {
        	//opcoes
            System.out.println("--- MENU CADASTRO CURSO ---");
            System.out.println("1 - Cadastrar novo curso");
            System.out.println("2 - Listar cursos cadastrados");
            System.out.println("3 - Atualizar curso");
            System.out.println("4 - Excluir curso");
            System.out.println("5 - Sair curso");
            System.out.print("Digite a opção desejada: ");
            
            var opcaoDigitada = reader.readLine();
            opcao =  Integer.parseInt(opcaoDigitada);
            
            switch (opcao) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    consultarCurso();
                    break;
                case 3:
                	atualizarCurso();
                    break;
                case 4:
                	excluirCurso();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
	}

	private void excluirCurso() throws IOException {
		consultarCurso();
		System.out.println("Digite o código do Curso que deseja atualizar: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String codigoDoCurso = reader.readLine();
		
		Long id = Long.parseLong(codigoDoCurso);
		
		Curso curso = dao.pesquisarPorId(id);

		dao.excluir(curso);
		
		System.out.println("Curso excluído com sucesso!");
	}

	private void atualizarCurso() throws IOException {
		consultarCurso();
		System.out.println("Digite o código do Curso que deseja atualizar: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String codigoDoCurso = reader.readLine();
		
		Long id = Long.parseLong(codigoDoCurso);
		
		Curso curso = dao.pesquisarPorId(id);
		
		if(curso != null) {
			System.out.println("Atualize o nome do curso: ");
			String novoNome = reader.readLine();
			
			curso.setNome(novoNome);
			
			dao.atualizar(curso);
		}
		
	}

	private void consultarCurso() {
		List<Curso> cursos = dao.buscarTodos();
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("*****************Resultado da Consulta**********************");
		for(Curso c : cursos) {
			System.out.println(c.getId() + " - " + c.getNome());
		}
		System.out.println("************************************************************");
		
		System.out.println("");
		System.out.println("");
	}

	private void cadastrarCurso() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o nome do curso:");
		String nomeDoCurso = reader.readLine();
		
		Curso curso = new Curso();
		curso.setNome(nomeDoCurso);
		
		dao.salvar(curso);
	}

	public String getDescricao() {
		return "Gerenciar Curso";
	}

}
