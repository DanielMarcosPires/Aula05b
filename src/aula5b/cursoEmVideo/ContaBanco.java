package aula5b.cursoEmVideo;

import java.util.Scanner;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private int saldo;
    private Boolean status = false;

    public ContaBanco() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("O que deseja fazer?");
            System.out.print(
                    """
                        1={Abrir conta},
                        2={fecharConta},
                        3={depositar},
                        4={sacar},
                        5={pagarMensal}
                        6={Visualizar conta}
                        7={Encerrar}
                    >""");

            int resposta = scanner.nextInt();

            if(resposta < 7){
                switch (resposta) {
                    case (1) -> abrirConta();
                    case (2) -> fecharConta();
                    case (3) -> depositar(scanner.nextInt());
                    case (4) -> sacar(scanner.nextInt());
                    case (5) -> pagarMensal();
                    default -> visualizar();
                }
            }else{
                break;
            }
        }
    }
    public void abrirConta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CC ou CP");
        setNumConta(1);
        setDono("Daniel");
        setTipo(scanner.nextLine());
        setStatus(true);
        if(getTipo().equals("CC")){
            setSaldo(50);
        }else if(getTipo().equals("CP")){
            setSaldo(150);
        }else{
            System.out.println("Tipo inválido");
        }
    }
    public void fecharConta(){
        if(getSaldo() > 0){
            System.out.println("Não podemos fechar a conta com saldo!");
        }else if(getSaldo() < 0){
            System.out.println("Não podemos fechar a conta em débito");
        }else{
            System.out.println("Conta fechado!");
            setStatus(false);
        }
    }

    public void depositar(int valor){
        if(getStatus().equals(true)){
            setSaldo(getSaldo() + valor);
        }else{
            System.out.println("Impossível depositar");
        }
    }
    public void sacar(int valor){
        if(getStatus().equals(true) && getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    public void pagarMensal(){
        int valor = 0;
        if(getTipo().equals("CC")){
            valor = 12;
        }else if(getTipo().equals("CP")){
            valor = 20;
        }
        if(getStatus().equals(true) && getSaldo() > valor){
            setSaldo(getSaldo()-valor);
        }else{
            System.out.println("Impossível sacar");
        }
    }
    public void visualizar(){
        System.out.println("=========================");
        System.out.println("NumConta: "+ getNumConta());
        System.out.println("Dono: "+ getDono());
        System.out.println("Status: "+ getStatus());
        System.out.println("Saldo: "+  getSaldo());
        System.out.println("=========================");
    }

    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

}
