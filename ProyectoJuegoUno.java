package uno;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
class prueba {


    public static void main(String[] args) {
        int[] jugador1=new int[128];
        int[] jugador2=new int[128];
        int[] jugador3=new int[128];
        int[] jugador4=new int[128];
        int[] carta=new int[128];
        int[] cartas=new int[128];
        int[] barajas=new int[128];
        int[] bot1=new int[128];
        int[] bot2=new int[128];
        int[] bot3=new int[128];
        int n,jugadores,bots=0,players=0;
        Scanner leer = new Scanner(System.in);

        // esto llena el arreglo de cartas con numeros aleatorios cada vez
        for(int i =0; i<120; i++)
        {

            n= (int) (Math.random() * (10 - 0)) +0;
            carta[i]=n;
            // carta[i]=i;
            //  System.out.println("cartas en la posicion "+i+" es: "+carta[i]);
        }

        cartas=masCartas(carta);

        for(int i =0; i<cartas.length; i++)
        {
            //   System.out.println("cartas en la posicion "+i+" es: "+cartas[i]);
        }

        //ya tenemos las 128 cartas aleatorias

        System.out.println("ingrese los numeros de jugadores (1-4)");
        jugadores=leer.nextInt();



        if (jugadores<1 || jugadores>4) {
            System.out.println("el valor de jugadores no esta permitido");
            System.exit(0);
        }

        System.out.println("ingrese el numero de bots (1-3)");
        bots=leer.nextInt();

        if (bots<1 || bots>3) {
            System.out.println("el valor de jugadores no esta permitido");
            System.exit(0);
        }


        //llenar las cartas de los bots
        switch(jugadores){
            case 1:
                jugador1=repartir(cartas,0,7);

                switch(bots){
                    case 1:
                        bot1=repartir(cartas,7,14);


                        break;
                    case 2:
                        bot1=repartir(cartas,7,14);
                        bot2=repartir(cartas,14,21);




                        break;
                    case 3:
                        bot1=repartir(cartas,7,14);
                        bot2=repartir(cartas,14,21);
                        bot3=repartir(cartas,21,28);




                        break;
                }


                break;

            case 2:
                jugador1=repartir(cartas,0,7);
                jugador2=repartir(cartas,7,14);


                switch(bots){
                    case 1:
                        bot1=repartir(cartas,14,21);


                        break;
                    case 2:
                        bot1=repartir(cartas,14,21);
                        bot2=repartir(cartas,21,28);




                        break;
                    case 3:
                        bot1=repartir(cartas,14,21);
                        bot2=repartir(cartas,21,28);
                        bot3=repartir(cartas,28,35);




                        break;
                }






                break;
            case 3:
                jugador1=repartir(cartas,0,7);
                jugador2=repartir(cartas,7,14);
                jugador3=repartir(cartas,14,21);

                switch(bots){
                    case 1:
                        bot1=repartir(cartas,21,28);


                        break;
                    case 2:
                        bot1=repartir(cartas,21,28);
                        bot2=repartir(cartas,28,35);




                        break;
                    case 3:
                        bot1=repartir(cartas,21,28);
                        bot2=repartir(cartas,28,35);
                        bot3=repartir(cartas,35,42);




                        break;
                }





                break;

            case 4:
                jugador1=repartir(cartas,0,7);
                jugador2=repartir(cartas,7,14);
                jugador3=repartir(cartas,14,21);
                jugador4=repartir(cartas,21,28);

                switch(bots){
                    case 1:
                        bot1=repartir(cartas,28,35);


                        break;
                    case 2:
                        bot1=repartir(cartas,28,35);
                        bot2=repartir(cartas,35,42);




                        break;
                    case 3:
                        bot1=repartir(cartas,28,35);
                        bot2=repartir(cartas,35,42);
                        bot3=repartir(cartas,42,49);




                        break;
                }




                break;
        }





        if (jugadores==1 && bots==1) {
            barajas=baraja(cartas,14, 128);
            for (int i = 0; i < 14; i++) {
                barajas[i]= (int) (Math.random() * (10 - 0)) +0;
            }

            for (int i = 0; i < barajas.length; i++) {
                //         System.out.println(barajas[i]);
            }

            int a=1,opcion,opcionm,opcions,C1=10,C211,eleccion;
            System.out.println("\n\n--------comienzo del juego--------\n\n\n");



            while(true){
                if(a%2==0){
                    seguir(bot1, "bot-1");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //   mostrarCarJ(bot1);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot1, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot1=       quitarCar(bot1,opcion);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot1=     quitarCar(bot1,opcionm);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot1=   quitarCar(bot1,opcions);
                        System.out.println("bot-1 tiro");

                    }else{
                        bot1=  agregarBaraja(bot1,filtroAlt(barajas[127]));


                    }

//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }else{



                    seguir(jugador1, "jugador-1");

                    System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }

                    System.out.println("\n turno del jugador 1 \n cartas actuales \n");
                    mostrarCarJ(jugador1);
                    System.out.print("\n escoja la carta a tirar: ");
                    eleccion=leer.nextInt();

                    if (validar(jugador1,eleccion)) {

                        if(validar(jugador1, eleccion)&& eleccion==opcion){

                            barajas=   agregarBaraja(barajas,eleccion);
                            jugador1=   quitarCar(jugador1,eleccion);

                        }else if(validar(jugador1, eleccion)&& eleccion==opcionm){

                            barajas= agregarBaraja(barajas,eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);

                        }else if(validar(jugador1, eleccion)&&eleccion==opcions){

                            barajas= agregarBaraja(barajas, eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);


                        }else{
                            System.out.println("no tiene la carta del maso, +1carta");
                            jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                        }
                    }else{
                        System.out.println("no posee esa carta, +1carta");
                        jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                    }



//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }



            }




            // jego 1 jugador 2 bots


        }else if (jugadores==1 && bots==2){
            barajas=baraja(cartas,21, 128);
            for (int i = 0; i < 21; i++) {
                barajas[i]= (int) (Math.random() * (10 - 0)) +0;
            }
            int a=1,opcion,opcionm,opcions,C1=10,C211,eleccion;
            System.out.println("\n\n--------comienzo del juego--------\n\n\n");


            while(true){
                if(a%3==2){
                    seguir(bot1, "bot-1");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //          mostrarCarJ(bot1);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot1, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot1=       quitarCar(bot1,opcion);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot1=     quitarCar(bot1,opcionm);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot1=   quitarCar(bot1,opcions);
                        System.out.println("bot-1 tiro");

                    }else{
                        bot1=  agregarBaraja(bot1,filtroAlt(barajas[127]));


                    }

//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }else if (a%3==0){

                    seguir(bot2, "bot-2");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //     mostrarCarJ(bot2);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot2, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot2=       quitarCar(bot2,opcion);
                        System.out.println("bot-2 tiro");

                    }else if(validar(bot2, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot2=     quitarCar(bot2,opcionm);
                        System.out.println("bot-2 tiro");

                    }else if(validar(bot2, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot2=   quitarCar(bot2,opcions);
                        System.out.println("bot-2 tiro");

                    }else{
                        bot2=  agregarBaraja(bot2,filtroAlt(barajas[127]));


                    }

                    a++;

                }else if(a%3==1){



                    seguir(jugador1, "jugador-1");

                    System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }

                    System.out.println("\n turno del jugador 1 \n cartas actuales \n");
                    mostrarCarJ(jugador1);
                    System.out.print("\n escoja la carta a tirar: ");
                    eleccion=leer.nextInt();

                    if (validar(jugador1,eleccion)) {

                        if(validar(jugador1, eleccion)&& eleccion==opcion){

                            barajas=   agregarBaraja(barajas,eleccion);
                            jugador1=   quitarCar(jugador1,eleccion);
                            System.out.println("\n\n siguiente ");

                        }else if(validar(jugador1, eleccion)&& eleccion==opcionm){

                            barajas= agregarBaraja(barajas,eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);
                            System.out.println("\n\n siguente");

                        }else if(validar(jugador1, eleccion)&&eleccion==opcions){

                            barajas= agregarBaraja(barajas, eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);

                        }else{
                            System.out.println("no tiene la carta del maso, +1carta");
                            jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                        }
                    }else{
                        System.out.println("cartano reconocida +1carta");
                        jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                    }



//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }
            }




//
//
//
//                   1 jugador 3 bots


        }else if(jugadores==1 && bots==3){
            barajas=baraja(cartas,28, 128);
            for (int i = 0; i < 28; i++) {
                barajas[i]= (int) (Math.random() * (10 - 0)) +0;
            }
            int a=1,opcion,opcionm,opcions,C1=10,C211,eleccion;
            System.out.println("\n\n--------comienzo del juego--------\n\n\n");

            while(true){
                if(a%4==2){
                    seguir(bot1, "bot-1");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //          mostrarCarJ(bot1);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot1, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot1=       quitarCar(bot1,opcion);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot1=     quitarCar(bot1,opcionm);
                        System.out.println("bot-1 tiro");

                    }else if(validar(bot1, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot1=   quitarCar(bot1,opcions);
                        System.out.println("bot-1 tiro");

                    }else{
                        bot1=  agregarBaraja(bot1,filtroAlt(barajas[127]));


                    }

//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }else if (a%4==3){

                    seguir(bot2, "bot-2");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //      mostrarCarJ(bot2);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot2, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot2=       quitarCar(bot2,opcion);
                        System.out.println("bot-2 tiro");

                    }else if(validar(bot2, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot2=     quitarCar(bot2,opcionm);
                        System.out.println("bot-2 tiro");

                    }else if(validar(bot2, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot2=   quitarCar(bot2,opcions);
                        System.out.println("bot-2 tiro");

                    }else{
                        bot2=  agregarBaraja(bot2,filtroAlt(barajas[127]));


                    }

                    a++;

                }else if (a%4==0){

                    seguir(bot3, "bot-3");

                    // System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    //     mostrarCarJ(bot3);

                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }


                    if(validar(bot3, opcion)){
                        barajas=  agregarBaraja(barajas,opcion);
                        bot3=       quitarCar(bot3,opcion);
                        System.out.println("bot-3 tiro");

                    }else if(validar(bot3, opcionm)){
                        barajas=    agregarBaraja(barajas,opcionm);
                        bot3=     quitarCar(bot3,opcionm);
                        System.out.println("bot-3 tiro");

                    }else if(validar(bot3, opcions)){
                        barajas=   agregarBaraja(barajas, opcions);
                        bot3=   quitarCar(bot3,opcions);
                        System.out.println("bot-3 tiro");

                    }else{
                        bot3=  agregarBaraja(bot3,filtroAlt(barajas[127]));


                    }

                    a++;

                }else if(a%4==1){



                    seguir(jugador1, "jugador-1");

                    System.out.println("\n carta actual-> "+barajas[0]);
                    opcion=barajas[0];
                    if (opcion==0) {
                        opcions=1;
                        opcionm=9;


                    }else if(opcion==9){
                        opcions=0;
                        opcionm=8;
                    }else{
                        opcions=opcion+1;
                        opcionm=opcion-1;
                    }

                    System.out.println("\n turno del jugador 1 \n cartas actuales \n");
                    mostrarCarJ(jugador1);
                    System.out.print("\n escoja la carta a tirar: ");
                    eleccion=leer.nextInt();

                    if (validar(jugador1,eleccion)) {

                        if(validar(jugador1, eleccion)&& eleccion==opcion){

                            barajas=   agregarBaraja(barajas,eleccion);
                            jugador1=   quitarCar(jugador1,eleccion);

                        }else if(validar(jugador1, eleccion)&& eleccion==opcionm){

                            barajas= agregarBaraja(barajas,eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);

                        }else if(validar(jugador1, eleccion)&&eleccion==opcions){

                            barajas= agregarBaraja(barajas, eleccion);
                            jugador1=    quitarCar(jugador1,eleccion);

                        }else{
                            System.out.println("no tiene la carta del maso, +1carta");
                            jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                        }
                    }else{
                        System.out.println("cartano reconocida +1carta");
                        jugador1=    agregarBaraja(jugador1,filtroAlt(barajas[127]));
                    }



//                    for (int i = 0; i < barajas.length; i++) {
//                        System.out.println(barajas[i]);
//                   }
                    a++;
                }
            }













        }else if(jugadores==2 && bots==1){

            barajas=baraja(cartas,21, 128);

        }else if(jugadores==2 && bots==2){

            barajas=baraja(cartas,28, 128);

        }else if(jugadores==2 && bots==3){

            barajas=baraja(cartas,35, 128);

        }else if(jugadores==3 && bots==1){

            barajas=baraja(cartas,28, 128);

        }else if(jugadores==3 && bots==2){

            barajas=baraja(cartas,35, 128);

        }else if(jugadores==3 && bots==3){

            barajas=baraja(cartas,42, 128);

        }else if(jugadores==4 && bots==1){

            barajas=baraja(cartas,35, 128);

        }else if (jugadores==4 && bots==2) {

            barajas=baraja(cartas,42, 128);

        }else if(jugadores==4 && bots==3){

            barajas=baraja(cartas,49, 128);

        }





