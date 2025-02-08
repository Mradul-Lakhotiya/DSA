class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numToInd;
    private Map<Integer, Integer> indToNum;
    
    public NumberContainers() {
        numToInd = new HashMap<>();
        indToNum = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indToNum.containsKey(index)) {
            int prevNum = indToNum.get(index);
            numToInd.get(prevNum).remove(index);

            if (numToInd.get(prevNum).isEmpty()) {
                numToInd.remove(prevNum);
            }
        }

        indToNum.put(index, number);
        numToInd.putIfAbsent(number, new TreeSet<>());
        numToInd.get(number).add(index);
    }
    
    public int find(int number) {
        if (numToInd.containsKey(number)) {
            return numToInd.get(number).first(); // Get the smallest index
        }

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */