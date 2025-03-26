import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {
    private Conta conta1;
    private Conta conta2;

    // Executado antes de cada teste
    @BeforeEach
    void setUp() {
        conta1 = new Conta("001", "João", 1000);
        conta2 = new Conta("002", "Maria", 500);
    }

    @Test
    void depositoValidoAumentaSaldo() {
        Banco.depositar(conta1, 200);
        assertEquals(1200, conta1.getSaldo());
    }

    @Test
    void depositoValorNegativoGeraErro() {
        assertThrows(IllegalArgumentException.class, () ->
                Banco.depositar(conta1, -100));
    }

    @Test
    void saqueValidoDiminuiSaldo() {
        Banco.sacar(conta1, 200);
        assertEquals(800, conta1.getSaldo());
    }

    @Test
    void saqueSaldoInsuficienteGeraErro() {
        assertThrows(SaldoInsuficienteException.class, () ->
                Banco.sacar(conta1, 2000));
    }

    @Test
    void transferenciaValidaAlteraAmbosSaldos() {
        Banco.transferir(conta1, conta2, 300);
        assertEquals(700, conta1.getSaldo());
        assertEquals(800, conta2.getSaldo());
    }
}