package problems.trie;

import java.util.*;

public class searchSugguestionII {

    public static void main(String[] args) {
        String[] products1 = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String str1 = "mouse";

        System.out.print(doSearchTrie(products1, str1));
    }

    private static List<List<String>> doSearchTrie(String[] products1, String str1) {
        Trie root = new Trie();

        // can add products in correct order, won't be adding if they already contain 3 words
        Arrays.sort(products1);

        for (int i = 0; i < products1.length; i++) {
            root.insertWord(products1[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= str1.length(); i++) {
            result.add(new ArrayList<>(root.findPrefix(str1.substring(0, i))));
        }

        return result;
    }

    private static class Trie {
        WordNode root;

        public Trie() {
            root = new WordNode();
        }

        // add current word at every TrieNode
        public void insertWord(String str) {
            WordNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                WordNode node;
                Map<Character, WordNode> children = cur.children;
                if (children.containsKey(str.charAt(i))) {
                    node = children.get(str.charAt(i));

                    // don't add if products already have 3
                    if (node.products.size() < 3) {
                        node.products.add(str);
                    }
                } else {
                    node = new WordNode(str.charAt(i), str);
                    children.put(str.charAt(i), node);
                }
                cur = node;
            }
        }

        public List<String> findPrefix(String str) {
            WordNode word = findWord(str);
            if (word != null) {
                return word.products;
            }
            return Collections.emptyList();
        }

        private WordNode findWord(String str) {
            Map<Character, WordNode> children = root.children;
            WordNode node = null;
            for (int i = 0; i < str.length(); i++) {
                if (children.containsKey(str.charAt(i))) {
                    node = children.get(str.charAt(i));
                    children = node.children;
                } else {
                    return null;
                }
            }
            return node;
        }

        private class WordNode {
            Map<Character, WordNode> children;
            Character c;
            // List of words up to this WordNode
            List<String> products;

            public WordNode() {
                this.children = new HashMap<>();
                this.products = new ArrayList<>();
            }

            public WordNode(Character c, String str) {
                this.c = c;
                this.children = new HashMap<>();
                this.products = new ArrayList<>();
                products.add(str);
            }
        }
    }
}
