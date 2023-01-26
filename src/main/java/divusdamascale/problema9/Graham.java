package main.java.divusdamascale.problema9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import divusdamascale.problema9.NewJFrame;

public class Graham {
    Punct O;
    Puncte x = new Puncte();
    ArrayList <Punct> puncte = x.puncte; 
    Ord ord = new Ord();
    Punct [] listaPuncte = new Punct[8];
    ArrayList <Punct> listaFinala = new ArrayList<Punct>();
    

    public ArrayList<Punct> getListaFinala() {
        return listaFinala;
    }

    public Graham()
    {
        //pasul 1 gasirea lui O
        int xO = (puncte.get(0).getX()+puncte.get(1).getX()+puncte.get(2).getX())/3;
        int yO = (puncte.get(0).getY()+puncte.get(1).getY()+puncte.get(2).getY())/3;
        O = new Punct(xO, yO, "O");

        //pasul2 translatarea punctelor

        for (Punct punct : puncte) {
            punct.setX(punct.getX()-O.getX());
            punct.setY(punct.getY()-O.getY());    
        }
        //pasul3
        for (int i = 0; i < listaPuncte.length; i++) {
            listaPuncte[i] = puncte.get(i);
        }

        ord.ord(listaPuncte, listaPuncte.length);
        
        
       
        // System.out.println( Arrays.toString(listaPuncte));
        
        for (int i = 0; i < listaPuncte.length; i++) {
            if(i==0)
            {
                listaPuncte[i].setA(listaPuncte[listaPuncte.length-1]);
                listaPuncte[i].setB(listaPuncte[i+1]);
            }else if(i ==  listaPuncte.length-1)
            {
                listaPuncte[i].setA(listaPuncte[i-1]);
                listaPuncte[i].setB(listaPuncte[0]);
            }else
            {
            listaPuncte[i].setA(listaPuncte[i-1]);
            listaPuncte[i].setB(listaPuncte[i+1]);
            }
            
            
            // System.out.println(i+"."+listaPuncte[i].getNume()+" se duce in "+ listaPuncte[i].getB().getNume());
        }

        List lista = new List<Punct>() {
                
        };
        lista = List.of(listaPuncte);        
        // System.out.println(lista.toString());
        Grh(listaPuncte[2], listaPuncte[2]);

        // System.out.println(listaFinala.toString());
    }

    public void Grh(Punct vm,Punct v)
    {
        while(!v.getB().equals(vm))
        {
            if(v.determinant(v, v.getB(), v.getB().getB())>0)
            {
                v=v.getB();
            }else
            {
                v.setB(v.getB().getB());
                v.getB().getB().setA(v);
                if(!v.equals(vm)){
                    v=v.getA();
                }
            }
        }
        //TODO: de adaugat periferia intr o lista si sa fie transmisa catre main pentru a fi desenata
        int c=0;
        while(c!=2){
            if(v.getNume().equals("G"))
            {
                c++;
            }
            // System.out.println(v.getNume());
            listaFinala.add(v);
            v=v.getB();
        }
    }

    
    
}
