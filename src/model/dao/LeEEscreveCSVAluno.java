package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import model.Aluno;
import model.Faculdade;

public class LeEEscreveCSVAluno {
	
	private Faculdade faculdade;
	
	LeEEscreveCSVAluno(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	void leCSVAluno() { 
		String caminho = System.getProperty("user.dir");
        caminho += File.separator + "CSVs";
        caminho += File.separator + "alunos.csv";
        
	    try (FileInputStream fis = new FileInputStream(caminho)){         
	        Scanner in = new Scanner(fis, "UTF-8");
	
	        while(in.hasNextLine()) {
	                String linha = in.nextLine();
	                String[] palavra = linha.split(";");	
	                String novoId = palavra[0].toUpperCase();
	                String novoNome = palavra[1].toUpperCase();
	
	
	                faculdade.addAluno(novoId, novoNome);
	        }
	
	        in.close();
	    }catch(FileNotFoundException e) {
	        e.printStackTrace();
	    }catch(IllegalArgumentException e) {
	        e.printStackTrace();
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
    }
	
	void escreveCSVAluno() {
		String caminho = System.getProperty("user.dir");
		caminho += File.separator + "CSVs";
		caminho += File.separator + "alunos.csv";
		
		try(PrintWriter pw = new PrintWriter(caminho, StandardCharsets.UTF_8)) {
			
			for(Aluno aluno : faculdade.getAlunos()) {
				pw.println(aluno.getId() + ";" 
						+ aluno.getNome() + ";"
						);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}