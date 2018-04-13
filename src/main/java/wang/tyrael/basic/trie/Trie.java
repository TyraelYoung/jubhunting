package wang.tyrael.basic.trie;

/**
 * @author: wangchao
 */
public class Trie {
    Node root;

    public Node create(){
        root = new Node(26);
        return root;
    }

    public void insert(String s){
        //逐个查找，找不到则建点
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            int index = order(s.charAt(0));
            Node child = node.children[index];
            if(child == null){
                child = new Node(26);
                node.children[index] = child;
                node = child;
            }else{
                node = child;
            }
        }
        node.leaf = s;
    }

    public boolean search(String s){
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            int index = order(s.charAt(0));
            Node child = node.children[index];
            if(child == null){
                return false;
            }else{
                node = child;
            }
        }
        //如果该词是其他词的前缀，也不存在。
        return node.leaf != null;
    }

    public int order(char a){
        return a - 'a';
    }
}
