import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    void create(int n) {
        Scanner scanner = new Scanner(System.in);
        Node current = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the data of node " + (i + 1) + ": ");
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
                current = this.head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }
    }

    void display() {
        Node temp = this.head;
        if (temp == null) {
            System.out.println("List is EMPTY");
            return;
        }
        while (temp != null) {
            System.out.println("DATA IS -> " + temp.data);
            temp = temp.next;
        }
    }

    int count() {
        Node temp = this.head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    int sum() {
        Node temp = this.head;
        int total = 0;
        while (temp != null) {
            total += temp.data;
            temp = temp.next;
        }
        return total;
    }

    void insertPos(int data) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position to insert: ");
        int pos = scanner.nextInt();
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node temp = this.head;
            for (int i = 1; i < pos - 1; i++) {
                if (temp == null) {
                    System.out.println("Invalid position");
                    return;
                }
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    int search(int key) {
        Node temp = this.head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    void deleteRa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position to delete: ");
        int pos = scanner.nextInt();
        if (pos == 1) {
            Node deletedNode = this.head;
            this.head = this.head.next;
            deletedNode = null;
        } else {
            Node temp = this.head;
            for (int i = 1; i < pos - 1; i++) {
                if (temp == null || temp.next == null) {
                    System.out.println("Invalid position");
                    return;
                }
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                System.out.println("Invalid position");
                return;
            }
            Node deletedNode = temp.next;
            temp.next = temp.next.next;
            deletedNode = null;
        }
    }

    void delSLL() {
        Node temp = this.head;
        while (temp != null) {
            Node deletedNode = temp;
            temp = temp.next;
            deletedNode = null;
        }
        this.head = null;
        System.out.println("Successfully deleted all nodes");
    }

    boolean chsorte() {
        Node temp = this.head;
        int x = Integer.MIN_VALUE;
        while (temp != null) {
            if (temp.data < x) {
                return false;
            }
            x = temp.data;
            temp = temp.next;
        }
        return true;
    }

    void dupl() {
        Node current = this.head;
        while (current != null) {
            Node index = current;
            while (index.next != null) {
                if (current.data == index.next.data) {
                    Node deletedNode = index.next;
                    index.next = index.next.next;
                    deletedNode = null;
                } else {
                    index = index.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicates successfully removed");
    }

    void Asortt() {
        Node p = this.head;
        while (p.next != null) {
            Node q = p.next;
            while (q != null) {
                if (p.data > q.data) {
                    int temp = p.data;
                    p.data = q.data;
                    q.data = temp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }

    void revr() {
        Node p = this.head;
        int[] A = new int[count()];
        int i = 0;
        while (p != null) {
            A[i++] = p.data;
            p = p.next;
        }
        p = this.head;
        i = A.length - 1;
        while (p != null) {
            p.data = A[i--];
            p = p.next;
        }
    }

    int getnode(int index) {
        Node current = this.head;
        int length = 0;
        while (current != null) {
            if (length == index) {
                return current.data;
            }
            length++;
            current = current.next;
        }
        return -1;
    }

    boolean detectandremov() {
        Node slow = this.head;
        Node fast = this.head;
        Node prev = null;

        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeloop(prev);
                System.out.println("Cycle detected and removed.");
                return true;
            }
        }
        System.out.println("No cycle detected.");
        return false;
    }

    void removeloop(Node prev) {
        Node start = this.head;
        Node loop = prev.next;

        while (start != loop) {
            start = start.next;
            prev = loop;
            loop = loop.next;
        }
        prev.next = null;
    }

    void getend(int pos) {
        int length = 0;
        Node p = this.head;
        while (p != null) {
            p = p.next;
            length++;
        }

        if (length < pos) {
            System.out.println("Out of range");
            return;
        }

        p = this.head;
        for (int i = 1; i < length - pos + 1; i++) {
            p = p.next;
        }

        System.out.println(p.data + " is the data");
    }

    int occurence(int sf) {
        Node p = this.head;
        int count = 0;
        while (p != null) {
            if (p.data == sf) {
                count++;
            }
            p = p.next;
        }
        return count;
    }

    void swapNodes(int x, int y) {
        if (x == y) {
            return;
        }

        Node prevX = null;
        Node currX = this.head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = this.head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            this.head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            this.head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    void pairwiseswap() {
        Node current = this.head;
        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Create\n2. Display\n3. Count\n4. Sum of all nodes\n5. Anywhere insert");
            System.out.println("6. Search an element\n7. Delete option\n8. Check Sort\n9. Remove duplicate\n10. To Reverse");
            System.out.println("11. Get node data\n12. Check for cycle detection\n13. Get node from end\n14. Occurrence of data");
            System.out.println("15. Swap nodes in a linked list\n16. Pairwise swap\n17. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of nodes: ");
                    int n = scanner.nextInt();
                    linkedList.create(n);
                    break;
                case 2:
                    System.out.println("The nodes are:");
                    linkedList.display();
                    break;
                case 3:
                    int t = linkedList.count();
                    System.out.println("The length of the linked list: " + t);
                    break;
                case 4:
                    int s = linkedList.sum();
                    System.out.println("The sum of all elements in the linked list is: " + s);
                    break;
                case 5:
                    System.out.print("Enter the item to be inserted: ");
                    int data = scanner.nextInt();
                    linkedList.insertPos(data);
                    break;
                case 6:
                    System.out.print("Enter element to search: ");
                    int keyse = scanner.nextInt();
                    int index = linkedList.search(keyse);
                    if (index >= 0) {
                        System.out.println(keyse + " found at position " + (index + 1));
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 7:
                    System.out.println("1. Delete a node\n2. Delete the linked list");
                    System.out.print("Enter your choice: ");
                    int chh = scanner.nextInt();
                    if (chh == 1) {
                        linkedList.deleteRa();
                    } else {
                        linkedList.delSLL();
                    }
                    break;
                case 8:
                    if (linkedList.chsorte()) {
                        System.out.println("The list is sorted.");
                    } else {
                        System.out.println("The list is not sorted.");
                        System.out.print("Do you want to sort the list (y/n): ");
                        char ask = scanner.next().charAt(0);
                        if (ask == 'y') {
                            linkedList.Asortt();
                            linkedList.display();
                        }
                    }
                    break;
                case 9:
                    linkedList.dupl();
                    break;
                case 10:
                    linkedList.revr();
                    linkedList.display();
                    break;
                case 11:
                    System.out.print("Enter position of node to get Data: ");
                    int ind = scanner.nextInt();
                    int dat = linkedList.getnode(ind - 1);
                    if (dat != -1) {
                        System.out.println("Nth Node data of LinkedList is: " + dat);
                    }
                    break;
                case 12:
                    linkedList.detectandremov();
                    break;
                case 13:
                    System.out.print("Enter a position to get a value: ");
                    int pos = scanner.nextInt();
                    linkedList.getend(pos);
                    break;
                case 14:
                    System.out.print("Enter the data to see its frequency: ");
                    int sf = scanner.nextInt();
                    int count = linkedList.occurence(sf);
                    System.out.println("Count of " + sf + " is " + count);
                    break;
                case 15:
                    System.out.print("Enter the numbers to be swapped: ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println("Before swapping:");
                    linkedList.display();
                    linkedList.swapNodes(x, y);
                    System.out.println("After swapping:");
                    linkedList.display();
                    break;
                case 16:
                    System.out.println("Before swapping:");
                    linkedList.display();
                    System.out.println("After pairwise swapping:");
                    linkedList.pairwiseswap();
                    linkedList.display();
                    break;
                case 17:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}
