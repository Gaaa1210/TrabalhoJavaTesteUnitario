import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Classe que representa uma conta bancária
public class ContaBancaria {
    private String titular; // Nome do titular da conta
    private BigDecimal saldo; // Saldo disponível na conta
    private BigDecimal limiteCredito; // Limite de crédito da conta
    private List<String> extrato; // Lista que armazena o extrato das transações

    // Construtor da conta bancária
    public ContaBancaria(String titular, BigDecimal saldoInicial, BigDecimal limiteCredito) {
        // Verifica se o saldo inicial ou o limite de crédito são negativos
        if (saldoInicial.compareTo(BigDecimal.ZERO) < 0 || limiteCredito.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Saldo inicial ou limite de crédito não pode ser negativo.");
        }
        this.titular = titular; // Define o titular da conta
        this.saldo = saldoInicial; // Define o saldo inicial da conta
        this.limiteCredito = limiteCredito; // Define o limite de crédito da conta
        this.extrato = new ArrayList<>(); // Inicializa a lista do extrato
        registrarTransacao("Conta criada", saldoInicial); // Registra a criação da conta no extrato
    }

    // Retorna o nome do titular da conta
    public String getTitular() {
        return titular;
    }

    // Retorna o saldo disponível na conta
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Retorna o limite de crédito da conta
    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    // Retorna uma cópia do extrato para evitar modificações externas
    public List<String> getExtrato() {
        return new ArrayList<>(extrato);
    }

    // Método para realizar um depósito na conta
    public void depositar(BigDecimal valor) {
        // Verifica se o valor do depósito é positivo
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo = saldo.add(valor); // Adiciona o valor ao saldo
        registrarTransacao("Depósito", valor); // Registra a transação no extrato
    }

    // Método para realizar um saque na conta
    public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
        // Verifica se o valor do saque é positivo
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        // Verifica se o saque ultrapassa o saldo disponível somado ao limite de crédito
        if (valor.compareTo(saldo.add(limiteCredito)) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque.");
        }
        saldo = saldo.subtract(valor); // Subtrai o valor do saldo
        registrarTransacao("Saque", valor); // Registra a transação no extrato
    }

    // Método para transferir dinheiro para outra conta bancária
    public void transferir(ContaBancaria destino, BigDecimal valor) throws SaldoInsuficienteException {
        this.sacar(valor); // Realiza o saque na conta de origem
        destino.depositar(valor); // Deposita o valor na conta de destino
        registrarTransacao("Transferência para " + destino.getTitular(), valor); // Registra a transação no extrato
    }

    // Método para exibir o extrato da conta
    public void exibirExtrato() {
        System.out.println("Extrato da conta de " + titular + ": ");
        for (String registro : extrato) {
            System.out.println(registro);
        }
    }

    // Método privado para registrar uma transação no extrato
    private void registrarTransacao(String tipoTransacao, BigDecimal valor) {
        String transacao = LocalDateTime.now() + " - " + tipoTransacao + ": R$ " + valor;
        extrato.add(transacao);
    }
}

// Exceção personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
