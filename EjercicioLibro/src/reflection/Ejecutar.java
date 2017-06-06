package reflection;

import java.lang.reflect.*;

public class Ejecutar {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		if (args.length >= 3) {
			// Hacemos el programa

			System.out.println("test");

			Class reflectedClass = Class.forName("reflection." + args[0]);

			System.out.println(reflectedClass.getName());

			Method miMethod = reflectedClass.getMethod(args[1], new Class[] { String.class });

			miMethod.invoke(reflectedClass.newInstance(), args[2]);

		}

	}

}
