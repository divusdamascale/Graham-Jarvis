package main.java.divusdamascale.problema9;
public class Ord {

    public void merge(Punct[] lS,Punct[] rS, Punct[] S,int lsize, int rsize){

        Punct A = new Punct(4, 4,"A");
      
        int i=0,l=0,r=0;
        //verificam conditiile pentru verificare
        while(l<lsize && r<rsize){
            
            
            if(lS[l].getCadran()>rS[r].getCadran()){
                S[i++] = lS[l++];
            }else if(lS[l].getCadran()==rS[r].getCadran() && (A.determinant(lS[l],A, rS[r]) < 0))
            {
                S[i++] = lS[l++];
            }
            else{
                S[i++] = rS[r++];
            }
        }
        while(l<lsize){
            S[i++] = lS[l++];
        }
        while(r<rsize){        
            S[i++] = rS[r++];
        }
    }
   
        public void ord(Punct [] S,int l){

            if (l < 2){return;}
      
            int mij = l / 2;
            Punct [] lS = new Punct[mij];
            Punct [] rS = new Punct[l-mij];
            
          //Se imparte S in doua si se copiaza in alti doi vectori
            int k = 0;
            for(int i = 0;i<l;++i){
                if(i<mij){
                    lS[i] = S[i];
                }
                else{
                    rS[k] = S[i];
                    k ++;
                }
            }
           
          // Chemam recursiv functia ord pentru a impartii mai departe arrayurile
            ord(lS,mij);
            ord(rS,l-mij);
            
          // Chemam fucntia de unificare pentru fiecare subdivizie in parte
            merge(lS,rS,S,mij,l-mij);
            
        };
    
    
}
