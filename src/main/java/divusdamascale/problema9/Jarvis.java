package main.java.divusdamascale.problema9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Jarvis {

    private Puncte a = new Puncte();
    // private ArrayList <Punct> ListaVarfuri = a.puncte;
    
    Punct []  P = a.puncte.toArray(new Punct[0]);

   

    public Punct[] getP() {
        return P;
    }


    public Jarvis()
    {

        
    }


    public static int orientare(Punct p, Punct q, Punct r)
    {
        int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                  (q.getX() - p.getX()) * (r.getY() - q.getY());
       
        if (val == 0) return 0;  //coliniare (incercam sa evitam)
        return (val > 0)? 1: 2; //daca determinantul este mai mare ca 0 este in sens invers trig altfel in sens directr trig 
    }


    
    public ArrayList JarvisAlg(Punct varfuri[], int n)
    {
        
       
        ArrayList<Punct> frontiera = new ArrayList<Punct>();
       
        // se gaseste punctul cel mai din stanga
        int l = 0;
        for (int i = 1; i < n; i++)
            if (varfuri[i].getX() < varfuri[l].getX())
                l = i;
       
        //  Incepem din cel mai din stanga punct si be miscan in secns direct trigonometric pana gasim punctul cu panta maxima
        
        int p = l, q;
        do
        {
            //il adaugam la multime
            frontiera.add(varfuri[p]);
       
            
            q = (p + 1) % n;
              
            for (int i = 0; i < n; i++)
            {
             
               if (orientare(varfuri[p], varfuri[i], varfuri[q])
                                                                     == 2)
                   q = i;
            }
       
           
            p = q;
       
        } while (p != l);  
       
       return frontiera;
       
        // for (Punct temp : frontiera)
        //     System.out.println("(" + temp.getX()+ ", " +
        //                         temp.getY() + "," + temp.getNume()+ ")");
    }
    
}
