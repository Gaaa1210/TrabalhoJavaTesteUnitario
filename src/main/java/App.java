public class App {
    public static void main(String[] args) {
        try {
            // Criação de contas
            Conta contaJoao = new Conta("001", "João", 1000);
            Conta contaMaria = new Conta("002", "Maria", 500);

            // Operações bancárias
            Banco.depositar(contaJoao, 200);
            Banco.sacar(contaJoao, 100);
            Banco.transferir(contaJoao, contaMaria, 300);

            // Resultados
            System.out.println("Saldo João: " + contaJoao.getSaldo());
            System.out.println("Saldo Maria: " + contaMaria.getSaldo());

            // Exemplo de erro (descomente para testar)
            // Banco.sacar(contaJoao, 5000);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}