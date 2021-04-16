package algo;

import model.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// O(N*M) === Num of Words * Average individual world length
public class Trie {
    public static class TrieNode {
        // can use TrieNode[] children = new TrieNode[26];
        private HashMap<Character, TrieNode> children;
        private Character c;
        private boolean isLeaf;

        public TrieNode(Character c) {
            this.c = c;
            this.children = new HashMap<>();
        }

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0 ; i < str.length(); i++) {
            TrieNode t;
            if (children.containsKey(str.charAt(i))) {
                t = children.get(str.charAt(i));
            } else {
                t = new TrieNode(str.charAt(i));
                children.put(str.charAt(i), t);
            }

            if (i == str.length()-1) {
                t.isLeaf = true;
            }

            children = t.children;
        }
    }

    public boolean hasWord(String str) {
        TrieNode trieNode = searchWord(str);
        return trieNode !=null && trieNode.isLeaf;
    }

    public boolean startsWith(String str) {
        TrieNode trieNode = searchWord(str);
        return trieNode != null;
    }

    public TrieNode searchWord(String str) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode trieNode = null;
        for (int i = 0; i < str.length(); i++) {
            if (children.containsKey(str.charAt(i))) {
                trieNode = children.get(str.charAt(i));
                children = trieNode.children;
            } else {
                return null;
            }
        }
        return trieNode;
    }
}
