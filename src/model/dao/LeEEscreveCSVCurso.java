package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import model.Curso;
import model.Faculdade;
import model.Nivel;

public class LeEEscreveCSVCurso {
	private Faculdade faculdade;
	
	LeEEscreveCSVCurso(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	void leCSVCursos() {
		String caminho = System.getProperty("user.dir");
        caminho += File.separator + "CSVs";
        caminho += File.separator + "cursos.csv";

		try (FileInputStream fis = new FileInputStream(caminho)){         
	        Scanner in = new Scanner(fis, "UTF-8");
	
	        while(in.hasNextLine()) {
	                String linha = in.nextLine();
	                String[] palavra = linha.split(";");
	
	                String novoNome = palavra[0].toUpperCase();
	                Nivel novoNivel = Nivel.valueOf(palavra[1]);
	                int novoAno = Integer.parseInt(palavra[2]);
	                
	               faculdade.addCurso(novoNome, novoNivel, novoAno);
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
	
	void escreveCSVCurso() {
		String caminho = System.getProperty("user.dir");
		caminho += File.separator + "CSVs";
		caminho += File.separator + "cursos.csv";
		
		try(PrintWriter pw = new PrintWriter(caminho, StandardCharsets.UTF_8)) {
			
			for(Curso curso : faculdade.getCursos()) {
				pw.println(curso.getNome() + ";" 
						+ curso.getNivel() + ";"
						+ curso.getAno()
						);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
