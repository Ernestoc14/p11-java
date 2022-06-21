// Una empresa tiene 5 máquinas retroexcavadoras(retro-1…retro-5) las cuales trabajan 6 días de la semana.
// Se desea que usted cree un programa utilizando arreglos y funciones que le permita registrar las horas
// trabajadas durante cada día y calcular algunas estadísticas.
// Debe incorporar un menú el cual debe contener las siguientes opciones:
// 1. Registrar las máquinas   // 2. Registrar los días de la semana
// 3. Registrar las horas trabajadas  // 4. Consultar Dia en que se trabajaron mayor cantidad de horas.
// 5. Consultar Porcentajes de Cantidad de Horas trabajadas por día  // 6. Consultar los promedios de horas trabajadas por una máquina X en la semana.
// 7. Consultar cuáles fueron las 2 máquinas que trabajaron un mayor y un menor número de horas durante la semana.
// 8. Salir

import java.util.Scanner;
public class p11 {
    Scanner sn = new Scanner(System.in);
    int [] matricula = new int [5];
    String [] carrera = new String [5];
    double promlocal=0;
    public void MenuOpc(int opc)
    {   //int []vmatricula;
    //     String []vcarrera;
        p11 pr = new p11();
        switch (opc) {
            case 1: //Crear carrera
                pr.CrearCarreras(carrera);
                break;
            case 2: //Registro de Cantidad de Matriculados por Carrera
                pr.RegistroMatriculaXCarrera(matricula, carrera);
                break;
            case 3: //Total de estudiantes matriculados en una Carrera X
                pr.TotalMatriculaXCarrera(matricula, carrera);
                break;
            case 4: //Promedio de estudiantes matriculados
                promlocal=pr.PromMatricula(matricula, carrera);
                break;
            case 5: //Carreras por debajo del promedio de estudiantes matriculados
                pr.CarrerasXDebajoProm(matricula, carrera, promlocal);
                break;
            case 6: //Carrera con mayor cantidad de Matriculados
                pr.CarreraWMayorMatricula(matricula, carrera);
                break;
            case 7: //Salir
                break;
            default:
                break;
        }
    }
    public void CrearCarreras(String[] carrera)  //OPCION 1
    {   //String [] carrera = new String [5]; 
        for(int fi=0; fi<=carrera.length-1;fi++)
        {   System.out.printf("Ingrese la carrera %d: ", fi+1);
            carrera[fi] = sn.nextLine();
        }   
    }
    public void RegistroMatriculaXCarrera(int[] matricula, String[] carrera) //OPCION 2
    {   for(int fi=0; fi<=matricula.length-1;fi++)
        {   System.out.printf("Ingrese la matricula de la carrera %s: ", carrera[fi]);//de %s : ", carrera[fi]); Aqui queria que imprimiera el nombre de la carrrera en lugar del numero 
            matricula[fi] = sn.nextInt();
        } 
    }
    public void TotalMatriculaXCarrera(int matricula[], String carrera[]) //OPCION 3 
    {   for(int fi=0; fi<=matricula.length-1;fi++)
        {   System.out.printf("El total de estudiantes de la carrera %s es de: %d\n", carrera[fi], matricula[fi]);
        } 
    }
    public double PromMatricula(int matricula[], String carrera[]) //OPCION 4
    {   int suma=0;
        double prom=0;
        for(int fi=0; fi<=matricula.length-1;fi++)
        {   suma = suma+matricula[fi];
            prom = (suma/5);
        } 
        System.out.printf("El promedio de estudiantes matriculados es de: %.2f\n", prom);
        return prom;
    }
    public void CarrerasXDebajoProm(int matricula[], String carrera[], double promlocal) //OPCION 5
    {   for(int fi=0; fi<=matricula.length-1;fi++)
        {   if(matricula[fi] < promlocal)
            {   System.out.printf("La carrera de %s esta por debajo del promedio %.2f con %d estudiantes matriculados.\n" ,carrera[fi] ,promlocal ,matricula[fi]);
            }
        } 
    }
    public void CarreraWMayorMatricula(int matricula[], String carrera[]) //OPCION 6
    {   int pos=0, mayor = matricula[0];
        for(int fi=0;fi<matricula.length;fi++)
        {   if(matricula[fi]>mayor)
            {   mayor = matricula[fi];
                pos=fi;
            }
        }
        System.out.printf("La carrera con el mayor numero de matricula es %s con %d estudiantes matriculados.\n" , carrera[pos] ,matricula[pos]);
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        p11 pr = new p11();
        int y=0,opc=0;
        do{ System.out.println("--------------------------------Menu-----------------------------------------------");
            System.out.println("1.Registrar las máquinas ");
            System.out.println("2.Registrar los días de la semana ");
            System.out.println("3.Registrar las horas trabajadas ");
            System.out.println("4.Consultar Dia en que se trabajaron mayor cantidad de horas ");
            System.out.println("5.Consultar Porcentajes de Cantidad de Horas trabajadas por día ");
            System.out.println("6.Consultar los promedios de horas trabajadas por una máquina X en la semana ");
            System.out.println("7.Consultar cuáles fueron las 2 máquinas que trabajaron un mayor y un menor número de horas durante la semana ");
            System.out.println("8.Salir ");
            System.out.print("Introduzca la opcion a realizar:");
            opc = sn.nextInt();
            pr.MenuOpc(opc);
            System.out.print("Desea realizar otra opcion? 1-Si 2-No: ");
            y = sn.nextInt();
        }while(y==1);
        sn.close();
    }
}