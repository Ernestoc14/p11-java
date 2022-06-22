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
    double [][] HorasTrab = new double[5][6];
    String [] days = new String[6]; //{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};//Solo 6 dias
    int [] Maquinas = new int [5];
    double [] HorasTotalesxDia = new double[6]; //OPC4
    double [] Porcentajes = new double[6]; // OPC5
    double TotaldeHorasTrabajadas=0;
    double [] PromedioxMaq = new double[5]; //OPC6
    public void MenuOpc(int opc)
    {   p11 pr = new p11();
        switch (opc) {
            case 1: //Registrar las máquinas
                pr.RegistrarMaquinas(Maquinas);
                break;
            case 2: //Registrar los días de la semana
                pr.RegistrarDias(days);
                break;
            case 3: //Registrar las horas trabajadas
                pr.RegistrarHoras(HorasTrab, days, Maquinas);
                break;
            case 4: //Consultar Dia en que se trabajaron mayor cantidad de horas
                pr.DiaMayorHorasTrab(HorasTotalesxDia, days, HorasTrab);
                break;
            case 5: //Consultar Porcentajes de Cantidad de Horas trabajadas por día
                pr.PorcentajesHorasxDias(HorasTotalesxDia, days, Porcentajes, TotaldeHorasTrabajadas);
                break;
            case 6: //Consultar los promedios de horas trabajadas por una máquina X en la semana
                pr.PromHrxMaq();
                break;
            case 7: //Consultar cuáles fueron las 2 máquinas que trabajaron un mayor y un menor número de horas durante la semana
                pr.MaqMayMenor();
                break;
            case 8: //Salir
                break;
            default:
                break;
        }
    }
    public void RegistrarMaquinas(int []Maquinas)  //OPCION 1
    {   for(int fi=0; fi<=4;fi++) //Maq
        {   System.out.printf("Ingrese el ID de la Maquina %d: ", fi+1); 
            Maquinas[fi]= sn.nextInt();
        }   
    }
    public void RegistrarDias(String []days) //OPCION 2
    {   for(int fi=0; fi<=5;fi++)
        {   System.out.printf("Ingrese el %d dia que trabajaran las maquinas: ", fi+1);
            days[fi] = sn.nextLine();
        } 
    }
    public void RegistrarHoras(double[][] HorasTrab, String[] days, int[]Maquinas) //OPCION 3 
    {   for(int si=0; si<=5;si++) //Dias
        {   for(int fi=0; fi<=4;fi++) //Maquinas
            {   System.out.printf("\nIngrese las Horas trabajadas en la maquina %d el dia %s : ", Maquinas[fi], days[si]);    
                HorasTrab[fi][si]=sn.nextDouble();
            }
        } 
        // for(int si=0; si<=5;si++) //Dias
        // {   for(int fi=0; fi<=4;fi++) //Maquinas
        //     {   System.out.printf(" %f ", HorasTrab[fi][si]);    
        //     }
        //     System.out.printf("\n");
        // }
    }
    public void DiaMayorHorasTrab(double []HorasTotalesxDia, String[] days, double[][] HorasTrab) //OPCION 4
    {   double mayor=0;
        int pos=0;
        for(int si=0; si<=5;si++) //Dias
        {   for(int fi=0; fi<=4;fi++) //Maquinas
            {   HorasTotalesxDia[si]= HorasTotalesxDia[si] + HorasTrab[fi][si];
            }
        }
        for(int fi=0;fi<=5;fi++)
        {   //System.out.printf(" %.2f \n", HorasTotalesxDia[fi]);
            if(HorasTotalesxDia[fi]>mayor)
            {   mayor = HorasTotalesxDia[fi];
                pos=fi;
            }
        }
       System.out.printf("El dia en el que se trabajaron mas horas fue el %s con %.2f horas \n", days[pos],mayor);
    }
    public void PorcentajesHorasxDias(double []HorasTotalesxDia, String[] days, double[]Porcentajes, double TotaldeHorasTrabajadas) //OPCION 5
    {   
        for(int fi=0; fi<=4;fi++)
        {   TotaldeHorasTrabajadas = TotaldeHorasTrabajadas + HorasTotalesxDia[fi];
        } 
        for(int fi=0; fi<=4;fi++)
        {   Porcentajes[fi] = TotaldeHorasTrabajadas / 6.00;
        }
        for(int fi=0; fi<=4;fi++)
        {   System.out.printf("Porcentaje Horas Trabajadas del dia %s es de %.2f horas \n", days[fi],Porcentajes[fi]);
        }
    }
    public void PromHrxMaq() //OPCION 6
    {
    }
    public void MaqMayMenor() //OPCION 7
    {//    int pos=0, mayor = matricula[0];
    //     for(int fi=0;fi<matricula.length;fi++)
    //     {   if(matricula[fi]>mayor)
    //         {   mayor = matricula[fi];
    //             pos=fi;
    //         }
    //     }
    //     System.out.printf("La carrera con el mayor numero de matricula es %s con %d estudiantes matriculados.\n" , carrera[pos] ,matricula[pos]);
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