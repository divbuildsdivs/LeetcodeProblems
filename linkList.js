class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }

    addStart(value) {
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    addEnd(value) {
        const newNode = new Node(value);
        let curr = this.head;
        if(curr ==  null) {
            this.head = newNode;
            return;
        }
        while(curr != null && curr.next !=null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }
}

const list = new LinkedList();
list.addStart(10);
list.addStart(20);
list.addEnd(30);
console.log(list);