import java.util.ArrayList;

// ===== Implement Min Heap from Scratch using ArrayList =====
// push():  O(log n) | pop(): O(log n) | peek(): O(1) | size(): O(1)
// Space Complexity: O(n)
class minHeap {
    ArrayList<Integer> heap;

    public minHeap() {
        heap = new ArrayList<>();
    }

    // Insert x and bubble up to maintain heap property
    public void push(int x) {
        heap.add(x);
        int idx = heap.size() - 1;

        while (idx > 0) {
            int parent = (idx - 1) / 2;

            if (heap.get(parent) <= heap.get(idx)) break;

            // Swap with parent
            int temp = heap.get(parent);
            heap.set(parent, heap.get(idx));
            heap.set(idx, temp);

            idx = parent;
        }
    }

    // Remove the minimum (root), replace with last element, and heapify down
    public void pop() {
        if (heap.isEmpty()) return;

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int i = 0;
        while (i < heap.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() && heap.get(smallest) > heap.get(left)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(smallest) > heap.get(right)) {
                smallest = right;
            }
            if (smallest == i) return;

            // Swap with smallest child
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            i = smallest;
        }
    }

    // Return the minimum element without removing it
    public int peek() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    // Return number of elements in the heap
    public int size() {
        return heap.size();
    }
}
