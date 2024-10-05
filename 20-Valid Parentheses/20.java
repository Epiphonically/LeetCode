class Solution {
    public boolean isValid(String s) {
        ArrayList stack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            if (at == '(' || at == '[' || at == '{') {
                stack.add(at);
            } else {
                switch(at) {
                    case ')':
                        if (stack.size() == 0 || !stack.remove(stack.size() - 1).equals('(')) {
                            return false;
                        }
                    break;
                        
                    case '}':
                        if (stack.size() == 0 || !stack.remove(stack.size() - 1).equals('{')) {
                            return false;
                        }
                    break;

                    case ']':
                        if (stack.size() == 0 || !stack.remove(stack.size() - 1).equals('[')) {
                            return false;
                        }
                    break;
                }
            }
        }
        return(stack.size() == 0);
    }
}
