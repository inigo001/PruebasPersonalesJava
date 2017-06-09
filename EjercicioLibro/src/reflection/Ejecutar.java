package reflection;

import java.lang.reflect.*;

public class Ejecutar {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		if (args.length >= 3) {
			// Hacemos el programa

			try {
				Class<?> reflectedClass = Class.forName("reflection." + args[0]);

				Object reflectedObject = reflectedClass.newInstance();

				if (reflectedObject instanceof Pizarra) {

					Method miMethod = reflectedClass.getMethod(args[1], new Class[] { String.class });

					if (miMethod != null) {
						miMethod.invoke(reflectedObject, args[2]);
					}

				} else {
					System.out.println("¡¡¡¡LA CLASE " + args[0] + " EXISTE, PERO TIENE QUE SER PIZARRA!!!!");
				}

			} catch (ClassNotFoundException e) {
				System.out.println("LA CLASE " + args[0] + " NO EXISTE MENDRUGO");
			} catch (NoSuchMethodException | SecurityException e) {
				System.out.println("PROBLEMAS CON EL MÉTODO");
			}

		}

	}

}
