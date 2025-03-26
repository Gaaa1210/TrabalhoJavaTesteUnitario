import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String numero;
    private final String titular;
    private double saldo;
    private final List<String> transacoes; // historico de transações

    // Construtor da conta bancária
    public Conta(String numero, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.transacoes = new ArrayList<>();
        registrarTransacao("Conta criada com saldo inicial: " + saldoInicial);
    }

    // Métodos de acesso (getters)
    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    // Retorna cópia do histórico de transações para evitar modificações externas (Proteção do encapsulamento)
    public List<String> getTransacoes() {
        return new ArrayList<>(transacoes); }

    // Registra uma nova transação no histórico
    void registrarTransacao(String descricao) {
        transacoes.add(descricao);
    }

    // Metodo interno para ajustar o saldo
    void alterarSaldo(double valor) {
        this.saldo += valor;
    }
}