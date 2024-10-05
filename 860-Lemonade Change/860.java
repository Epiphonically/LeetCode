class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] bank = {0, 0, 0};
        for (int i = 0; i < bills.length; i++) {
            switch(bills[i]) {
                case 5:
                    bank[0]++;
                break;
               
                case 10:
                    if (bank[0] == 0) {
                        return false;
                    } else {
                        bank[0]--;
                        bank[1]++;
                    }
                break;
                
                case 20:
                    if (bank[1] == 0) {
                        if (bank[0] < 3) {
                            return false;
                        } else {
                            bank[0] -= 3;
                            bank[2]++;
                        }
                    } else {
                        bank[1]--;
                        if (bank[0] == 0) {
                            return false;
                        } else {
                            bank[0]--;
                            bank[2]++;
                        }
                    }
                break;
            }
        }

        return true;
    }
}
