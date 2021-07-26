package lab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import java.io.File;


public class
Vacunacion {
    static final Logger logger = Logger.getLogger(Vacunacion.class.getName());

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }


    public static boolean validateUser(String username, String contrasena) throws FileNotFoundException {
        Scanner s = new Scanner(new File("usuarios.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        var len = list.size();
        if (username.equals("mateonoel2") || username.equals("jesusbellido")) {
            return true;
        }
        return false;
    }

    public static void visualizarInfo(){

    }

    public static void alta() throws FileNotFoundException {
        Scanner s = new Scanner(new File("centrosVacunacion.txt"));
    }

    public static void baja() throws FileNotFoundException {
        Scanner s = new Scanner(new File("cantrosVacunacion.txt"));
    }

    public static void realizarAccion() throws FileNotFoundException {
        logger.info("Elija una acción a realizar, ingresar un número del 1 al 4");
        logger.info("1. Visualizar información consolidada\n" +
                        "2. Dar de alta un centro de vacunación\n" +
                        "3. Dar de baja un centro de vacunación\n" +
                        "4. Cerrar sesión");
        var sc2 = new Scanner(System.in);
        var accion = sc2.nextInt();
        if (accion == 1){
            visualizarInfo();
        }
        else if(accion == 2){
            alta();
        }
        else if(accion == 3){
            baja();
        }
        else if(accion == 4){
            startProgram();
        }
        else{
            realizarAccion();
        }
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