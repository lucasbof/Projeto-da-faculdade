package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Faculdade;
import model.Rendimento;

public class LeEEscreveCSVNotas {
	private Faculdade faculdade;

	LeEEscreveCSVNotas(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	void leCSVNotas() {
		for(Curso curso : faculdade.getCursos()) {
			String caminho = System.getProperty("user.dir");
			caminho += File.separator + "CSVs";
			caminho += File.separator + curso.getNome() +"_" + curso.getNivel() + "_" + curso.getAno() + ".csv";
	
			try (FileInputStream fis = new FileInputStream(caminho)) {
				Scanner sc = new Scanner(fis, "UTF-8");
	
				while (sc.hasNextLine()) {
					String linha = sc.nextLine();
					String[] palavra = linha.split(";");
	
					String idAluno = palavra[0].toUpperCase();
					double novaNP1 = Double.parseDouble(palavra[1]);
					double novaNP2 = Double.parseDouble(palavra[2]);
					double novaReposicao = Double.parseDouble(palavra[3]);
					double novoExame = Double.parseDouble(palavra[4]);
					
					
					for (Aluno a : faculdade.getAlunos()) {
						if (idAluno.equals(a.getId())) {
							faculdade.addRendimento(a, curso, novaNP1, novaNP2, novaReposicao, novoExame);
						}
					}
				}
	
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void escreveCSVNotas() {
		for(Curso curso : faculdade.getCursos()) {
			String caminho = System.getProperty("user.dir");
			caminho += File.separator + "CSVs";
			caminho += File.separator + curso.getNome() +"_" + curso.getNivel() + "_" + curso.getAno() + ".csv";
			
			try(PrintWriter pw = new PrintWriter(caminho, StandardCharsets.UTF_8)) {
				
				for(Rendimento rendimento : faculdade.getRendimentos()) {
					if(curso.equals(rendimento.getCurso())) {
					
						pw.println(rendimento.getAluno().getId() + ";" 
								+ rendimento.getNota().getNp1() + ";"
								+ rendimento.getNota().getNp2() + ";"
								+ rendimento.getNota().getReposicao() + ";"
								+ rendimento.getNota().getExame()
								);
					}
				}
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
