package test;

import model.Filme;
import service.FilmeService;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilmeServiceTest {

    @Test(expected = RuntimeException.class)
    public void testeSalvarFilmeSemTitulo() {
        FilmeService service = new FilmeService();

        Filme filme = new Filme();
        filme.setGenero("Ação");

        service.salvar(filme);
    }

    @Test
    public void testeSalvarFilmeComTitulo() {
        FilmeService service = new FilmeService();

        Filme filme = new Filme(1, "Matrix", "Ação");

        service.salvar(filme);

        assertTrue(service.listar().size() > 0);
    }
}