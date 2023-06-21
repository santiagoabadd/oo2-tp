package unla.oo2.grupo24.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.service.imp.MedicionContenedorServiceImp;


import java.time.LocalDateTime;

@Controller
public class MedicionContenedorController {

    @Autowired
    MedicionContenedorServiceImp serviceEstacionamiento;

    @Autowired
    EventoServiceImp serviceEvento;

    @Autowired
    MedicionContenedorServiceImp serviceMedicion;

    @GetMapping("/medicionestacionamiento")
    public String formRegistroEstacionamiento(Model model) {


        return "mediciones/medicionEstacionamiento";
    }

    //SE AGREGA LA MEDICION ATRAVEZ DE UN FORMULARIO PARA FACILITAR EL TESTEO Y NO TENER QUE USAR UN MAIN.CLASS
    @PostMapping("/medicionestacionamiento")
    public String agregarMedicionEstacionamiento(@RequestParam("fechaHora") LocalDateTime fechaHora, @RequestParam("idDispositivo") int idDispositivo,@RequestParam(value = "plazaOcupada", defaultValue = "false") boolean plazaOcupada) {
        //SE BUSCA UN DISPOSITIVO EL DISPOSITIVO AL CUAL QUIERO AÑADIR LA MEDICION
        SensorEstacionamiento sensor=serviceEstacionamiento.getById(idDispositivo);
        //SI EL RESULTADO DE LA MEDICION(EL BOOLEAN) ES IGUAL A EL ESTADO ACTUAL DEL DISPOSITIVO, NO SE AGREGA NINGUN EVENTO YA QUE BASICAMENTE NADA CAMBIO
        if(plazaOcupada!=sensor.isEstadoActual()){

            //SE SETEA EL ESTADO ACTUAL AL RESULTADO DE LA MEDICION
            sensor.setEstadoActual(plazaOcupada);
            MedicionEstacionamiento medicion=new MedicionEstacionamiento(fechaHora,sensor,plazaOcupada);
            //SE AGREGA LA MEDICION
            serviceMedicion.add(medicion);


            //SE CREA EL EVENTO
            String descripcion = plazaOcupada ? "Estacionamiento Ocupado" : "Estacionamiento Libre";
            Evento evento = new Evento(medicion.getFechaHora(), descripcion, sensor);
            //SE AGREGA EL EVENTO
            serviceEvento.add(evento);
        }

        return "mediciones/medicionEstacionamiento";
    }
}