        //mostrar todas las cartas repartidas
//               System.out.println("\n jugador 1 tiene \n");
//               for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+jugador1[i]);
//
//              }
//
//               System.out.println("\n jugador 2 tiene \n");
//                  for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+jugador2[i]);
//
//              }
//               System.out.println("\n jugador 3 tiene \n");
//                  for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+jugador3[i]);
//
//
//              }   System.out.println("\n jugador 4 tiene \n");
//                  for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+jugador4[i]);
//
//              }
//
//              System.out.println("\n bot 1 tiene \n");
//                 for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+bot1[i]);
//
//              }
//                   System.out.println("\n bot 2 tiene \n");
//                 for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+bot2[i]);
//
//              }
//                   System.out.println("\n bot 3 tiene \n");
//                 for (int i = 0; i < 128; i++) {
//                   System.out.println("la carta "+i+ "es: "+bot3[i]);
//
//              }
//
//
//
//
//
//              for(int i=0; i<barajas.length;i++){
//                  System.out.println("ahora la posicion "+i+" es: "+barajas[i]);
//              }
//






    }

    public static void mostrarCarJ(int[] cartas){
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i]!=-1) {
                System.out.print(" "+cartas[i]+" ");
            }
        }
    }

    public static void seguir(int[] player, String name){
        boolean valor = false;

        for (int i = 0; i <player.length; i++) {
            if (player[i]>-1) {
                valor=true;
            }
        }

        if (!valor) {
            System.out.println("fin del juego \n ----"+name+"---- gano el juego");
            System.exit(0);
        }


    }

    public static int filtroAlt(int var){

        var= (int) (Math.random() * (10 - 0)) +0;

        return var;
    }


    public static boolean validar(int[] cartas, int carta){
        boolean valor =false;
        for (int i = 0; i < cartas.length; i++) {
            if(cartas[i]==carta){
                valor = true;
            }
        }
        return valor;
    }

    public static int[] quitarCar(int[] cartas, int carta){
        int pos=-1;
        for (int i = 0; i < cartas.length; i++) {
            if(cartas[i]==carta){
                pos=i;
            }
        }
        if(pos>-1){
            cartas[pos]=-1;
        }
        return cartas;
    }

    public static int[] agregarBaraja(int[] baraja, int carta){
        int[] array = new int[128];
        array[0]=carta;

        for(int i=1; i<baraja.length; i++){
            array[i]=baraja[i-1];
        }

        return array;
    }

    public static int[] actualizarBarja(int[] baraja, int carta){
        int[] array= new int[128];
        array[0]=carta;
        for (int i = 1; i < baraja.length; i++) {
            array[i]=baraja[i-1];

        }

        return array;
    }






    public static boolean si(int[] player){
        int[] array=new int[128];
        array=player;
        int valor=0;
        boolean si=false;
        for(int i=0; i<128;i++){
            if(array[i]!=-1){
                valor++;
            }
        }
        if(valor<=0){
            si=true;
        }

        return si;
    }

    public static int[] repartir(int[] cartas,int pos,int lim){
        int[] array= new int[128];
        int c=pos;
        for(int i=0;i<7;i++){
            array[i]=cartas[pos];
            pos++;
        }
        for (int i = 7; i < 128; i++) {
            array[i]=-1;
        }
        return array;
    }
    public static int[] baraja(int[] cartas,int pos,int lim){
        int[] array= new int[128];
        for (int i = 0; i < pos; i++) {
            array[i]=-1;
        }


        for(int i=pos;i<lim;i++){
            array[i]=cartas[i];

        }
        return array;
    }



    public static int[] cartasRestantes(int[] cartas, int ini,int lim,int tam){
        int[] array= new int[tam];
        int pos=0;
        for (int i = ini; i <lim; i++) {
            array[pos]=cartas[i];
            pos++;
        }


        return array;
    }




    public static int[] masCartas(int[] cartas){
        int[] array = new int[128];
        int n,aux,rev=0,blo=9;

        array=cartas;
        for(int i=120; i<128; i++){
            n= (int) (Math.random() * (128 - 0)) +0;

            // System.out.println(n);
            aux= array[n];

            if(i%2==0){
                array[n]=0;
            }else{
                array[n]=9;
            }
            array[i]=aux;
        }

        return array;
    }

}