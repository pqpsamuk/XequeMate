
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import xadrez.Xadrez;
import xadrez.pecas.Peca.Tipo;

public class XadrezTest {
    @Test
    public void testXequeMateEmUmLance()
        throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Xadrez xadrez = new Xadrez(new File("src/test/resources/xequeMateEmUmLance1.txt"));
        assertEquals(Xadrez.Situacao.Em_andamento, xadrez.getSituacao());
        xadrez.jogar("C5B5");
        assertEquals(Xadrez.Situacao.Pretas_em_xeque_mate, xadrez.getSituacao());

        xadrez = new Xadrez(new File("src/test/resources/xequeMateEmUmLance1.txt"));
        List<String> movimentosXequeMate = TestUtil
            .procurarMovimentosXequeMateEmUmLance(xadrez);
        assertEquals(1, movimentosXequeMate.size());
        assertTrue(movimentosXequeMate.contains("C5B5"));

        xadrez = new Xadrez(new File("src/test/resources/xequeMateEmUmLance2.txt"));
        assertEquals(Xadrez.Situacao.Em_andamento, xadrez.getSituacao());
        xadrez.jogar("F2F1C");
        assertEquals(Xadrez.Situacao.Brancas_em_xeque_mate, xadrez.getSituacao());
        xadrez.retornarEstadoAnterior();
        assertEquals(Xadrez.Situacao.Em_andamento, xadrez.getSituacao());
        assertNull(xadrez.get("F1"));
        assertEquals(Tipo.Peao, xadrez.get("F2").getTipo());

        xadrez = new Xadrez(new File("src/test/resources/xequeMateEmUmLance2.txt"));
        movimentosXequeMate = TestUtil.procurarMovimentosXequeMateEmUmLance(xadrez);
        assertEquals(1, movimentosXequeMate.size());
        assertTrue(movimentosXequeMate.contains("F2F1C"));

        xadrez = new Xadrez(new File("src/test/resources/xequeMateEmUmLance3.txt"));
        assertEquals(Xadrez.Situacao.Brancas_em_xeque, xadrez.getSituacao());
        movimentosXequeMate = TestUtil.procurarMovimentosXequeMateEmUmLance(xadrez);
        assertEquals(2, movimentosXequeMate.size());
        assertTrue(movimentosXequeMate.contains("C7D8B"));
        assertTrue(movimentosXequeMate.contains("C7D8D"));
        assertTrue(xadrez.jogar(movimentosXequeMate.get(0)));
        assertEquals(Xadrez.Situacao.Pretas_em_xeque_mate, xadrez.getSituacao());
        xadrez.retornarEstadoAnterior();
        assertEquals(Xadrez.Situacao.Brancas_em_xeque, xadrez.getSituacao());
        assertEquals(Tipo.Torre, xadrez.get("D8").getTipo());
        assertEquals(Tipo.Peao, xadrez.get("C7").getTipo());
    }

}
