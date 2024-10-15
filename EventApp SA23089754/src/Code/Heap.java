/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author SA23089754
 */
public class Heap {
    
    Member heapArray[];
    private int maxSize;
    private int heapSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new Member[maxSize];
        heapSize = 0;
    }
    public int getmaxSize(){
        return maxSize;
    }
    public int getHeapSize() {
    return heapSize;
}

    public boolean insert(Member m) {
        if (heapSize == maxSize) {
            return false;
        } else {
            heapArray[heapSize] = m;
            trickleUp(heapSize++);
            return true;
        }
    }

    public Member getRoot() {
        if (heapSize == 0) {
            System.out.println("Heap is Empty");
            return null;
        }
        return heapArray[0];
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Member bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getNumber() < bottom.getNumber()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Member remove() {
        Member root = heapArray[0];
        heapArray[0] = heapArray[--heapSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Member top = heapArray[index];
        while (index < heapSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (rightChild < heapSize && heapArray[leftChild].getNumber() < heapArray[rightChild].getNumber()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getNumber() >= heapArray[largerChild].getNumber()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;

    }
    
}
