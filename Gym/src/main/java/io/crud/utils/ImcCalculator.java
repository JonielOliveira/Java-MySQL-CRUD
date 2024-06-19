
package io.crud.utils;

import io.crud.modelo.Aluno;

public class ImcCalculator {
   
    public static float imc(Aluno aluno){
        float peso = aluno.getPeso();
        float altura = aluno.getAltura();     
        return peso/(altura * altura);
    }
    
    public static String result(Aluno aluno){
        float valor = imc(aluno);
        String resultado = "";       
        
        if(valor >= 0 && valor < 17){
            resultado = "muito abaixo do peso";
        }
        else if(valor < 18.6){
            resultado = "abaixo do peso";
        }
        else if(valor < 25){
            resultado = "peso normal";
        }
        else if(valor < 30){
            resultado = "acima do peso";
        }
        else if(valor < 35){
            resultado = "obesidade grau I";
        }
        else if(valor < 40){
            resultado = "obesidade grau II";
        }
        else{
            resultado = "obesidade grau III";
        }
        return resultado;
    }
    
    
    public static String report(Aluno aluno){
        String hoje = DateConverter.today("dd/MM/yyyy");
        String cpf = aluno.getCpf();
        String nome = aluno.getNome();
        String peso = String.format("%.1f", aluno.getPeso());
        String altura = String.format("%.2f", aluno.getAltura());
        String valorImc = String.format("%.2f", imc(aluno));
        String resultado = result(aluno);
        return "Data: " + hoje +
               "\nCPF: " + cpf +
               "\nNome: " + nome +
               "\nPeso: " + peso + " kg" +
               "\nAltura: " + altura + " m" +
               "\nIMC: " + valorImc + " kg/m\u00B2" +
               "\nClassificação: " + resultado;                
    }
    
    
}
