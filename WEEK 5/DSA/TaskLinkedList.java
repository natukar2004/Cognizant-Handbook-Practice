public class TaskLinkedList {
    
    public static class Task {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        public int getTaskId() {
            return taskId;
        }

        @Override
        public String toString() {
            return "Task{id=" + taskId + "}";
        }
    }

   
    private static class TaskNode {
        private final Task task;
        private TaskNode next;

        private TaskNode(Task task) {
            this.task = task;
        }
    }

    private TaskNode head;
    private TaskNode tail;
    private int size;

    public TaskLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Adds a task to the end of the list. O(1) because we track the tail. */
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Adds a task to the front of the list. O(1). */
    public void addTaskAtFront(Task task) {
        TaskNode newNode = new TaskNode(task);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /** Searches for a task by ID. Returns the Task or null if not found. O(n). */
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // not found
    }

    /** Traverses and prints every task in insertion order. O(n). */
    public void traverse() {
        if (head == null) {
            System.out.println("No tasks in the system.");
            return;
        }
        TaskNode current = head;
        System.out.println("--- Task List ---");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
        System.out.println("-----------------");
    }

    
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        // Case 1: deleting the head node
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            if (head == null) { // list became empty
                tail = null;
            }
            size--;
            return true;
        }

        // Case 2: search for the node whose `next` matches the target
        TaskNode prev = head;
        TaskNode current = head.next;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                prev.next = current.next;
                if (current == tail) { 
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // taskId not found
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}