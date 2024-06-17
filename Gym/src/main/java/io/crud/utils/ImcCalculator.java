
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
        if(0 <= valor & valor < 16){
            resultado = "magreza grave";
        }
        else if(valor < 17){
            resultado = "magreza moderada";
        }
        else if(valor < 18.6){
            resultado = "magreza leve";
        }
        else if(valor < 25){
            resultado = "peso ideal";
        }
        else if(valor < 30){
            resultado = "sobrepeso";
        }
        else if(valor < 35){
            resultado = "obesidade grau I";
        }
        else if(valor < 40){
            resultado = "obesidade grau II ou severa";
        }
        else{
            resultado = "obesidade grau III ou mórbida";
        }
        return resultado;
    }
    
    
    public static String report(Aluno aluno){
        String hoje = DateConverter.today("dd/MM/yyyy");
        String cpf = aluno.getCpf();
        String nome = aluno.getNome();
        String valorImc = String.format("%.2f", imc(aluno));
        String resultado = result(aluno);
        return "Data: " + hoje +
               "\nCPF: " + cpf +
               "\nNome: " + nome +
               "\nIMC: " + valorImc +
               "\nAvaliação: " + resultado;                
    }
    
    
}
