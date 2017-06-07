package reflection;

import java.lang.reflect.*;

public class Ejecutar {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		if (args.length >= 3) {
			// Hacemos el programa

			Class<?> reflectedClass = Class.forName("reflection." + args[0]);

			if (reflectedClass.getName() == "reflection.Pizarra") {

				Object reflectedObject = reflectedClass.newInstance();

				Method miMethod = reflectedClass.getMethod(args[1], new Class[] { String.class });

				if (miMethod != null) {
					miMethod.invoke(reflectedObject, args[2]);
				}
			}

		}

	}

}
