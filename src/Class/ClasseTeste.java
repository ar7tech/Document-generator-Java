package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClasseTeste {

    static Random gerador = new Random();

    public List<Integer> GerarNumeros(int tamanho){
        List<Integer> numeros = new ArrayList<>();
        for (int x =0; x < tamanho; x++) {
            numeros.add(gerador.nextInt(10));;
        }
        return numeros;
    }

    public int ValidaDigito(int dv){
        if(dv >= 10){
            dv = 0;
            return dv;
        }
        return dv;
    }

    public int CalcularDigitosCpf(List<Integer> nCpf){
        int qnt = nCpf.size();
        List<Integer> calcular = new ArrayList<>();
        int multiplo = qnt + 1;
        int resto = 0;
        int dv;
        for(int a = 0; a < qnt; a++){
            calcular.add(nCpf.get(a) * multiplo);
            resto = resto + calcular.get(a);;
            multiplo --;
        }
        dv = 11 - (resto % 11);
        return ValidaDigito(dv);
    }

    public String GerarCPF(){
        List<Integer> gerarNumeroCpf = GerarNumeros(9);
        String saida = "";
        int cpfDv1 = CalcularDigitosCpf(gerarNumeroCpf);
        gerarNumeroCpf.add(cpfDv1);
        int cpfDv2 = CalcularDigitosCpf(gerarNumeroCpf);
        gerarNumeroCpf.add(cpfDv2);
        for (int x = 0; x < gerarNumeroCpf.size(); x++) {
            saida += gerarNumeroCpf.get(x);
        }
        return saida;
    }

    public String ValidaCPF(String nCpf){
        String saida = "";
        List<Integer> numeros = new ArrayList<>();
        for(int i = 0; i < nCpf.length() - 2; i++){
            numeros.add(nCpf.charAt(i) - '0');
        }
        int cpfDv1 = CalcularDigitosCpf(numeros);
        numeros.add(cpfDv1);
        int cpfDv2 = CalcularDigitosCpf(numeros);
        numeros.add(cpfDv2);
        for (int x = 0; x < numeros.size(); x++) {
            saida += numeros.get(x);
        }
        if(saida.equals(nCpf)){
            return "Verdadeiro";
        }
        return "Falso - CPF correto: " + saida;
    }

    public int CalcularDigitosCnpjBkp(int[] nCnpj){
        int qnt = 0;
        if(nCnpj.length == 12){
            qnt = nCnpj.length - 4;
        }
        else {
            qnt = nCnpj.length - 5;
        }
        int[] calcular = new int[qnt];
        int multiplo = 2;
        int resto = 0;
        int dv;
        for(int a = 0; a < qnt; a++){
            calcular[a] = nCnpj[a] * multiplo;
            resto = resto + calcular[a];;
            multiplo ++;
        }
        qnt = calcular.length;
        multiplo = 2;
        for(int b = 8; b < qnt; b++){
            calcular[b] = calcular[b] * multiplo;
            resto = resto + calcular[b];
            multiplo ++;
        }
        dv = 11 - (resto % 11);
        return ValidaDigito(dv);
    }

    public int CalcularDigitosCnpj(int[] nCnpj){
        int qnt = 0;
        if(nCnpj.length == 12){
            qnt = nCnpj.length - 4;
        } else if(nCnpj.length == 13){
            qnt = nCnpj.length - 5;
        } else {
            return 35505;
        }
        int[] calcular = new int[qnt];
        int multiplo = 14;
        int resto = 0;
        int dv;
        for(int a = 0; a < qnt; a++){
            calcular[a] = nCnpj[a] * multiplo;
            resto = resto + calcular[a];;
            multiplo --;
            System.out.println("nCnpj: " + nCnpj[a] + "" + "\ncalcular: " + calcular[a]);
        }
        qnt = calcular.length;
        multiplo = 14;
        for(int b = 8; b < qnt; b++){
            calcular[b] = calcular[b] * multiplo;
            resto = resto + calcular[b];
            multiplo ++;
        }
        dv = 11 - (resto % 11);
        return ValidaDigito(dv);
    }

}
