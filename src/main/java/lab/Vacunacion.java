package lab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import java.io.File;


public class
Vacunacion {
    static final Logger logger = Logger.getLogger(Vacunacion.class.getName());

    static Vector<Tarifa> tarifas = new Vector<Tarifa>();

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }


    public static boolean validateUser(String username, String contrasena) throws FileNotFoundException {
        /*File usuarios = new File("usuarios.txt");
        Scanner myReader = new Scanner(usuarios);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }*/
        return true;
    }

    public static void realizarAccion() {
    }

    public static void startProgram() throws FileNotFoundException {
        logger.info("Iniciar sesión");
        logger.info("nombre de usuario:");
        var sc = new Scanner(System.in);
        String username = sc.nextLine();
        logger.info("contraseña:");
        String contrasena = sc.nextLine();
        if (validateUser(username, contrasena)) {
            realizarAccion();
        }else{
            startProgram();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        startProgram();
    }

}