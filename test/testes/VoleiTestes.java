package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.GerenciadorPartida;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adroan
 */
public class VoleiTestes {

    private GerenciadorPartida gPartida = new GerenciadorPartida("timea", "TimeB", "00:00");

    public VoleiTestes() {
    }

    @Test
    public void testeAVencedorSet() {
        for (int i = 0; i < 26; i++) {
            gPartida.atualizarPontuacao("a");
        }
        assertEquals(true, gPartida.isaVence());
    }

    @Test
    public void testeBVencedorSet() {
        for (int i = 0; i < 26; i++) {
            gPartida.atualizarPontuacao("b");
        }
        assertEquals(false, gPartida.isaVence());
    }

}
