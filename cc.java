import java.util.*;

public class cc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Trie t = new Trie();
        System.out.println("insert:");
        int n = s.nextInt();
        s.nextLine();
        for (int i=0;i<n;i++) {
            String w=s.nextLine().toLowerCase();
            insert(t, w);
        }
        System.out.println("word to check existence:");
        String check = s.nextLine().toLowerCase();
        System.out.println("Exists :" + exists(t, check));

        System.out.println("words in Trie:");
        List<String> all = new ArrayList<>();
        getAllWords(t, "", all);
        for (String w : all) 
        {
            System.out.println(w);
        }

        System.out.println("Enter prefix:");
        String pref = s.nextLine().toLowerCase();
        List<String> p = getPrefixWords(t, pref);
        for (String w : p)
        {

        System.out.println(w);
        }

        System.out.println("increase count:");
        String inc = s.nextLine().toLowerCase();
        int x = s.nextInt();
        s.nextLine();
        increase(t, inc, x);
        System.out.println("New word count: " + getCount(t, inc));
    }

    public static void insert(Trie r, String str) {
    Trie t = r;
    for (char c : str.toCharArray()) {
        if (c < 'a' || c > 'z') 
        {
            continue; 
        }
        int i = c - 'a';
        if (t.ch[i] == null) t.ch[i] = new Trie();
        t = t.ch[i];
        t.cnt++;
    }
    t.end = true;
}


    public static boolean exists(Trie r, String str) {
        Trie t = r;
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            if (t.ch[i] == null) return false;
            t = t.ch[i];
        }
        return t.end;
    }

    public static void getAllWords(Trie r, String str, List<String> res) {
        if (r.end) res.add(str);
        for (int i = 0; i < 26; i++) {
            if (r.ch[i] != null) {
                getAllWords(r.ch[i], str + (char)(i + 'a'), res);
            }
        }
    }

    public static List<String> getPrefixWords(Trie r, String pre) {
        Trie t = r;
        for (char c : pre.toCharArray()) {
            int i = c - 'a';
            if (t.ch[i] == null) return new ArrayList<>();
            t = t.ch[i];
        }
        List<String> res = new ArrayList<>();
        getAllWords(t, pre, res);
        return res;
    }

    public static void increase(Trie r, String str, int x) {
        Trie t = r;
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            if (t.ch[i] == null) t.ch[i] = new Trie();
            t = t.ch[i];
            t.cnt += x;
        }
        t.end = true;
    }

    public static int getCount(Trie r, String str) {
        Trie t = r;
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            if (t.ch[i] == null) return 0;
            t = t.ch[i];
        }
        return t.cnt;
    }
}

class Trie {
    Trie[] ch = new Trie[26];
    int cnt = 0;
    boolean end = false;
}
