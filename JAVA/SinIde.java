import java.util.*;




public class SinIde{

//constructor
public SinIde(){}

    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Primer Codigo Sin Ide FTW.!! Johnkegd Inside");
        System.out.println();
        /*
        AppMenu m1 = new AppMenu("John", "Garcia", 25,'H',true);

        m1.Menu();
            */

            //Palabras.doResverse();
           // Palabras.Salute();


           // 1- llamando lista de clase hija Palabras metodo Salute()
          /* List<Integer> item = Arrays.asList(1,2);
           System.out.println(Palabras.Salute(item));*/

        // 2- llamando metodo de hijo en instancia padre
        /*
           Palabras p1 = new Child();
           p1.message();*/

        // 3- metodo substring para controlar salida de cadena, importante el metodo String.lenght() para mapear la cadena
           /*System.out.print("ABCD".substring(2,4));*/

     
        // 4-  moviendo items entre constructor de clase
           /*A a = new A("1");

            A c = a;
            a.a1 = new String("3");
            System.out.print(a.a1);
            System.out.print(c.a1);*/
            
            nono();



    }


    static int num1=0, num2=0,num3=0;
   

    public static void nono(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Numero: ");
    num1 = Integer.parseInt(sc.nextLine());
    int cifra =0;

    while(num1 !=0){
        num1 = num1 /10;
        cifra++;
    }
    System.out.println("numero de caracteres: " + cifra);
    




}
}