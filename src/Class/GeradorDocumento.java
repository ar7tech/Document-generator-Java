package Class;

import java.util.*;

public class GeradorDocumento {
    private final Random gerador = new Random();

    public List<Integer> GerarNumeros(int tamanho){
        List<Integer> numeros = new ArrayList<>();
        for (int x =0; x < tamanho; x++) {
            numeros.add(gerador.nextInt(10));
        }
        return numeros;
    }

    int ValidaDigito(int dv){
        if(dv >= 10){
            dv = 0;
            return dv;
        }
        return dv;
    }

    int CalcularDigitosCpf(List<Integer> nCpf){
        int qnt = nCpf.size();
        if (nCpf.size() < 9 || nCpf.size() > 10) {
            System.out.println("Devem ser informados 9 a 10 numeros! Quantidade informada: " + qnt);
        }
        List<Integer> calcular = new ArrayList<>();
        int multiplo = qnt + 1;
        int resto = 0;
        int dv;
        for(int a = 0; a < qnt; a++){
            calcular.add(nCpf.get(a) * multiplo);
            resto = resto + calcular.get(a);
            multiplo --;
        }
        dv = 11 - (resto % 11);
        return ValidaDigito(dv);
    }

    public String GerarCPF(){
        List<Integer> gerarNumeroCpf = GerarNumeros(9);
        StringBuilder saida = new StringBuilder();
        int cpfDv1 = CalcularDigitosCpf(gerarNumeroCpf);
        gerarNumeroCpf.add(cpfDv1);
        int cpfDv2 = CalcularDigitosCpf(gerarNumeroCpf);
        gerarNumeroCpf.add(cpfDv2);
        for (Integer integer : gerarNumeroCpf) {
            saida.append(integer);
        }
        return saida.toString();
    }

    public String ValidaCPF(String numeroCpf){
        StringBuilder saida = new StringBuilder();
        List<Integer> numeros = new ArrayList<>();
        for(int i = 0; i < numeroCpf.length() - 2; i++){
            numeros.add(numeroCpf.charAt(i) - '0');
        }
        int cpfDv1 = CalcularDigitosCpf(numeros);
        numeros.add(cpfDv1);
        int cpfDv2 = CalcularDigitosCpf(numeros);
        numeros.add(cpfDv2);
        for (Integer numero : numeros) {
            saida.append(numero);
        }
        if(saida.toString().equals(numeroCpf)){
            return "Verdadeiro";
        }
        return "Falso - CPF correto: " + saida;
    }

    int CalcularDigitosCnpj(List<Integer> nCnpj){
        int qnt = nCnpj.size();
        if (nCnpj.size() < 12 || nCnpj.size() > 13) {
            System.out.println("Devem ser informados 12 a 13 numeros! Quantidade informada: " + qnt);
        }
        List<Integer> calcular = new ArrayList<>();
        int multiplo1 = 9;
        int multiplo2 = 9;
        int resto = 0;
        int dv;
        List<Integer> reverso = new ArrayList<>(nCnpj);
        Collections.reverse(reverso);
        for (int a = 0; a < qnt; a++) {
            if (a < 8) {
                calcular.add(reverso.get(a) * multiplo1);
                resto = resto + calcular.get(a);
                multiplo1--;
            }
            if (a >= 8) {
                calcular.add(reverso.get(a) * multiplo2);
                resto = resto + calcular.get(a);
                multiplo2--;
            }
        }
        dv = resto % 11;
        return ValidaDigito(dv);
    }

    public String GerarCNPJ(){
        List<Integer> numeros = GerarNumeros(12);
        List<Integer> gerarNumeroCnpj = new ArrayList<>(numeros);
        StringBuilder saida = new StringBuilder();
        int cnpjDv1 = CalcularDigitosCnpj(gerarNumeroCnpj);
        gerarNumeroCnpj.add(cnpjDv1);
        int cnpjDv2 = CalcularDigitosCnpj(gerarNumeroCnpj);
        gerarNumeroCnpj.add(cnpjDv2);
        for (Integer integer : gerarNumeroCnpj) {
            saida.append(integer);
        }
        return saida.toString();
    }

    public String ValidaCNPJ(String numeroCnpj){
        StringBuilder saida = new StringBuilder();
        List<Integer> numeros = new ArrayList<>();
        for(int i = 0; i < numeroCnpj.length() - 2; i++){
            numeros.add(numeroCnpj.charAt(i) - '0');
        }
        int cnpjDv1 = CalcularDigitosCnpj(numeros);
        numeros.add(cnpjDv1);
        int cnpjDv2 = CalcularDigitosCnpj(numeros);
        numeros.add(cnpjDv2);
        for (Integer numero : numeros) {
            saida.append(numero);
        }
        if(saida.toString().equals(numeroCnpj)){
            return "Verdadeiro";
        }
        return "Falso - CNPJ correto: " + saida;
    }
}