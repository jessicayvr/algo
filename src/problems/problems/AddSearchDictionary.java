package problems.problems;

import algo.Trie;

import java.util.HashMap;
import java.util.Map;

public class AddSearchDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        //  System.out.print(wordDictionary.search("dad"));
        System.out.print(wordDictionary.search(".ad"));
    }

    public static class WordDictionary {
        DictNode root;

        public WordDictionary() {
            this.root = new DictNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Map<Character, DictNode> children = root.children;
            for (int i = 0; i < word.length(); i++) {
                DictNode d;
                if (children.containsKey(word.charAt(i))) {
                    d = children.get(word.charAt(i));
                } else {
                    d = new DictNode(word.charAt(i));
                    children.put(word.charAt(i), d);
                }

                if (word.length() - 1 == i) {
                    d.isLeaf = true;
                }
                children = d.children;
            }
        }

        /**
         * Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return helper(root, word, 0);
        }

        private boolean helper(DictNode root, String word, int index) {
            if (index == word.length()) {
                return root.isLeaf;
            }

            if (word.charAt(index) == '.') {
                for (Character c : root.children.keySet()) {
                    if (root.children.containsKey(c)) {
                        if (helper(root.children.get(c), word, index + 1)) {
                            return true;
                        }
                        ;
                    }
                }
                return false;
            } else {

                if (root.children.containsKey(word.charAt(index)) && helper(root.children.get(word.charAt(index)), word, index + 1)) {
                    return true;
                }
                return false;
            }
        }
    }


    private static class DictNode {
        Map<Character, DictNode> children;
        boolean isLeaf;
        Character c;

        public DictNode() {
            this.children = new HashMap<>();
        }

        public DictNode(Character c) {
            this.children = new HashMap<>();
            this.c = c;
        }
    }
}
