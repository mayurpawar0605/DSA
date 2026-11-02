class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int asteroid : asteroids) {

            if (st.isEmpty() || asteroid >= 0) {
                st.push(asteroid);
            } else {
                //we get negative asteroid
                boolean destroyed = false;
                if (!st.isEmpty() && st.peek() < 0) {
                    //both entity are negative -> no collision
                    st.push(asteroid);
                }
                //destroyed shows wheteher asteroid is alive or destroyed
                
                else {
                    while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                    if (st.peek() < -asteroid) {
                        //stack ke top ka ast destroyrd ho jayega
                        st.pop();
                        continue;
                    } else if (st.peek() > -asteroid) {
                        //ast destoy ho jayega
                        //no need to insert in stack
                        destroyed = true;
                        //no need to check other element sin stack
                        break;
                    } else {
                        //st.peek() == atsroid
                        //dono asteropid explodes hop jayega
                        st.pop();
                        destroyed = true;
                        //no need to check other element sin stack
                        break;
                    }
                }

                if (destroyed == false) {
                    st.push(asteroid);
                }
                }
            }
        }

        //ans is in stack
        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;

    }
}