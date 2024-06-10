
package dao;

import java.sql.*;
import factory.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class AlunoDAO {
    
    private Connection connection;
    
    public AlunoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona (Aluno aluno){
        
        String sql = "INSERT INTO aluno(cpf, nome, data_nascimento, peso, altura) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setDate(3, aluno.getDataNasc());
            stmt.setFloat(4, aluno.getPeso());
            stmt.setFloat(5, aluno.getAltura());
            stmt.execute();
            stmt.close();
        }
        
        catch (SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    
    public void atualizar(Aluno aluno){
        // Declaração SQL para alterar um registro
        String sql = "UPDATE alunos.aluno SET cpf = ?, nome = ?, data_nascimento = ?, peso = ?, altura = ? WHERE id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setDate(3, aluno.getDataNasc());
            stmt.setFloat(4, aluno.getPeso());
            stmt.setFloat(5, aluno.getAltura());
            stmt.setInt(6, aluno.getId());
            stmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException u){
            throw new RuntimeException(u);
        }
 
    }
    
    public int excluir(int codigo){
        
        List<HistoricoPeso> listaDeHistoricos = consultaHistoricoByAluno(codigo);
        List<Integer> listaDeIdHistoricos = new ArrayList<>();
        for(HistoricoPeso hp : listaDeHistoricos){
            listaDeIdHistoricos.add(hp.getId());
        }
        List<Integer> resultadoHistorico = excluirVariosHistorico(listaDeIdHistoricos);
        
        String sql = "DELETE FROM alunos.aluno WHERE id = " + codigo;
        
        try{
            Statement stmt = connection.createStatement();
            int linhasAfetadas = stmt.executeUpdate(sql);
            if(linhasAfetadas > 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch(SQLException e){
            return -1;
        }
    }
    
    public List<Integer> excluirVarios(List<Integer> codigos){
        List<Integer> resultados = new ArrayList<>();
        for(Integer codigo : codigos){
            resultados.add(excluir(codigo));
        }
        return resultados;
    }
    
    public List<Aluno> consulta (String Chave, String Valor1, String Valor2){
        
        List<Aluno> listaDeAlunos = new ArrayList<>();
        
        String parametro;
        String sql;
        
        if(Valor1.isEmpty() & Valor2.isEmpty()){
            sql = "SELECT * FROM alunos.aluno"; 
        }
        else{
            if(Chave.equals("id")){

                //"SELECT * FROM alunos.aluno WHERE id IN ('v1', 'v2')";            
                //"SELECT * FROM alunos.aluno WHERE id BETWEEN 'v1' AND 'v2'";

                if(Valor2.isEmpty()){
                    parametro = "SELECT * FROM alunos.aluno WHERE id = '";
                    sql = parametro.concat(Valor1).concat("'");
                }
                else{
                    parametro = "SELECT * FROM alunos.aluno WHERE id BETWEEN '";
                    sql = parametro.concat(Valor1).concat("' AND '").concat(Valor2).concat("'");
                }            

            }
            else if(Chave.equals("cpf")){

                if(Valor2.isEmpty()){
                    parametro = "SELECT * FROM alunos.aluno WHERE cpf LIKE '%";
                    sql = parametro.concat(Valor1).concat("%'"); 
                }
                else{
                    //SELECT * FROM alunos.aluno WHERE cpf LIKE '%cp1%' OR cpf LIKE '%cp2%';
                    parametro = "SELECT * FROM alunos.aluno WHERE cpf LIKE '%";
                    sql = parametro.concat(Valor1).concat("%' OR cpf LIKE '%").concat(Valor2).concat("%'");
                }

            }
            else if(Chave.equals("nome")){

                if(Valor2.isEmpty()){
                    parametro = "SELECT * FROM alunos.aluno WHERE nome LIKE '%";
                    sql = parametro.concat(Valor1).concat("%'");
                }
                else{
                    //SELECT * FROM alunos.aluno WHERE nome LIKE '%nome1%' OR nome LIKE '%nome2%';
                    parametro = "SELECT * FROM alunos.aluno WHERE nome LIKE '%";
                    sql = parametro.concat(Valor1).concat("%' OR nome LIKE '%").concat(Valor2).concat("%'");
                }

            }
            else if(Chave.equals("data de nascimento")){

                SimpleDateFormat fmtOriginal = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat fmtDesejado = new SimpleDateFormat("yyyy-MM-dd");

                if(Valor2.isEmpty()){             
                    try {
                        Date data1 = fmtOriginal.parse(Valor1);
                        String data1Fmt = fmtDesejado.format(data1);
                        parametro = "SELECT * FROM alunos.aluno WHERE data_nascimento = '";
                        sql = parametro.concat(data1Fmt).concat("'");
                    }
                    catch (ParseException e) {
                        sql = "SELECT * FROM alunos.aluno";  
                        System.out.println("Erro ao fazer parsing da data...");
                    }
                }
                else{
                    try {
                        //SELECT * FROM alunos.aluno WHERE data_nascimento BETWEEN data1 AND data2;

                        Date data1 = fmtOriginal.parse(Valor1);
                        Date data2 = fmtOriginal.parse(Valor2);
                        String data1Fmt = fmtDesejado.format(data1);
                        String data2Fmt = fmtDesejado.format(data2);
                        parametro = "SELECT * FROM alunos.aluno WHERE data_nascimento BETWEEN '";
                        sql = parametro.concat(data1Fmt).concat("' AND '").concat(data2Fmt).concat("'");
                    }
                    catch (ParseException e) {
                        sql = "SELECT * FROM alunos.aluno";  
                        System.out.println("Erro ao fazer parsing da data...");
                    }
                }

            }
            else if(Chave.equals("peso")){

                if(Valor2.isEmpty()){
                    parametro = "SELECT * FROM alunos.aluno WHERE peso = ";
                    sql = parametro.concat(Valor1);
                }
                else{
                    parametro = "SELECT * FROM alunos.aluno WHERE peso BETWEEN ";
                    sql = parametro.concat(Valor1).concat(" AND ").concat(Valor2);
                }

            }
            else if(Chave.equals("altura")){

                if(Valor2.isEmpty()){
                    parametro = "SELECT * FROM alunos.aluno WHERE altura = ";
                    sql = parametro.concat(Valor1);
                }
                else{
                    parametro = "SELECT * FROM alunos.aluno WHERE altura BETWEEN ";
                    sql = parametro.concat(Valor1).concat(" AND ").concat(Valor2);
                }

            }
            else{
                sql = "SELECT * FROM alunos.aluno";         
            }
        }
        
        try{
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // System.out.println(sql);
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                Date dataNasc = rs.getDate("data_nascimento");
                java.sql.Date dataNascFormat = new java.sql.Date(dataNasc.getTime());
                float peso = rs.getFloat("peso");
                float altura = rs.getFloat("altura"); 
                
                listaDeAlunos.add(new Aluno(id, nome, cpf, dataNascFormat, peso, altura));
                
            }
            
            for(Aluno a : listaDeAlunos){
                // System.out.println(a);
            }
            
        }
        catch(SQLException u){
            throw new RuntimeException(u);
        }
        finally{
            return listaDeAlunos;
        }
    }
    
    
    public void adicionaHistorico (HistoricoPeso historicoPeso){
        
        String sql = "INSERT INTO historico(aluno_id, data_registro, peso) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, historicoPeso.getAlunoId());
            stmt.setDate(2, historicoPeso.getDataRegistro());
            stmt.setFloat(3, historicoPeso.getPeso());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    
    public void atualizarHistorico(HistoricoPeso historicoPeso){
        // Declaração SQL para alterar um registro
        String sql = "UPDATE historico SET data_registro = ?, peso = ? WHERE id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, historicoPeso.getDataRegistro());
            stmt.setFloat(2, historicoPeso.getPeso());
            stmt.setInt(3, historicoPeso.getId());
            stmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException u){
            throw new RuntimeException(u);
        }
 
    }
    
    public int excluirHistorico(int codigo){
        
        String sql = "DELETE FROM historico WHERE id = " + codigo;
        
        try{
            Statement stmt = connection.createStatement();
            int linhasAfetadas = stmt.executeUpdate(sql);
            if(linhasAfetadas > 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch(SQLException e){
            return -1;
        }
    }
    
    public List<Integer> excluirVariosHistorico(List<Integer> codigos){
        List<Integer> resultados = new ArrayList<>();
        for(Integer codigo : codigos){
            resultados.add(excluirHistorico(codigo));
        }
        return resultados;
    }
    
    public List<HistoricoPeso> consultaHistoricoByAluno (int idAluno){
        
        List<HistoricoPeso> listaDeHistoricos = new ArrayList<>();
        
        String sql = "SELECT * FROM historico WHERE aluno_id = ? ORDER BY data_registro";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(sql);
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                int alunoId = rs.getInt("aluno_id");
                java.sql.Date dataRegistro = rs.getDate("data_registro");
                float peso = rs.getFloat("peso");

                listaDeHistoricos.add(new HistoricoPeso(id, alunoId, dataRegistro, peso));
                
            }
            
            for(HistoricoPeso hp : listaDeHistoricos){
                System.out.println(hp);
            }
            
        }
        catch(SQLException u){
            throw new RuntimeException(u);
        }
        finally{
            return listaDeHistoricos;
        }
    }
    
    public List<HistoricoPeso> consultaHistorico (int idRegistro){
        
        List<HistoricoPeso> listaDeHistoricos = new ArrayList<>();
        
        String sql = "SELECT * FROM historico WHERE id = ? ORDER BY data_registro";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idRegistro);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                int alunoId = rs.getInt("aluno_id");
                java.sql.Date dataRegistro = rs.getDate("data_registro");
                float peso = rs.getFloat("peso");

                listaDeHistoricos.add(new HistoricoPeso(id, alunoId, dataRegistro, peso));
                
            }
            
            for(HistoricoPeso hp : listaDeHistoricos){
                System.out.println(hp);
            }
            
        }
        catch(SQLException u){
            throw new RuntimeException(u);
        }
        finally{
            return listaDeHistoricos;
        }
    }
}
