package subastas;

import java.util.LinkedList;

public class Programa {

	private static Usuario usuario1 = new Usuario("Juan", 100);
	private static Usuario usuario2 = new Usuario("Pedro", 150);
	private static Usuario usuario3 = new Usuario("Enrique", 300);
	private static Usuario[] usuarios;

	public static void main(String[] args) {

		// PRUEBA DE PROGRAMA

		// Rellenamos el array de usuarios con los usuarios que tenemos.
		Programa.usuarios = new Usuario[] { usuario1, usuario2, usuario3 };

		Programa.ejercicioNumero5();
		// Programa.testSubastaLimitada();

	}

	private static void ejercicioNumero4() {

		// Creamos subasta
		Subasta subasta1 = new Subasta("Teléfono Móvil", usuario1);

		subasta1.pujar(usuario2, 100);

		System.out.println(subasta1);

		subasta1.pujar(usuario3, 50);

		System.out.println(subasta1);

		subasta1.ejecutar();
		subasta1.pujar(usuario3, 200);

		System.out.println(subasta1);

		System.out.println("Usuarios:");
		for (int i = 0; i < usuarios.length; i++)
			System.out.println(usuarios[i]);

		System.out.println("Subastas de Usuarios:");
		for (int i = 0; i < usuarios.length; i++)
			System.out.println(usuarios[i].getNombre() + "\t" + usuarios[i].getSubastasPropias());
	}

	private static void testSubastaLimitada() {

		System.out.println("Usuarios:");
		for (int i = 0; i < usuarios.length; i++)
			System.out.println(usuarios[i]);

		Subasta subasta2 = new SubastaTemporal("Basura", usuario2, 3);

		subasta2.pujar(usuario1);
		subasta2.pujar(usuario2);
		subasta2.pujar(usuario3);

		subasta2.ejecutar();

		System.out.println(subasta2);

		subasta2.pujar(usuario1);
		subasta2.pujar(usuario3);
		subasta2.pujar(usuario1);
		subasta2.pujar(usuario3);
		subasta2.pujar(usuario1);
		subasta2.pujar(usuario3);

		System.out.println(subasta2);

		System.out.println("Usuarios:");
		for (int i = 0; i < usuarios.length; i++)
			System.out.println(usuarios[i]);
	}

	private static void ejercicioNumero5() {
		LinkedList<Subasta> subastas = new LinkedList<Subasta>();

		Usuario juan = new Usuario("Juan", 100);
		Usuario enrique = new Usuario("Enrique", 500);

		Subasta subasta1 = new SubastaLimitada("Disco Duro Multimedia", juan, 1);
		Subasta subasta2 = new SubastaMinima("Impresora Láser", juan, 100);

		subastas.add(subasta1);
		subastas.add(subasta2);

		Subasta subastaTemporal = new SubastaTemporal("Teclado", juan, 3);

		subastas.add(subastaTemporal);

		for (int i = 0; i < subastas.size(); i++) {
			subastas.get(i).pujar(enrique, 10);
		}

		for (int i = 0; i < subastas.size(); i++) {

			if (subastas.get(i).getClass().toString().equals("SubastaLimitada")) {
				((SubastaLimitada) subastas.get(i)).getPujasRestantes();
			}

			subastas.get(i).pujar(enrique, 20);
		}

		for (int i = 0; i < subastas.size(); i++) {

			if (subastas.get(i).getClass().toString().equals("SubastaTemporal")) {
				if (((SubastaTemporal) subastas.get(i)).getHorasRestantes() > 0) {
					subastas.get(i).pujar(enrique);
				}
			}
		}

		for (int i = 0; i < subastas.size(); i++) {
			subastas.get(i).ejecutar();

		}

		System.out.println(juan);
		System.out.println(enrique);
	}

}
