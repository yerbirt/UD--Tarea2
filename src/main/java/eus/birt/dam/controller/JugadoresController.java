package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.Equipo;
import eus.birt.dam.domain.Jugador;
import eus.birt.dam.repository.EquipoRepository;
import eus.birt.dam.repository.JugadorRepository;

@Controller
public class JugadoresController {
	
	//Añadimos los repositorios de jugador y estudiante
	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;

	//Vamos definiendo los apartados a los que accedera y a donde les llevara
	@GetMapping("/jugadores")
	public String getJugadores(Model model) {
		model.addAttribute("jugadores", jugadorRepository.findAll());
		model.addAttribute("equipos", equipoRepository.findAll());
		return "jugadores/lista";
	}
	
	@GetMapping("/jugadores/nuevo")
	public String initCreationForm(Model model) {
		Jugador jugador = new Jugador();
		model.addAttribute("jugador", jugador);
		return "jugadores/jugadorForm";
	}
	
	
	@PostMapping ("/jugadores/nuevo/submit")
	public String submitCreationForm(@ModelAttribute Jugador jugador) {
		jugadorRepository.save(jugador);
		return "redirect:/jugadores";
	}
	
	
	@GetMapping("jugadores/editar/{id}")
	public String initEditarForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("jugador", jugadorRepository.findById(id));
		return "jugadores/jugadorForm";
	}
	
	@GetMapping("jugadores/borrar/{id}")
	public String initBorrar(@PathVariable("id") int id) {
		jugadorRepository.deleteById(id);
		return "redirect:/jugadores";
	}
	
	@GetMapping("/jugadores/nuevoEquipo")
	public String initCreationFormEquipo(Model model) {
		Equipo equipo = new Equipo();
		model.addAttribute("equipo", equipo);
		return "jugadores/equipoForm";
	}
	
	@PostMapping ("/jugadores/nuevoEquipo/submit")
	public String submitCreationFormEquipo(@ModelAttribute Equipo equipo) {
		equipoRepository.save(equipo);
		return "redirect:/jugadores";
	}
	
	@GetMapping("jugadores/editarEquipo/{id}")
	public String initEditarFormEquipo(@PathVariable("id") int id, Model model) {
		model.addAttribute("equipo", equipoRepository.findById(id));
		return "jugadores/equipoForm";
	}
	
	@GetMapping("jugadores/borrarEquipo/{id}")
	public String initBorrarEquipo(@PathVariable("id") int id) {
		equipoRepository.deleteById(id);
		return "redirect:/jugadores";
	}	
}
