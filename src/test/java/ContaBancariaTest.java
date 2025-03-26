//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.math.BigDecimal;
//import static org.junit.jupiter.api.Assertions.*;
//
//// Classe de teste para a ContaBancaria
//public class ContaBancariaTest {
//    private ContaBancaria conta; // Instância da conta bancária para os testes
//
//    // Método que configura o ambiente antes de cada teste
//    @BeforeEach
//    public void setup() {
//        conta = new ContaBancaria("João", new BigDecimal("1000.00"), new BigDecimal("500.00"));
//    }
//
//    // Testa se a conta foi criada corretamente
//    @Test
//    public void testContaCriadaComSaldoInicialValido() {
//        assertNotNull(conta); // Verifica se a conta foi instanciada
//        assertEquals("João", conta.getTitular()); // Verifica o nome do titular
//        assertEquals(new BigDecimal("1000.00"), conta.getSaldo()); // Verifica o saldo inicial
//        assertEquals(new BigDecimal("500.00"), conta.getLimiteCredito()); // Verifica o limite de crédito
//    }
//
//    // Testa se um depósito válido é realizado corretamente
//    @Test
//    public void testDepositarValorPositivo() {
//        conta.depositar(new BigDecimal("200.00"));
//        assertEquals(new BigDecimal("1200.00"), conta.getSaldo());
//    }
//
//    // Testa se um depósito negativo gera uma exceção
//    @Test
//    public void testDepositarValorNegativo() {
//        assertThrows(IllegalArgumentException.class, () -> conta.depositar(new BigDecimal("-200.00")));
//    }
//
//    // Testa se um saque válido é realizado corretamente
//    @Test
//    public void testSacarValorValido() throws SaldoInsuficienteException {
//        conta.sacar(new BigDecimal("300.00"));
//        assertEquals(new BigDecimal("700.00"), conta.getSaldo());
//    }
//
//    // Testa se um saque maior que o saldo disponível + limite de crédito gera exceção
//    @Test
//    public void testSacarValorMaiorQueSaldoLimite() {
//        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(new BigDecimal("1601.00")));
//    }
//
//    // Testa se um saque de valor negativo gera uma exceção
//    @Test
//    public void testSacarValorNegativo() {
//        assertThrows(IllegalArgumentException.class, () -> conta.sacar(new BigDecimal("-100.00")));
//    }
//
//    // Testa se a transferência entre contas ocorre corretamente
//    @Test
//    public void testTransferirValorValido() throws SaldoInsuficienteException {
//        ContaBancaria contaDestino = new ContaBancaria("Maria", new BigDecimal("500.00"), new BigDecimal("300.00"));
//        conta.transferir(contaDestino, new BigDecimal("300.00"));
//
//        assertEquals(new BigDecimal("700.00"), conta.getSaldo());
//        assertEquals(new BigDecimal("800.00"), contaDestino.getSaldo());
//    }
//
//    // Testa se uma transferência com saldo insuficiente gera exceção
//    @Test
//    public void testTransferirValorComSaldoInsuficiente() {
//        ContaBancaria contaDestino = new ContaBancaria("Maria", new BigDecimal("500.00"), new BigDecimal("300.00"));
//        assertThrows(SaldoInsuficienteException.class, () -> conta.transferir(contaDestino, new BigDecimal("1601.00")));
//    }
//
//    // Testa se a criação de conta com saldo negativo gera exceção
//    @Test
//    public void testCriarContaComSaldoNegativo() {
//        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("João", new BigDecimal("-100.00"), new BigDecimal("500.00")));
//    }
//
//    // Testa se a criação de conta com limite de crédito negativo gera exceção
//    @Test
//    public void testCriarContaComLimiteCreditoNegativo() {
//        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("João", new BigDecimal("1000.00"), new BigDecimal("-500.00")));
//    }
//
//    // Testa se o extrato registra corretamente as transações realizadas
//    @Test
//    public void testExtratoRegistraTransacoes() throws SaldoInsuficienteException {
//        conta.depositar(new BigDecimal("200.00"));
//        conta.sacar(new BigDecimal("100.00"));
//
//        assertTrue(conta.getExtrato().stream().anyMatch(e -> e.contains("Depósito: R$ 200.00")));
//        assertTrue(conta.getExtrato().stream().anyMatch(e -> e.contains("Saque: R$ 100.00")));
//    }
//}
//
//
