import model.Filme;
import service.FilmeService;

public class MainTest {

    public static void main(String[] args) {

        FilmeService service = new FilmeService();

        // Teste 1 - erro esperado
        try {
            Filme filme1 = new Filme();
            filme1.setGenero("Ação");
            service.salvar(filme1);
            System.out.println("ERRO: deveria ter dado exceção");
        } catch (Exception e) {
            System.out.println("OK: erro ao salvar filme sem título");
        }

        // Teste 2 - sucesso
        Filme filme2 = new Filme(1, "Matrix", "Ação");
        service.salvar(filme2);

        if (service.listar().size() > 0) {
            System.out.println("OK: filme salvo com sucesso");
        } else {
            System.out.println("ERRO: filme não foi salvo");
        }
    }
}