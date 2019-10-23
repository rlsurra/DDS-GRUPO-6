package ar.edu.utn.frba.dds.model.evento.notificador;

import ar.edu.utn.frba.dds.model.evento.Evento;

import javax.annotation.Nonnull;

public class NotificadorAplicacion implements NotificadorEvento {
    @Override
    public void notificar(@Nonnull Evento evento) {
        System.out.println("Se han modificado las condiciones del evento");
        System.out.println("Nuevos atuendos: " + evento.getPosiblesAtuendos());
    }
}
