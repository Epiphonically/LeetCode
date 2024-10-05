class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dist = 0;
        int add = 0;
        for (int i = 0; i < moves.length(); i++) {
            char at = moves.charAt(i);
            switch (at) {
                case 'L':
                    dist--;
                break;

                case 'R':
                    dist++;
                break;

                case '_':
                    add++;
                break;
            }
        }
        if (dist >= 0) {
            dist +=add;
        } else {
            dist -= add;
            dist *= -1;
        }
        return dist;
    }
}
