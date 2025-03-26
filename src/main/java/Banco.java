public class Banco {
    // Realiza depósito na conta
    public static void depositar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo"); // Se valor for inválido
        }

        conta.alterarSaldo(valor);
        conta.registrarTransacao("Depósito: +" + valor);
    }

    // Realiza saque na conta
    public static void sacar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > conta.getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        conta.alterarSaldo(-valor);
        conta.registrarTransacao("Saque: -" + valor);
    }

    // Transfere valor entre contas
    // SaldoInsuficienteException Se origem não tiver saldo suficiente
    public static void transferir(Conta origem, Conta destino, double valor) {
        sacar(origem, valor);  // Reusa a lógica de saque
        depositar(destino, valor);  // Reusa a lógica de depósito
        origem.registrarTransacao("Transferência para " + destino.getNumero() + ": -" + valor);
        destino.registrarTransacao("Transferência de " + origem.getNumero() + ": +" + valor);
    }
}

    // Exceção personalizada para saldo insuficiente
    // Herda de RuntimeException (não checada)
class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}