import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    @Test
    void criaContaComValoresValidos() {
        // Teste de criação bem-sucedida
        Conta conta = new Conta("001", "João", 1000);
        assertEquals("001", conta.getNumero());
        assertEquals("João", conta.getTitular());
        assertEquals(1000, conta.getSaldo());
    }

    @Test
    void criaContaComSaldoNegativoGeraErro() {
        // Teste de validação no construtor
        assertThrows(IllegalArgumentException.class, () ->
                new Conta("001", "João", -100));
    }

    @Test
    void getTransacoesRetornaCopia() {
        // Teste de encapsulamento (proteção da lista)
        Conta conta = new Conta("001", "João", 1000);
        conta.getTransacoes().add("Transação falsa");

        assertFalse(new Conta("001", "João", 1000)
                .getTransacoes().contains("Transação falsa"));
    }
}