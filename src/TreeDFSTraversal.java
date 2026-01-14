import java.util.ArrayList;
import java.util.List;

public class TreeDFSTraversal {
        private Node root;
        private class Node {
            private int value;
            private Node leftChild;
            private Node rightChild;

            Node(int value) {
                this.value = value;
            }
        }

        public void insert(int value) {
            if (root == null) {
                root = new Node(value);
                return;
            }
            var node = new Node(value);
            var current = root;

            while (true) {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }else {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }

        public void insertRec(int value) {
            root = insert(root, value);
        }

        public void preOrder(Node root){
            if (root == null) return;
            System.out.println(root.value);

            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }

        public void inOrder(Node root ){
            if (root == null) return;

            inOrder(root.leftChild);
            System.out.println(root.value);
            inOrder(root.rightChild);
        }

        public void postOrder(Node root){
            if (root == null) return;

            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.value);
        }



        private Node insert(Node node, int value) {
            if (node == null)
                return new Node(value);

            if (value < node.value)
                node.leftChild = insert(node.leftChild, value);
            else if (value > node.value)
                node.rightChild = insert(node.rightChild, value);

            return node;
        }

        public static void main(String args[]){
            Tree4 tree = new Tree4();
            tree.insert(10);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);

            System.out.println("InOrder");
            tree.inOrder(tree.root);

            System.out.println("PreOrder");
            tree.preOrder(tree.root);

            System.out.println("PostOrder");
            tree.postOrder(tree.root);

        }

}
