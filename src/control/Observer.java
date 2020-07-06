/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Adroan
 */
public interface Observer {

    public void notificarAVencedor();

    public void notificarBVencedor();

    public void notificarPartidaEncerrada();

    public void notificarApontuou();

    public void notificarBpontuou();
    
}
