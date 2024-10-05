class Solution {
    class Tuple {
        int x;
        int y;
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
    }
    public String fractionAddition(String expression) {
        String store = "";
        int numer = 0;
        int denom = 0;
        int j = 0;
        Tuple currFrac = new Tuple(0, 1);
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                for (j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) == '/') {
                        numer = Integer.parseInt(store);
                        j++;
                        store = "";
                        break;
                    }
                    store += expression.charAt(j);
                }
                for (j = j; j < expression.length(); j++) {
                    if (expression.charAt(j) == '-' || expression.charAt(j) == '+') {
                        break;
                    }
                    store += expression.charAt(j);
                }
                denom = Integer.parseInt(store);
                store = "";
                currFrac = add(currFrac, new Tuple(-1 * numer, denom));
            } else if (expression.charAt(i) == '+' || i == 0) {
                j = i + 1;
                if (i == 0) {
                    j = i;
                }
                for (j = j; j < expression.length(); j++) {
                    if (expression.charAt(j) == '/') {
                        numer = Integer.parseInt(store);
                        j++;
                        store = "";
                        break;
                    }
                    store += expression.charAt(j);
                }
                for (j = j; j < expression.length(); j++) {
                    if (expression.charAt(j) == '-' || expression.charAt(j) == '+') {
                        break;
                    }
                    store += expression.charAt(j);
                }
                denom = Integer.parseInt(store);
                store = "";
                currFrac = add(currFrac, new Tuple(numer, denom));
            }
        }
       
        return (currFrac.x + "/" + currFrac.y);
    }

    public Tuple add(Tuple f1, Tuple f2) {
        int commonDenom = f1.y * f2.y;
        int commonNum = (f1.x * f2.y) + (f2.x * f1.y);
        if (commonNum == 0) {
            return (new Tuple(0, 1));
        }
        int gcd = 1;
        for (int i = 1; i <= Math.min(Math.abs(commonDenom), Math.abs(commonNum)); i++) {
            
            if ((Math.abs(commonDenom) % i) == 0 && (Math.abs(commonNum) % i) == 0) {
                
                gcd = i;
            }
        }
        commonDenom /= gcd;
        commonNum /= gcd;
        if (commonDenom < 0) {
            commonDenom *= -1;
            commonNum *= -1;
        }
        System.out.println(commonNum + ", " + commonDenom);
        return (new Tuple(commonNum, commonDenom));

    }
}
