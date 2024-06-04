
package modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class HistoricoPeso {
    
    private int codigo;
    private Date dataRegistro;
    private float peso;
    
    public HistoricoPeso(int codigo, Date dataRegistro, float peso){
        this.codigo = codigo;
        this.peso = peso;
        this.dataRegistro = dataRegistro;
    }
    
    public HistoricoPeso(){
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "ID: " + codigo +
               ", Data de Registro: " + dataRegistroFormatada +
               ", Peso: " + peso;
    
    }
  
}
