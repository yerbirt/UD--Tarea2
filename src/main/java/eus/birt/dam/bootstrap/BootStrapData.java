package eus.birt.dam.bootstrap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Equipo;
import eus.birt.dam.domain.Jugador;
import eus.birt.dam.repository.EquipoRepository;
import eus.birt.dam.repository.JugadorRepository;

//Creamos el bootstrap para añadir un jugador y un equipo
@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Transactional
	@Override
	public void run (String...arg0) throws Exception {
		
		Jugador jugador1 = new Jugador("Stephen", "Curry", 1.95, 89);
		Equipo equipo1 = new Equipo("Warriors", "San Francisco", "Chase Center", 1946);
		
		jugador1.setEquipo(equipo1);
		equipo1.getJugadores().add(jugador1);
		
		jugadorRepository.save(jugador1);
		equipoRepository.save(equipo1);
	}
}
