package test.ct;

public class DocumentCounter {
    public static void main(String[] args) {
        DocumentNameCreator documentNameCreator = new DocumentNameCreator(1, "t");

        String newDocumentName = documentNameCreator.getNewDocumentName();
        int andIncrement = documentNameCreator.getAndIncrement();
        System.out.println("newDocumentName = " + newDocumentName);
        System.out.println("andIncrement = " + andIncrement);
    }

    public static class Counter {
        private int count = 0;
        private int increment;

        public Counter(int increment) {
            this.increment = increment;
        }

        protected int getAndIncrement() {
            this.count += this.increment;
            return this.count;
        }
    }

    public static class DocumentNameCreator extends Counter {
        private String prefix;

        public DocumentNameCreator(int increment, String prefix) {
            super(increment);
            this.prefix = prefix;
        }

        public DocumentNameCreator(String prefix, Counter counter) {
            super(counter.count);
            this.prefix = prefix;
        }

        public String getNewDocumentName() {
            return prefix + getAndIncrement();
        }
    }
}
