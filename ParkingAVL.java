class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        height = 1;
    }
}

public class ParkingAVL {

    AVLNode root;

    int height(AVLNode n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(AVLNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    AVLNode rightRotate(AVLNode y) {
        System.out.println("Right Rotation at Slot " + y.key);

        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        System.out.println("Left Rotation at Slot " + x.key);

        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    AVLNode insert(AVLNode node, int key) {

        if (node == null) {
            System.out.println("Insert Slot " + key);
            return new AVLNode(key);
        }

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        return node;
    }

    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        ParkingAVL tree = new ParkingAVL();

        int slots[] = {10,20,30,40,50,60};

        for(int slot : slots)
            tree.root = tree.insert(tree.root, slot);

        System.out.println("\nFinal Parking Slot Order:");
        tree.inorder(tree.root);
    }
}