package main;

import core.Clatzy;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Clatzy clatzy = new Clatzy();

        clatzy.addInstructor("Pedro Wightman", "123456789", "3000000001", "pwightman@uninorte.edu.co");
        clatzy.addInstructor("Miguel Jimeno", "123456780", "3000000002", "majimeno@uninorte.edu.co");
        clatzy.addInstructor("Augusto Salazar", "123456781", "3000000003", "augustosalazar@uninorte.edu.co");
        clatzy.addInstructor("Marlene Duarte", "123456782", "3000000004", "mduarte@uninorte.edu.co");
        clatzy.addInstructor("Gustavo Morales", "123456783", "3000000005", "gmorales@uninorte.edu.co");
        clatzy.addInstructor("Maria Barrios", "123456784", "3000000006", "mbarrios@uninorte.edu.co");
        clatzy.addInstructor("Carolina Alvarado", "123456785", "3000000007", "calvarado@uninorte.edu.co");

        LocalDate date = LocalDate.of(2023, 4, 22);

        clatzy.addCurso(0, "Introduccion a Python", date, 100_000, clatzy.getInstructor(2));
        clatzy.addCurso(1, "Introduccion a Bases de datos", date, 100_000, clatzy.getInstructor(1));
        clatzy.addCurso(2, "Programacion Optima", date, 100_000, clatzy.getInstructor(3));
        clatzy.addCurso(3, "Introduccion a GIS con PosGIS", date, 100_000, clatzy.getInstructor(0));
        clatzy.addCurso(4, "Introduccion a programacion web", date, 150_000, clatzy.getInstructor(2));
        clatzy.addCurso(5, "Introduccion a programacion movil", date, 150_000, clatzy.getInstructor(5));
        clatzy.addCurso(6, "Gerencia de proyectos", date, 150_000, clatzy.getInstructor(6));

        clatzy.addPlan("Plan ilimitado anual", date, 2_000_000, Float.MAX_VALUE);
        clatzy.addPlan("Plan anual igual o menor a 100.000", date, 500_000, 100_000);

        clatzy.addCliente("Pedro Perez", "223456789", "3000000001", "pwightman@uninorte.edu.co");
        clatzy.addCliente("Miguel Jimenez", "223456780", "3000000002", "majimeno@uninorte.edu.co");
        clatzy.addCliente("Augusto Belalcazar", "223456781", "3000000003", "augustosalazar@uninorte.edu.co");
        clatzy.addCliente("Jose Camacho", "223456782", "3000000004", "jcapacho@uninorte.edu.co");
        clatzy.addCliente("Gustavo Moradas", "223456783", "3000000005", "gmorales@uninorte.edu.co");

        clatzy.comprarPlan(clatzy.getCliente(0), clatzy.getPlan(1), date); // El valor del plancliente es el valor actual del plan
        clatzy.comprarPlan(clatzy.getCliente(0), clatzy.getPlan(0), date); // Cliente ya tiene plan, debe fallar

        clatzy.getCliente(0).getPlan(0).setEstadoActivo(false); // El cliente desactiva su plan actual

        clatzy.comprarPlan(clatzy.getCliente(0), clatzy.getPlan(0), date); // El cliente ha adquirido un plan nuevo y no tiene planes activos
        clatzy.comprarPlan(clatzy.getCliente(1), clatzy.getPlan(1), date);
        clatzy.comprarPlan(clatzy.getCliente(4), clatzy.getPlan(0), date);

        // Si el cliente tiene plan, se almacena el valor de ProductoCliente como $0 pues no pago en efectivo por ese curso
        clatzy.comprarCurso(clatzy.getCliente(0), clatzy.getCurso(3), date);
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(5), date); // Cliente tiene plan, pero no cubre esa clase
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(5), date, 150_000);
        clatzy.comprarCurso(clatzy.getCliente(2), clatzy.getCurso(5), date, 149_000); // El cliente no pago lo suficiente
        clatzy.comprarCurso(clatzy.getCliente(2), clatzy.getCurso(5), date, 150_000);
        clatzy.comprarCurso(clatzy.getCliente(3), clatzy.getCurso(2), date, 150_000); // El valor es mayor al del curso
        clatzy.comprarCurso(clatzy.getCliente(3), clatzy.getCurso(2), date, 100_000);
        clatzy.comprarCurso(clatzy.getCliente(4), clatzy.getCurso(0), date);
        clatzy.comprarCurso(clatzy.getCliente(4), clatzy.getCurso(1), date);
        clatzy.comprarCurso(clatzy.getCliente(4), clatzy.getCurso(2), date);
        clatzy.comprarCurso(clatzy.getCliente(2), clatzy.getCurso(0), date, 100_000);
        clatzy.comprarCurso(clatzy.getCliente(0), clatzy.getCurso(3), date); // Debe fallar pues el cliente ya tiene el curso

        // Dado que el usuario tiene plan y este incluye el curso, se debe comprar sin colocar costo y mostrar mensaje de informacion
        clatzy.comprarCurso(clatzy.getCliente(0), clatzy.getCurso(2), date, 100_000);
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(5), date, 150_000); // Como su plan no cubre ese curso, puede comprar la clase
        clatzy.comprarCurso(clatzy.getCliente(2), clatzy.getCurso(1), date, 100_000);
        clatzy.comprarCurso(clatzy.getCliente(3), clatzy.getCurso(1), date, 100_000);
        clatzy.comprarCurso(clatzy.getCliente(3), clatzy.getCurso(1), date, 100_000); // Debe fallar pues el cliente ya tiene el curso

        // Dado que el usuario tiene plan y este incluye el curso, se debe comprar sin colocar costo y mostrar mensaje de informacion
        clatzy.comprarCurso(clatzy.getCliente(4), clatzy.getCurso(6), date, 150_000);
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(2), date);
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(4), date, 150_000);
        clatzy.comprarCurso(clatzy.getCliente(1), clatzy.getCurso(6), date, 150_000);

        System.out.println("\n----------------------------------------");
        System.out.println("El cliente que mas ha pagado en efectivo por cursos es " + clatzy.getClienteMayorIngreso());
        System.out.println("----------------------------------------\n");

        System.out.println("------------- BONIFICACION -------------");
        clatzy.listAll();
    }
}

