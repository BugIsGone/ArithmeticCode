package myClass_05;

/**
 * @author shapemind
 * @create 2022-01-06 10:32
 */
public class MyCode_01_TrieTree {
    public class TrieNode {
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
        }

        public void delete(String word) {
            if (search(word)) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.path--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.map[index].path-- == 1) {
                        node.map[index] = null;
                    }
                    node = node.map[index];
                }
                node.end--;
            }
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[index] - 'a';
                if (node.map[index] == null) {
                    return false;
                }
            }
            return node.end != 0;
        }

    }
}
