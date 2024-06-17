
package io.crud.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class HistoricoPeso {
    
    private int id;
    private int alunoId;
    private Date dataRegistro;
    private float peso;
    
    public HistoricoPeso(int id, int alunoId, Date dataRegistro, float peso){
        this.id = id;
        this.alunoId = alunoId;
        this.peso = peso;
        this.dataRegistro = dataRegistro;
    }
    
    public HistoricoPeso(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int codigo) {
        this.id = codigo;
    }
    
    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }
    
    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }    
     
    public String getDataRegistroFormatada(){
        SimpleDateFormat fmtDesejado = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascFormatada = fmtDesejado.format(dataRegistro);
        return dataNascFormatada;
    }
    
    public boolean verificaDataRegistro(String dataRegistro){
        int tamanho = dataRegistro.length();
        if(tamanho != 10){
            return false;
        }
        if(dataRegistro.indexOf("/") == -1){
            return false;
        }
        String partes[] = dataRegistro.split("/");
        if(partes.length != 3){
            return false;
        }
        if(partes[0].length() == 2 & partes[1].length() == 2 & partes[2].length() == 4){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        
        String dataRegistroFormatada = this.getDataRegistroFormatada();
        return "ID: " + id +
               ", Data de Registro: " + dataRegistroFormatada +
               ", Peso: " + peso;
    
    }
  
}