/**
------------- Resultados -------------

El cliente Pedro Perez compro exitosamente un plan Plan anual igual o menor a 100.000
El cliente Pedro Perez ya tiene un plan activo
El cliente Pedro Perez compro exitosamente un plan Plan ilimitado anual
El cliente Miguel Jimenez compro exitosamente un plan Plan anual igual o menor a 100.000
El cliente Gustavo Moradas compro exitosamente un plan Plan ilimitado anual
El cliente Pedro Perez registro exitosamente el curso Introduccion a GIS con PosGIS
El plan del cliente Miguel Jimenez no cubre el curso Introduccion a programacion movil
El cliente Miguel Jimenez compro exitosamente el curso Introduccion a programacion movil
El cliente Augusto Belalcazar no pago el valor correcto por el curso Introduccion a programacion movil
El cliente Augusto Belalcazar compro exitosamente el curso Introduccion a programacion movil
El cliente Jose Camacho no pago el valor correcto por el curso Programacion Optima
El cliente Jose Camacho compro exitosamente el curso Programacion Optima
El cliente Gustavo Moradas registro exitosamente el curso Introduccion a Python
El cliente Gustavo Moradas registro exitosamente el curso Introduccion a Bases de datos
El cliente Gustavo Moradas registro exitosamente el curso Programacion Optima
El cliente Augusto Belalcazar compro exitosamente el curso Introduccion a Python
El cliente Pedro Perez ya habia registrado el curso Introduccion a GIS con PosGIS
El curso esta incluido en el plan del cliente Pedro Perez, por lo tanto no debe pagar. Se procede a registrar el curso Programacion Optima con costo $0
El cliente Miguel Jimenez ya habia comprado el curso Introduccion a programacion movil
El cliente Augusto Belalcazar compro exitosamente el curso Introduccion a Bases de datos
El cliente Jose Camacho compro exitosamente el curso Introduccion a Bases de datos
El cliente Jose Camacho ya habia comprado el curso Introduccion a Bases de datos
El curso esta incluido en el plan del cliente Gustavo Moradas, por lo tanto no debe pagar. Se procede a registrar el curso Gerencia de proyectos con costo $0
El cliente Miguel Jimenez registro exitosamente el curso Programacion Optima
El cliente Miguel Jimenez compro exitosamente el curso Introduccion a programacion web
El cliente Miguel Jimenez compro exitosamente el curso Gerencia de proyectos

----------------------------------------
El cliente que mas ha pagado en efectivo por cursos es Miguel Jimenez
----------------------------------------

------------- BONIFICACION -------------
Lista de clientes con sus compras:
----------------------------------------
Pedro Perez
Planes:
Plan anual igual o menor a 100.000 2023-04-22 500000.0 False
Plan ilimitado anual 2023-04-22 2000000.0 True

Cursos:
Introduccion a GIS con PosGIS 2023-04-22 0.0 True
Programacion Optima 2023-04-22 0.0 True
----------------------------------------
Miguel Jimenez
Planes:
Plan anual igual o menor a 100.000 2023-04-22 500000.0 True

Cursos:
Introduccion a programacion movil 2023-04-22 150000.0 True
Programacion Optima 2023-04-22 0.0 True
Introduccion a programacion web 2023-04-22 150000.0 True
Gerencia de proyectos 2023-04-22 150000.0 True
----------------------------------------
Augusto Belalcazar
Planes:

Cursos:
Introduccion a programacion movil 2023-04-22 150000.0 True
Introduccion a Python 2023-04-22 100000.0 True
Introduccion a Bases de datos 2023-04-22 100000.0 True
----------------------------------------
Jose Camacho
Planes:

Cursos:
Programacion Optima 2023-04-22 100000.0 True
Introduccion a Bases de datos 2023-04-22 100000.0 True
----------------------------------------
Gustavo Moradas
Planes:
Plan ilimitado anual 2023-04-22 2000000.0 True

Cursos:
Introduccion a Python 2023-04-22 0.0 True
Introduccion a Bases de datos 2023-04-22 0.0 True
Programacion Optima 2023-04-22 0.0 True
Gerencia de proyectos 2023-04-22 0.0 True
*/
