
package io.crud.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.crud.dao.AlunoDAO;

public class PolularBanco {

    public static void main(String[] args) {
        
        String diretorio = System.getProperty("user.dir");
        String arquivo = diretorio.concat("\\db\\Alunos.txt");
        
        //System.out.println("O diretório do código fonte é: " + arquivo);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String line;
  
            List<Aluno> listaDeAlunos = new ArrayList<>();
            
            int i = 0;
            while ((line = br.readLine()) != null) {
                
                String linhas[] = line.split(";");
                //System.out.println("------");
                //for(String linha : linhas){
                   //System.out.println(linha);
                //}
                //Aluno novoAluno = new Aluno()
                
                if(linhas.length == 5){
                    
                    String AlunoCpf = linhas[0];
                    String AlunoNome = linhas[1];
                    String AlunoData[] = linhas[2].split("/");
                    int AlunoDia = 1;
                    int AlunoMes = 1;
                    int AlunoAno = 1900;
                    if(AlunoData.length == 3){
                        AlunoDia = Integer.valueOf(AlunoData[0]);
                        AlunoMes = Integer.valueOf(AlunoData[1]);
                        AlunoAno = Integer.valueOf(AlunoData[2]);
                    }
                    LocalDate AlunoDate = LocalDate.of(AlunoAno, AlunoMes, AlunoDia);
                    float AlunoPeso = Float.valueOf(linhas[3]);
                    float AlunoAltura = Float.valueOf(linhas[4]);
                    
                    listaDeAlunos.add(new Aluno(i+1, AlunoNome, AlunoCpf, Date.valueOf(AlunoDate), AlunoPeso, AlunoAltura));  
                
                }
                 
                i++;
                
            }
            
            AlunoDAO conexao = new AlunoDAO();
            
            for(Aluno a : listaDeAlunos){
                System.out.println(a);
                conexao.adiciona(a);
            }
            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}