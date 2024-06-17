
package io.crud.dao;

import io.crud.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import io.crud.modelo.HistoricoPeso;

public class HistoricoPesoDAO {
        
    private Connection connection;
    
    public HistoricoPesoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(HistoricoPeso historicoPeso) {
        
        // Declaração SQL para adicionar um registro
        String query = "INSERT INTO historico(aluno_id, data_registro, peso) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, historicoPeso.getAlunoId());
            stmt.setDate(2, historicoPeso.getDataRegistro());
            stmt.setFloat(3, historicoPeso.getPeso());
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(HistoricoPeso historicoPeso) {
        
        // Declaração SQL para alterar um registro
        String query = "UPDATE historico SET data_registro = ?, peso = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setDate(1, historicoPeso.getDataRegistro());
            stmt.setFloat(2, historicoPeso.getPeso());
            stmt.setInt(3, historicoPeso.getId());
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int excluirHistorico(int codigo) {
        
        // Declaração SQL para excluir um registro
        String query = "DELETE FROM historico WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, codigo);
            int linhasAfetadas = stmt.executeUpdate();
            stmt.close();
            if (linhasAfetadas > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        catch (SQLException e) {
            return -1;
        }
    }    
    
    public List<Integer> excluirVarios(List<Integer> codigos) {
        List<Integer> resultados = new ArrayList<>();
        for (Integer codigo : codigos) {
            resultados.add(excluirHistorico(codigo));
        }
        return resultados;
    }
    
    public List<HistoricoPeso> consultaByAluno(int idAluno) {
        
        // Declaração SQL para consultar um registro usando o id do aluno
        String query = "SELECT * FROM historico WHERE aluno_id = ? ORDER BY data_registro";
        
        List<HistoricoPeso> listaDeHistoricos = new ArrayList<>();
        
        try {
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                int alunoId = rs.getInt("aluno_id");
                java.sql.Date dataRegistro = rs.getDate("data_registro");
                float peso = rs.getFloat("peso");

                listaDeHistoricos.add(new HistoricoPeso(id, alunoId, dataRegistro, peso));
                
            }
            stmt.close();
            
            //-----------------------//
            // APENAS PARA DEPURAÇÃO //
            //-----------------------//
            for (HistoricoPeso hp : listaDeHistoricos) {
                System.out.println(hp);
            }
            
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            return listaDeHistoricos;
        }
    }
    
    public List<HistoricoPeso> consulta(int idRegistro) {
        
        String query = "SELECT * FROM historico WHERE id = ? ORDER BY data_registro";
        
        List<HistoricoPeso> listaDeHistoricos = new ArrayList<>();
        
        try {
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, idRegistro);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                int alunoId = rs.getInt("aluno_id");
                java.sql.Date dataRegistro = rs.getDate("data_registro");
                float peso = rs.getFloat("peso");

                listaDeHistoricos.add(new HistoricoPeso(id, alunoId, dataRegistro, peso));
                
            }
            stmt.close();
            
            //-----------------------//
            // APENAS PARA DEPURAÇÃO //
            //-----------------------//            
            for (HistoricoPeso hp : listaDeHistoricos) {
                System.out.println(hp);
            }
            
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            return listaDeHistoricos;
        }
    }
}
