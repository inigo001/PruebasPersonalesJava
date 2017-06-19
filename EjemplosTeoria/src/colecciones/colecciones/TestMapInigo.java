package colecciones.colecciones;

import java.util.HashMap;
import java.util.Map;

import colecciones.conduccion.*;

public class TestMapInigo {

	public static void main(String[] args) {

		Map<Dni, Persona> miMapa = new HashMap<Dni, Persona>();
		Persona testPersona = null;

		Dni dni1 = new Dni("02345684", 'x');
		Persona persona1 = new Persona("Adalberto", "Ruiperez", dni1);

		Dni dni2 = new Dni("41523867", 'W');
		Persona persona2 = new Persona("Ambrosio", "Mínguez", dni2);

		Dni dni3 = new Dni("23711892", 'W');
		Persona persona3 = new Persona("Eriberta", "Íñiguez", dni3);

		miMapa.put(dni1, persona1);
		miMapa.put(dni2, persona2);
		miMapa.put(dni3, persona3);

		testPersona = miMapa.get(dni3);
		System.out.println(testPersona);

		// -

		Dni dni4 = new Dni("23711892", 'W');
		Persona persona4 = new Persona("Erminginio", "Albertez", dni4);

		Persona putOut = miMapa.put(dni4, persona4);

		System.out.println("sudiso: " + putOut);
		
		testPersona = miMapa.get(dni3);
		System.out.println(testPersona);
		// ESTO ES RARO RARO RARO :(

		System.out.println("Tamaño: " + miMapa.size());

	}

}
