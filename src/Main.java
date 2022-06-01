import Class.GeradorDocumento;

public class Main {

    public static void main(String[] args) {
        GeradorDocumento documento = new GeradorDocumento();

        System.out.println("CPF: " + documento.GerarCPF());
        System.out.println("Validar CPF: " + documento.ValidaCPF("57549506086"));

        System.out.println("CNPJ: " + documento.GerarCNPJ());
        System.out.println("Validar CNPJ: " + documento.ValidaCNPJ("86305002170611"));

    }
}