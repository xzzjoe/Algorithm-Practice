import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap <Integer, List<Character>> map = new HashMap<>();
        map.put(1, new ArrayList<Character>(){{add(' ');}});
        map.put(2, new ArrayList<Character>(){{
            add('a');
            add('b');
            add('c');
            }});
        map.put(3, new ArrayList<Character>(){{
            add('d');
            add('e');
            add('f');
            }});
        map.put(4, new ArrayList<Character>(){{
            add('g');
            add('h');
            add('i');
            }});
        map.put(5, new ArrayList<Character>(){{
            add('j');
            add('k');
            add('l');
            }});
        map.put(6, new ArrayList<Character>(){{
            add('m');
            add('n');
            add('o');
            }});
        map.put(7, new ArrayList<Character>(){{
            add('p');
            add('q');
            add('r');
            add('s');
            }});
        map.put(8, new ArrayList<Character>(){{
            add('t');
            add('u');
            add('v');
            }});
        map.put(9, new ArrayList<Character>(){{
            add('w');
            add('x');
            add('y');
            add('z');
            }});
    }
}