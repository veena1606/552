import java.util.*;
public class training
{
    public static void main(String[] args)
    {
       Trie trie =new Trie();
       Scanner sc=new Scanner(System.in);
       
    }
    void insert(Trie root,String s)
    {
        Trie te=root;
        for(char c:s.tocharArray()){
            int i=c-'a';
            if(te.c[i]!=null)
            {
                te.c[i]=new Trie();
            }
            te=te.c[i];
            te.wc++;
        }
        te.ended=true;


    }
    void help(Trie root,List<String>li,String te)
    {
        if(root.ended)
        {
            li.add(te);

        }
        for(int i-0;i<26;i++)
        {
            if(root.c[i]!=null)
            {
                char ch=(char)(i+'0');
                help(root.c[i],li,te+c);

            }
        }
    }
}
class Trie{
    Trie ch();
    int wc;
    boolean ended;
    Trie
    {
        ch=new Trie[26];
        wc=0;
        ended=false;
    }
}